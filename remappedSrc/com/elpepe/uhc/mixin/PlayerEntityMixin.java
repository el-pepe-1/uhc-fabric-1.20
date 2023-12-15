package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.armor.custom.SlimeBoots;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_3414;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1657.class})
public abstract class PlayerEntityMixin extends class_1309 {
   @Shadow
   public abstract void method_5783(class_3414 var1, float var2, float var3);

   protected PlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
      super(entityType, world);
   }

   @Inject(
      at = {@At("TAIL")},
      method = {"jump"}
   )
   private void onJump(CallbackInfo info) {
      this.method_5661().forEach((stack) -> {
         if (stack.method_7909() instanceof SlimeBoots) {
            SlimeBoots.onJump(this.method_37908(), this);
            SlimeBoots.slimeParticles(this.method_37908(), this.method_19538());
         }

      });
   }
}
