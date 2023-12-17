package com.elpepe.uhc.item.other;

import com.elpepe.uhc.sound.ModSounds;
import java.util.List;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TextColor;
import net.minecraft.item.ItemUsage;
import org.jetbrains.annotations.Nullable;

public class HealthJar extends Item {
   private static final int MAX_USE_TIME = 80;
   private static final float HEAL_AMOUNT = 4.0F;

   public HealthJar(Item.class_1793 settings) {
      super(settings);
   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         Style style = Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.RED));
         tooltip.add(Text.translatable("tooltip.uhc.health_jar").setStyle(style));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info", new Object[]{""}));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }

   public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
      super.finishUsing(stack, world, user);
      world.playSound(user.getX(), user.getY(), user.getZ(), ModSounds.HEALTH_JAR_CONSUME, SoundCategory.MASTER, 1.0F, 1.0F, true);
      if (!world.isClient() && user instanceof PlayerEntity playerEntity) {
         user.heal(4.0F);
         if (!playerEntity.getAbilities().creativeMode) {
            ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
            stack.decrement(1);
            if (!playerEntity.getInventory().insertStack(itemStack)) {
               playerEntity.dropItem(itemStack, false);
            }
         }
      }

      return stack;
   }

   public UseAction getUseAction(ItemStack stack) {
      return UseAction.DRINK;
   }

   public SoundEvent getDrinkSound() {
      return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
   }

   public SoundEvent getEatSound() {
      return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
   }

   public int getMaxUseTime(ItemStack stack) {
      return 80;
   }

   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      return ItemUsage.consumeHeldItem(world, user, hand);
   }
}
