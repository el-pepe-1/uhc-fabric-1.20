package com.elpepe.uhc.mixin;

import com.elpepe.uhc.effect.ModEffects;
import com.elpepe.uhc.entity.ModEntityAttributes;
import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.item.armor.TickableArmor;
import com.elpepe.uhc.item.armor.custom.SlimeBoots;
import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1268;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_8149;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1309.class})
public abstract class LivingEntityMixin extends class_1297 implements class_8149 {
   public LivingEntityMixin(class_1299<?> type, class_1937 world) {
      super(type, world);
   }

   @Inject(
      method = {"createLivingAttributes"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void createLivingAttributes(CallbackInfoReturnable<class_5132.class_5133> cir) {
      cir.setReturnValue(class_5132.method_26861().method_26867(class_5134.field_23716).method_26867(class_5134.field_23718).method_26867(class_5134.field_23719).method_26867(class_5134.field_23724).method_26867(class_5134.field_23725).method_26868(ModEntityAttributes.STEP_HEIGHT, 0.6));
   }

   @Inject(
      method = {"getStepHeight"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getStepHeight(CallbackInfoReturnable<Float> cir) {
      class_1309 entity = (class_1309)this;
      if (!(entity.method_5642() instanceof class_1657)) {
         double stepHeight = entity.method_26825(ModEntityAttributes.STEP_HEIGHT);
         cir.setReturnValue((float)stepHeight);
      }

   }

   @Inject(
      method = {"jump"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jump(CallbackInfo ci) {
      class_1309 entity = (class_1309)this;
      if (entity.method_6059(ModEffects.FOX_GRACE_EFFECT)) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"handleFallDamage"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void handleFallDamage(CallbackInfoReturnable<Boolean> cir) {
      this.method_5661().forEach((stack) -> {
         if (stack.method_7909() instanceof SlimeBoots && !this.method_5715()) {
            cir.setReturnValue(false);
         }

      });
   }

   @Inject(
      at = {@At("HEAD")},
      method = {"tick"}
   )
   private void tick(CallbackInfo info) {
      class_1309 entity = (class_1309)this;
      entity.method_5661().forEach((stack) -> {
         if (stack.method_7909() instanceof TickableArmor) {
            ((TickableArmor)stack.method_7909()).tick(entity);
         }

      });
   }

   @ModifyVariable(
      method = {"tryUseTotem"},
      at = @At("STORE"),
      ordinal = 0
   )
   private class_1799 tryUseTotem(class_1799 value) {
      if (value == null) {
         class_1309 entity = (class_1309)this;
         class_1268[] var3 = class_1268.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            class_1268 hand = var3[var5];
            class_1799 itemStack2 = entity.method_5998(hand);
            if (itemStack2.method_31574(ModItems.RUBY_TOTEM)) {
               value = itemStack2.method_7972();
               itemStack2.method_7956(1, entity, (livingEntity) -> {
                  livingEntity.method_20236(hand);
               });
               break;
            }
         }
      }

      return value;
   }

   @Inject(
      at = {@At("TAIL")},
      method = {"applyDamage"}
   )
   private void applyDamage(class_1282 source, float amount, CallbackInfo ci) {
      class_1297 var5 = source.method_5529();
      if (var5 instanceof class_3222 serverPlayer) {
         if (serverPlayer.method_6118(class_1304.field_6169).method_31574(ModItems.NIGHT_VISION_HELMET)) {
            class_1309 entity = (class_1309)this;
            class_2540 buf = PacketByteBufs.create();
            buf.writeFloat(entity.method_6032());
            ServerPlayNetworking.send(serverPlayer, ModMessages.DAMAGE_SYNC_ID, buf);
         }
      }

   }
}
