package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.ModItems;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2602;
import net.minecraft.class_634;
import net.minecraft.class_7633;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkHandlerMixin implements class_7633, class_2602 {
   public ClientPlayNetworkHandlerMixin() {
   }

   @Inject(
      method = {"getActiveTotemOfUndying"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void getActiveTotemOfUndying(class_1657 player, CallbackInfoReturnable<class_1799> cir) {
      class_1268[] var2 = class_1268.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_1268 hand = var2[var4];
         class_1799 itemStack = player.method_5998(hand);
         if (itemStack.method_31574(ModItems.RUBY_TOTEM)) {
            cir.setReturnValue(itemStack);
         }
      }

   }
}
