package com.elpepe.uhc.world;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.world.feature.ModFeatures;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.config.RandomStateFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_TREE_KEY = registryKey("dead_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_ROCK_KEY = registryKey("big_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NITHRIL_ORE_KEY = registryKey("nithril_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new BlockMatchRuleTest(ModBlocks.CRYOGENIC_STONE);
        List<OreFeatureConfig.Target> overchargeNithrilOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.NITHRIL_ORE.getDefaultState()));
        register(context, DEAD_TREE_KEY, ModFeatures.DEAD_TREE, new SingleStateFeatureConfig(ModBlocks.DEAD_LOG.getDefaultState()));
        register(context, BIG_ROCK_KEY, ModFeatures.BIG_ROCK, new OverchargeRockFeatureConfig(4, new RandomStateFeatureConfig(List.of(
                new RandomStateFeatureConfig.RandomStateEntry(Blocks.ANDESITE.getDefaultState(), 0.1F),
                new RandomStateFeatureConfig.RandomStateEntry(Blocks.COBBLESTONE.getDefaultState(), 0.25F),
                new RandomStateFeatureConfig.RandomStateEntry(Blocks.STONE.getDefaultState(), 0.75F))), ModBlocks.GRAY_ICE.getDefaultState(), ModBlocks.CRYOGENIC_STONE.getDefaultState()));
        register(context, NITHRIL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overchargeNithrilOres, 6));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Uhc.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
