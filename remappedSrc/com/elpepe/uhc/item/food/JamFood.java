package com.elpepe.uhc.item.food;

import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5328;

public class JamFood extends class_1792 {
   private static final int DEFAULT_USAGE_TIME = 60;
   private final int usageTime;

   public JamFood(class_1792.class_1793 settings) {
      super(settings);
      this.usageTime = 60;
   }

   public JamFood(class_1792.class_1793 settings, int usageTime) {
      super(settings);
      this.usageTime = usageTime;
   }

   public class_1799 method_7861(class_1799 stack, class_1937 world, class_1309 user) {
      if (!world.method_8608()) {
         user.method_18866(world, stack);
         if (user instanceof class_1657) {
            class_1657 player = (class_1657)user;
            if (!player.method_7337()) {
               if (stack.method_7947() == 1) {
                  return new class_1799(class_1802.field_8469, 1);
               }

               player.method_7270(new class_1799(class_1802.field_8469, 1));
               stack.method_7934(1);
               return stack;
            }
         }
      }

      return super.method_7861(stack, world, user);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      return class_5328.method_29282(world, user, hand);
   }

   public class_1839 method_7853(class_1799 stack) {
      return class_1839.field_8946;
   }

   public int method_7881(class_1799 stack) {
      return this.usageTime;
   }

   public class_3414 method_21831() {
      return class_3417.field_20615;
   }

   public class_3414 method_21830() {
      return class_3417.field_20615;
   }
}
