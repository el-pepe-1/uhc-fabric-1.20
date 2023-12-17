package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.EffectArmor;
import java.util.List;
import net.minecraft.util.Formatting;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class NightVisionHelmetItem extends EffectArmor {
   public NightVisionHelmetItem(ArmorMaterial material, ArmorItem.class_8051 type, Item.class_1793 settings) {
      super(material, type, settings);
   }

   public void tick(LivingEntity user) {
      ItemStack stack = user.getEquippedStack(EquipmentSlot.HEAD);
      if (isBroken(stack)) {
         user.equipStack(EquipmentSlot.HEAD, ItemStack.EMPTY);
         if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)user;
            player.giveItemStack(stack.copy());
         }
      }

      if (user.getRandom().nextBetween(1, 3) == 3) {
         stack.damage(1, user, (entity) -> {
            entity.sendEquipmentBreakStatus(EquipmentSlot.HEAD);
         });
      }

      super.tick(user);
   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         tooltip.add(Text.literal("▶ ").formatted(Formatting.GOLD).append(Text.translatable("tooltip.uhc.night_vision_helmet_1")));
         tooltip.add(Text.literal(" "));
         tooltip.add(Text.literal("▶ ").formatted(Formatting.GOLD).append(Text.translatable("tooltip.uhc.night_vision_helmet_2")));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
      }

   }

   public static boolean isBroken(ItemStack stack) {
      return stack.getDamage() >= stack.getMaxDamage() - 1;
   }
}
