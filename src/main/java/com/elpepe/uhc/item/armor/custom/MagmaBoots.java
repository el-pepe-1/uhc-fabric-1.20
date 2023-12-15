package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2561;
import net.minecraft.class_437;
import net.minecraft.class_5134;
import net.minecraft.class_1322.class_1323;
import org.jetbrains.annotations.Nullable;

public class MagmaBoots extends class_1738 implements TickableArmor {
   private final Multimap<class_1320, class_1322> defaultModifiers;

   public MagmaBoots(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
      ImmutableMultimap.Builder<class_1320, class_1322> builder = ImmutableMultimap.builder();
      builder.put(class_5134.field_23724, new class_1322("Armor modifier", (double)material.method_48403(type), class_1323.field_6328));
      builder.put(class_5134.field_23725, new class_1322("Armor toughness", (double)material.method_7700(), class_1323.field_6328));
      builder.put(class_5134.field_23716, new class_1322("Armor health", -0.5, class_1323.field_6330));
      this.defaultModifiers = builder.build();
   }

   public Multimap<class_1320, class_1322> method_7844(class_1304 slot) {
      return slot == this.field_41933.method_48399() ? this.defaultModifiers : super.method_7844(slot);
   }

   public void tick(class_1309 user) {
      if (user.method_25936().method_26204().equals(class_2246.field_10164)) {
         user.method_23327(user.method_23317(), (double)(user.method_23312().method_10264() + 1), user.method_23321());
         user.method_18800(user.method_18798().method_10216(), 0.0, user.method_18798().method_10215());
         user.method_20803(0);
         user.method_6092(new class_1293(class_1294.field_5918, 5, 0, true, false, false));
      }

   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         tooltip.add(class_2561.method_43471("tooltip.uhc.magma_boots"));
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

      super.method_7851(stack, world, tooltip, context);
   }
}
