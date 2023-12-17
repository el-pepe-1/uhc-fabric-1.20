package com.elpepe.uhc.enchantment;

import com.elpepe.uhc.Uhc;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final Enchantment BULLDOZER = register("bulldozer", new BulldozerEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
    public static final Enchantment CREEP_ENCHANTMENT = register("creep_enchantment", new CreepEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Uhc.MOD_ID, name), enchantment);
    }

    public static void registerEnchantments() {
        Uhc.LOGGER.info("Registering Enchantments for " + Uhc.MOD_ID);
    }
}
