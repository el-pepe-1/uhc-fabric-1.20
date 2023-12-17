package com.elpepe.uhc.mixin;

import com.elpepe.uhc.enchantment.BulldozerEnchantment;
import com.elpepe.uhc.enchantment.ModEnchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({MiningToolItem.class})
public abstract class MiningItemMixin {
   @Inject(
      method = "postMine",
      at = {@At("HEAD")}
   )
   private void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner, CallbackInfoReturnable<Boolean> cir) {
      if (stack.getItem() instanceof PickaxeItem) {
         int lvl = EnchantmentHelper.getLevel(ModEnchantments.BULLDOZER, stack);
         if (lvl > 0) {
            BulldozerEnchantment.postMine(world, pos, miner, stack, state);
         }
      }

   }
}
