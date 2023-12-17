package com.elpepe.uhc.item.armor;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class EffectArmor extends ArmorItem implements TickableArmor {
   private final List<ArmorEffect> armorEffects = new ArrayList();
   private final List<String> tooltips = new ArrayList();

   public EffectArmor(ArmorMaterial material, ArmorItem.class_8051 type, Item.class_1793 settings) {
      super(material, type, settings);
   }

   public void tick(LivingEntity user) {
      if (!user.getWorld().isClient()) {
         this.armorEffects.forEach((armorEffect) -> {
            user.addStatusEffect(new StatusEffectInstance(armorEffect.effect, armorEffect.duration, armorEffect.amplifier, true, false, false));
         });
      }

   }

   public EffectArmor addArmorEffect(StatusEffect effect, int amplifier) {
      return this.addArmorEffect(new ArmorEffect(effect, 5, amplifier));
   }

   public EffectArmor addArmorEffect(ArmorEffect effect) {
      this.armorEffects.add(effect);
      return this;
   }

   public EffectArmor addTooltip(String translationKey) {
      this.tooltips.add(translationKey);
      return this;
   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         this.tooltips.forEach((tip) -> {
            tooltip.add(Text.translatable(tip));
         });
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }

   public static record ArmorEffect(StatusEffect effect, int duration, int amplifier) {
      public ArmorEffect(StatusEffect effect, int duration, int amplifier) {
         this.effect = effect;
         this.duration = duration;
         this.amplifier = amplifier;
      }

      public StatusEffect effect() {
         return this.effect;
      }

      public int duration() {
         return this.duration;
      }

      public int amplifier() {
         return this.amplifier;
      }
   }
}
