package com.elpepe.uhc.item.armor;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1309;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public class EffectArmor extends class_1738 implements TickableArmor {
   private final List<ArmorEffect> armorEffects = new ArrayList();
   private final List<String> tooltips = new ArrayList();

   public EffectArmor(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
   }

   public void tick(class_1309 user) {
      if (!user.method_37908().method_8608()) {
         this.armorEffects.forEach((armorEffect) -> {
            user.method_6092(new class_1293(armorEffect.effect, armorEffect.duration, armorEffect.amplifier, true, false, false));
         });
      }

   }

   public EffectArmor addArmorEffect(class_1291 effect, int amplifier) {
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

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         this.tooltips.forEach((tip) -> {
            tooltip.add(class_2561.method_43471(tip));
         });
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

      super.method_7851(stack, world, tooltip, context);
   }

   public static record ArmorEffect(class_1291 effect, int duration, int amplifier) {
      public ArmorEffect(class_1291 effect, int duration, int amplifier) {
         this.effect = effect;
         this.duration = duration;
         this.amplifier = amplifier;
      }

      public class_1291 effect() {
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
