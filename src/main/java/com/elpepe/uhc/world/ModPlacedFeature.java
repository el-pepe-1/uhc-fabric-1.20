package com.elpepe.uhc.world;

import com.elpepe.uhc.Uhc;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeature {
    public static final RegistryKey<PlacedFeature> DEAD_TREE_PLACED_KEY = registryKey("dead_tree_placed");
    public static final RegistryKey<PlacedFeature> BIG_ROCK_PLACED_KEY = registryKey("big_rock_placed");
    public static final RegistryKey<PlacedFeature> NITHRIL_ORE_PLACED_KEY = registryKey("nithril_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureRegistryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, DEAD_TREE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.DEAD_TREE_KEY), List.of(
                RandomOffsetPlacementModifier.of(ConstantIntProvider.create(1), ConstantIntProvider.create(6)), SquarePlacementModifier.of(), CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of()));
        register(context, BIG_ROCK_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.BIG_ROCK_KEY), List.of(
                RandomOffsetPlacementModifier.of(ConstantIntProvider.create(1), ConstantIntProvider.create(6)), SquarePlacementModifier.of(), CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of()));
        register(context, NITHRIL_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.NITHRIL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Uhc.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuredFeature, List.copyOf(modifiers)));
    }
}
