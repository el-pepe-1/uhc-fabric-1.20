package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.sound.ModSounds;
import java.util.List;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.sound.SoundCategory;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class AirtagItem extends ArmorItem {
   public AirtagItem(ArmorMaterial material, ArmorItem.class_8051 type, Item.class_1793 settings) {
      super(material, type, settings);
   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         tooltip.add(Text.translatable("tooltip.uhc.airtag"));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }

   public static void onDetected(PlayerEntity wearer, ItemStack stack) {
      wearer.playSound(ModSounds.AIRTAG_ALARM, SoundCategory.MASTER, 1.0F, 1.0F);
      stack.damage(1, wearer, (entity) -> {
         entity.sendEquipmentBreakStatus(EquipmentSlot.HEAD);
      });
   }
}
