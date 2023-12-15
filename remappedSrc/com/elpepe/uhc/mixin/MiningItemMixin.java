package com.elpepe.uhc.mixin;

import com.elpepe.uhc.enchantment.BulldozerEnchantment;
import com.elpepe.uhc.enchantment.ModEnchantments;
import net.minecraft.class_1309;
import net.minecraft.class_1766;
import net.minecraft.class_1799;
import net.minecraft.class_1810;
import net.minecraft.class_1890;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1766.class})
public abstract class MiningItemMixin {
   public MiningItemMixin() {
   }

   @Inject(
      method = {"postMine"},
      at = {@At("HEAD")}
   )
   private void postMine(class_1799 stack, class_1937 world, class_2680 state, class_2338 pos, class_1309 miner, CallbackInfoReturnable<Boolean> cir) {
      if (stack.method_7909() instanceof class_1810) {
         int lvl = class_1890.method_8225(ModEnchantments.BULLDOZER, stack);
         if (lvl > 0) {
            BulldozerEnchantment.postMine(world, pos, miner, stack, state);
         }
      }

   }
}
