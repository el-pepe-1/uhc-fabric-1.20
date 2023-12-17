package com.elpepe.uhc.world.biome;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.sound.ModSounds;
import com.elpepe.uhc.world.ModPlacedFeature;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep.Feature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> PURPLE_CLIFFS = register("purple_cliffs");
    public static final RegistryKey<Biome> ICY_WASTELAND = register("icy_wasteland");
    public static final RegistryKey<Biome> DEAD_FOREST = register("dead_forest");

    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(Uhc.MOD_ID, name));
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(PURPLE_CLIFFS, purpleCliffs(context));
        context.register(DEAD_FOREST, deadForest(context));
        context.register(ICY_WASTELAND, icyWasteland(context));
    }

    public static Biome icyWasteland(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 5, 1, 4));
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        biomeBuilder.feature(Feature.TOP_LAYER_MODIFICATION, ModPlacedFeature.BIG_ROCK_PLACED_KEY);
        DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.0F)
                .temperature(-1.0F)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(3026478)
                        .waterFogColor(3026478)
                        .skyColor(10263708)
                        .grassColor(3026478)
                        .foliageColor(3026478)
                        .fogColor(5723991)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.AIRTAG_ALARM)))
                        .build())
                .build();
    }

    public static Biome deadForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        biomeBuilder.feature(Feature.TOP_LAYER_MODIFICATION, ModPlacedFeature.DEAD_TREE_PLACED_KEY);
        DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4F)
                .temperature(-1.0F)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(3026478)
                        .waterFogColor(3026478)
                        .skyColor(986895)
                        .grassColor(3026478)
                        .foliageColor(3026478)
                        .fogColor(986895)
                        .build())
                .build();
    }

    public static Biome purpleCliffs(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        DefaultBiomeFeatures.addLandCarvers(biomeBuilder);
        DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .downfall(2.0F)
                .temperature(-1.0F)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(3026478)
                        .waterFogColor(3026478)
                        .skyColor(986895)
                        .grassColor(3026478)
                        .foliageColor(3026478)
                        .fogColor(986895)
                        .build())
                .build();
    }
}
