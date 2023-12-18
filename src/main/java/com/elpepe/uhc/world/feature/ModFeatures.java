package com.elpepe.uhc.world.feature;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.custom.BigRockFeature;
import com.elpepe.uhc.world.feature.custom.DeadTreeFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;

public class ModFeatures {
    public static final Feature<SingleStateFeatureConfig> DEAD_TREE = register("dead_tree", new DeadTreeFeature(SingleStateFeatureConfig.CODEC));
    public static final Feature<OverchargeRockFeatureConfig> BIG_ROCK = register("big_rock", new BigRockFeature(OverchargeRockFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, new Identifier(Uhc.MOD_ID, name), feature);
    }

    public static void registerFeatures() {
        Uhc.LOGGER.info("Registering Features for " + Uhc.MOD_ID);
    }
}
