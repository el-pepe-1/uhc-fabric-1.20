package com.elpepe.uhc.entity;

import com.elpepe.uhc.Uhc;
import net.minecraft.class_1320;
import net.minecraft.class_1329;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModEntityAttributes {
   public static final class_1320 STEP_HEIGHT = registerAttribute("step_height", (new class_1329("generic.step_height", 0.6, 0.0, 128.0)).method_26829(true));

   public ModEntityAttributes() {
   }

   private static class_1320 registerAttribute(String name, class_1320 attribute) {
      return (class_1320)class_2378.method_10230(class_7923.field_41190, new class_2960("uhc", name), attribute);
   }

   public static void registerAttributes() {
      Uhc.LOGGER.info("Registering Mod Attributes for uhc");
   }
}
