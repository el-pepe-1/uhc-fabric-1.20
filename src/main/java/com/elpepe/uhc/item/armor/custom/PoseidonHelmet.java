package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import java.util.List;
import net.minecraft.util.Formatting;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class PoseidonHelmet extends ArmorItem implements TickableArmor {
   public PoseidonHelmet(ArmorMaterial material, ArmorItem.class_8051 type, Item.class_1793 settings) {
      super(material, type, settings);
   }

   public void tick(LivingEntity user) {
      World world = user.getWorld();
      if (!world.isClient() && user.isTouchingWaterOrRain()) {
         user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 5, 0, true, false, false));
         user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 5, 0, true, false, false));
         user.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 5, 0, true, false, false));
         user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5, 0, true, false, false));
         user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 0, true, false, false));
      }

   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         Style style = Style.EMPTY.withColor(Formatting.AQUA);
         tooltip.add(Text.translatable("tooltip.uhc.poseidon_helmet").setStyle(style));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info", new Object[]{""}));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }
}
