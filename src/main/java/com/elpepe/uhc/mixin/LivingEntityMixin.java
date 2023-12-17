package com.elpepe.uhc.mixin;

import com.elpepe.uhc.effect.ModEffects;
import com.elpepe.uhc.entity.ModEntityAttributes;
import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.item.armor.TickableArmor;
import com.elpepe.uhc.item.armor.custom.SlimeBootsItem;
import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "createLivingAttributes", at = @At("HEAD"), cancellable = true)
    private static void createLivingAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.setReturnValue(DefaultAttributeContainer.builder()
                .add(EntityAttributes.GENERIC_MAX_HEALTH)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                .add(EntityAttributes.GENERIC_ARMOR)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS)
                .add(ModEntityAttributes.STEP_HEIGHT, 0.6));
    }

    @Shadow
    public abstract Iterable<ItemStack> getArmorItems();

    @Inject(method = "getStepHeight", at = @At("HEAD"), cancellable = true)
    public void getStepHeight(CallbackInfoReturnable<Float> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!(entity.getControllingPassenger() instanceof PlayerEntity)) {
            double stepHeight = entity.getAttributeValue(ModEntityAttributes.STEP_HEIGHT);
            cir.setReturnValue((float) stepHeight);
        }
    }

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void jump(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.hasStatusEffect(ModEffects.FOX_GRACE_EFFECT)) {
            ci.cancel();
        }
    }

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void handleFallDamage(CallbackInfoReturnable<Boolean> cir) {
        getArmorItems().forEach(stack -> {
            if (stack.getItem() instanceof SlimeBootsItem && !this.isSneaking()) {
                cir.setReturnValue(false);
            }
        });
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        LivingEntity entity = (LivingEntity) (Object) this;
        entity.getArmorItems().forEach(stack -> {
            if (stack.getItem() instanceof TickableArmor) {
                ((TickableArmor) stack.getItem()).tick(entity);
            }
        });
    }

    @ModifyVariable(method = "tryUseTotem", at = @At("STORE"), ordinal = 0)
    private ItemStack tryUseTotem(ItemStack usedTotem) {
        if (usedTotem == null) {
            LivingEntity entity = (LivingEntity) (Object) this;
            for (Hand hand : Hand.values()) {
                ItemStack stackInHand = entity.getStackInHand(hand);
                if (stackInHand.isOf(ModItems.RUBY_TOTEM)) {
                    usedTotem = stackInHand.copy();
                    stackInHand.damage(1, entity, livingEntity -> livingEntity.sendToolBreakStatus(hand));
                    break;
                }
            }
        }

        return usedTotem;
    }

    @Inject(at = @At("TAIL"), method = "applyDamage")
    private void applyDamage(DamageSource source, float amount, CallbackInfo ci) {
        if (source.getAttacker() instanceof ServerPlayerEntity serverPlayer) {
            if (serverPlayer.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.NIGHT_VISION_HELMET)) {
                LivingEntity entity = (LivingEntity) (Object) this;
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeFloat(entity.getHealth());
                ServerPlayNetworking.send(serverPlayer, ModMessages.DAMAGE_SYNC_ID, buf);
            }
        }
    }
}
