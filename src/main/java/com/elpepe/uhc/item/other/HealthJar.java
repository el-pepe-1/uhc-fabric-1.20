package com.elpepe.uhc.item.other;

import com.elpepe.uhc.sound.ModSounds;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1836;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_437;
import net.minecraft.class_5251;
import net.minecraft.class_5328;
import org.jetbrains.annotations.Nullable;

public class HealthJar extends class_1792 {
   private static final int MAX_USE_TIME = 80;
   private static final float HEAL_AMOUNT = 4.0F;

   public HealthJar(class_1792.class_1793 settings) {
      super(settings);
   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         class_2583 style = class_2583.field_24360.method_27703(class_5251.method_27718(class_124.field_1061));
         tooltip.add(class_2561.method_43471("tooltip.uhc.health_jar").method_10862(style));
      } else {
         tooltip.add(class_2561.method_43469("tooltip.uhc.press_for_info", new Object[]{""}));
      }

      super.method_7851(stack, world, tooltip, context);
   }

   public class_1799 method_7861(class_1799 stack, class_1937 world, class_1309 user) {
      super.method_7861(stack, world, user);
      world.method_8486(user.method_23317(), user.method_23318(), user.method_23321(), ModSounds.HEALTH_JAR_CONSUME, class_3419.field_15250, 1.0F, 1.0F, true);
      if (!world.method_8608() && user instanceof class_1657 playerEntity) {
         user.method_6025(4.0F);
         if (!playerEntity.method_31549().field_7477) {
            class_1799 itemStack = new class_1799(class_1802.field_8469);
            stack.method_7934(1);
            if (!playerEntity.method_31548().method_7394(itemStack)) {
               playerEntity.method_7328(itemStack, false);
            }
         }
      }

      return stack;
   }

   public class_1839 method_7853(class_1799 stack) {
      return class_1839.field_8946;
   }

   public class_3414 method_21831() {
      return class_3417.field_20615;
   }

   public class_3414 method_21830() {
      return class_3417.field_20615;
   }

   public int method_7881(class_1799 stack) {
      return 80;
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      return class_5328.method_29282(world, user, hand);
   }
}
