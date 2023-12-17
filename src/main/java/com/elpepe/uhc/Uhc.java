package com.elpepe.uhc;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.block.entity.ModBlockEntities;
import com.elpepe.uhc.command.ModCommands;
import com.elpepe.uhc.effect.ModEffects;
import com.elpepe.uhc.enchantment.ModEnchantments;
import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.ModEntityAttributes;
import com.elpepe.uhc.item.ModItemGroups;
import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.networking.ModMessages;
import com.elpepe.uhc.particle.ModParticles;
import com.elpepe.uhc.recipe.ModRecipes;
import com.elpepe.uhc.screen.ModScreenHandlers;
import com.elpepe.uhc.sound.ModSounds;
import com.elpepe.uhc.util.ModGameRules;
import com.elpepe.uhc.util.ModRegistries;
import com.elpepe.uhc.world.feature.ModFeatures;
import com.elpepe.uhc.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Uhc implements ModInitializer {
    public static final String MOD_ID = "uhc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModEntities.registerModEntities();
        ModEnchantments.registerEnchantments();
        ModEffects.registerEffects();
        ModParticles.registerParticles();
        ModSounds.registerSounds();
        ModCommands.register();
        ModRecipes.registerRecipes();
        ModMessages.registerC2SPackets();
        ModEntityAttributes.registerAttributes();
        ModGameRules.registerGameRules();
        ModWorldGeneration.generateModWorldGen();
        ModFeatures.registerFeatures();
        ModRegistries.registerModStuff();
    }
}
