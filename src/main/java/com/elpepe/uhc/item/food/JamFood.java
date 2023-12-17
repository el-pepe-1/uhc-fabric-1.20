package com.elpepe.uhc.item.food;

import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.item.ItemUsage;

public class JamFood extends Item {
   private static final int DEFAULT_USAGE_TIME = 60;
   private final int usageTime;

   public JamFood(Item.class_1793 settings) {
      super(settings);
      this.usageTime = 60;
   }

   public JamFood(Item.class_1793 settings, int usageTime) {
      super(settings);
      this.usageTime = usageTime;
   }

   public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
      if (!world.isClient()) {
         user.eatFood(world, stack);
         if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)user;
            if (!player.isCreative()) {
               if (stack.getCount() == 1) {
                  return new ItemStack(Items.GLASS_BOTTLE, 1);
               }

               player.giveItemStack(new ItemStack(Items.GLASS_BOTTLE, 1));
               stack.decrement(1);
               return stack;
            }
         }
      }

      return super.finishUsing(stack, world, user);
   }

   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      return ItemUsage.consumeHeldItem(world, user, hand);
   }

   public UseAction getUseAction(ItemStack stack) {
      return UseAction.DRINK;
   }

   public int getMaxUseTime(ItemStack stack) {
      return this.usageTime;
   }

   public SoundEvent getDrinkSound() {
      return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
   }

   public SoundEvent getEatSound() {
      return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
   }
}
