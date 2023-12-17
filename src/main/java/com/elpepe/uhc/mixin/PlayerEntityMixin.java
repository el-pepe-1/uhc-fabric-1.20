package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.armor.custom.SlimeBootsItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract void playSound(SoundEvent var1, float var2, float var3);

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(at = @At("TAIL"), method = "jump")
    private void jump(CallbackInfo info) {
        if (getEquippedStack(EquipmentSlot.FEET).getItem() instanceof SlimeBootsItem) {
            SlimeBootsItem.onJump(this.getWorld(), this);
            SlimeBootsItem.slimeParticles(this.getWorld(), this.getPos());
        }
    }
}
