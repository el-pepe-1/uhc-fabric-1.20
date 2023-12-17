package com.elpepe.uhc.item.tool;

import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import java.util.List;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class HarpoonItem extends Item {
   public HarpoonItem(Item.class_1793 settings) {
      super(settings);
   }

   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      if (!world.isClient()) {
         ItemStack stack = user.getStackInHand(hand);
         HarpoonProjectileEntity projectile = new HarpoonProjectileEntity(world, user, stack);
         projectile.setCanFly(80);
         world.spawnEntity(projectile);
      }

      user.getItemCooldownManager().set(this, 20);
      return super.use(world, user, hand);
   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         tooltip.add(Text.translatable("tooltip.uhc.harpoon"));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }
}
