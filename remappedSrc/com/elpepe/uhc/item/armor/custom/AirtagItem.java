package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.sound.ModSounds;
import java.util.List;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_3419;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public class AirtagItem extends class_1738 {
   public AirtagItem(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         tooltip.add(class_2561.method_43471("tooltip.uhc.airtag"));
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

      super.method_7851(stack, world, tooltip, context);
   }

   public static void onDetected(class_1657 wearer, class_1799 stack) {
      wearer.method_17356(ModSounds.AIRTAG_ALARM, class_3419.field_15250, 1.0F, 1.0F);
      stack.method_7956(1, wearer, (entity) -> {
         entity.method_20235(class_1304.field_6169);
      });
   }
}
