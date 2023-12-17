package com.elpepe.uhc.enchantment;

import com.elpepe.uhc.Uhc;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.enchantment.Enchantment.class_1888;

public class ModEnchantments {
   public static final Enchantment BULLDOZER;
   public static final Enchantment CREEP_ENCHANTMENT;

   private static Enchantment register(String name, Enchantment enchantment) {
      return (Enchantment)Registry.register(Registries.ENCHANTMENT, new Identifier(Uhc.MOD_ID, name), enchantment);
   }

   public static void registerEnchantments() {
      Uhc.LOGGER.info("Registering Enchantments for " + Uhc.MOD_ID);
   }

   static {
      BULLDOZER = register("bulldozer", new BulldozerEnchantment(class_1888.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
      CREEP_ENCHANTMENT = register("creep_enchantment", new CreepEnchantment(class_1888.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
   }
}
