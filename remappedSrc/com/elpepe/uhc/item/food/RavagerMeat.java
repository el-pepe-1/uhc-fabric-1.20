package com.elpepe.uhc.item.food;

import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_5328;

public class RavagerMeat extends class_1792 {
   private static final int MAX_USAGE_TIME = 100;

   public RavagerMeat(class_1792.class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      return class_5328.method_29282(world, user, hand);
   }

   public class_1839 method_7853(class_1799 stack) {
      return class_1839.field_8950;
   }

   public int method_7881(class_1799 stack) {
      return 100;
   }
}
