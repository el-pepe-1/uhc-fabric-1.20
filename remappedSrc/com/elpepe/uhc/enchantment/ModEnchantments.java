package com.elpepe.uhc.enchantment;

import com.elpepe.uhc.Uhc;
import net.minecraft.class_1304;
import net.minecraft.class_1887;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import net.minecraft.class_1887.class_1888;

public class ModEnchantments {
   public static final class_1887 BULLDOZER;
   public static final class_1887 CREEP_ENCHANTMENT;

   public ModEnchantments() {
   }

   private static class_1887 register(String name, class_1887 enchantment) {
      return (class_1887)class_2378.method_10230(class_7923.field_41176, new class_2960("uhc", name), enchantment);
   }

   public static void registerEnchantments() {
      Uhc.LOGGER.info("Registering enchantments for uhc");
   }

   static {
      BULLDOZER = register("bulldozer", new BulldozerEnchantment(class_1888.field_9091, new class_1304[]{class_1304.field_6173}));
      CREEP_ENCHANTMENT = register("creep_enchantment", new CreepEnchantment(class_1888.field_9088, new class_1304[]{class_1304.field_6173}));
   }
}
