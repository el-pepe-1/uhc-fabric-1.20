package com.elpepe.uhc.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class RandomStateFeatureConfig implements FeatureConfig {
    public static final Codec<RandomStateFeatureConfig> CODEC = Codecs.nonEmptyList(
            RandomStateFeatureConfig.RandomStateEntry.CODEC.listOf()).fieldOf("states").xmap(RandomStateFeatureConfig::new, config -> config.blocks)
            .codec();


    public final List<RandomStateEntry> blocks;

    public RandomStateFeatureConfig(List<RandomStateEntry> blocks) {
        this.blocks = blocks;
    }

    public static class RandomStateEntry {
        public static final Codec<RandomStateEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                BlockState.CODEC.fieldOf("state").forGetter(config -> config.state),
                Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter(config -> config.chance))
                .apply(instance, RandomStateEntry::new)
        );
        public final BlockState state;
        public final float chance;

        public RandomStateEntry(BlockState state, float chance) {
            this.state = state;
            this.chance = chance;
        }
    }
}
