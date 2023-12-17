package com.elpepe.uhc.item.food;

import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.item.ItemUsage;

public class RavagerMeat extends Item {
   private static final int MAX_USAGE_TIME = 100;

   public RavagerMeat(Item.class_1793 settings) {
      super(settings);
   }

   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      return ItemUsage.consumeHeldItem(world, user, hand);
   }

   public UseAction getUseAction(ItemStack stack) {
      return UseAction.EAT;
   }

   public int getMaxUseTime(ItemStack stack) {
      return 100;
   }
}
