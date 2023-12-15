package com.elpepe.uhc.effect;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.ModEntityAttributes;
import net.minecraft.class_1291;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4081;
import net.minecraft.class_5134;
import net.minecraft.class_7923;
import net.minecraft.class_1322.class_1323;

public class ModEffects {
   public static final class_1291 FOX_GRACE_EFFECT;

   public ModEffects() {
   }

   private static class_1291 registerEffect(String name, class_1291 effect) {
      return (class_1291)class_2378.method_10230(class_7923.field_41174, new class_2960("uhc", name), effect);
   }

   public static void registerEffects() {
      Uhc.LOGGER.info("Registering Mod Effects for uhc");
   }

   static {
      FOX_GRACE_EFFECT = registerEffect("fox_grace", (new FoxGraceEffect(class_4081.field_18273)).method_5566(ModEntityAttributes.STEP_HEIGHT, "a0773770-69a7-42ca-8a31-7c0b49601b53", 0.5, class_1323.field_6328).method_5566(class_5134.field_23719, "7ade48be-44d0-4d92-a6cc-fd6931a38fa8", 0.01, class_1323.field_6328));
   }
}
