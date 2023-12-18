package com.elpepe.uhc.world.gen;

import com.elpepe.uhc.world.ModPlacedFeature;
import com.elpepe.uhc.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.world.gen.GenerationStep.Feature;

import java.util.function.Predicate;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(foundInOvercharge(), Feature.UNDERGROUND_ORES, ModPlacedFeature.NITHRIL_ORE_PLACED_KEY);
    }

    public static Predicate<BiomeSelectionContext> foundInOvercharge() {
        return context -> context.canGenerateIn(ModDimensions.OVERCHARGE_KEY);
    }
}
