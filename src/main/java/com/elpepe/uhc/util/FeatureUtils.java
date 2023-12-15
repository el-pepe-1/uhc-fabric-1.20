package com.elpepe.uhc.util;

import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_5281;

public class FeatureUtils {
   public FeatureUtils() {
   }

   public static void setBlock(class_5281 world, class_2338 pos, class_2680 state) {
      if (world.method_8320(pos).method_26215()) {
         world.method_8652(pos, state, 3);
      }

   }
}
