package com.elpepe.uhc.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class OverchargeRockFeatureConfig implements FeatureConfig {
    public static final Codec<OverchargeRockFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("height").forGetter(config -> config.height),
            RandomStateFeatureConfig.CODEC.fieldOf("blocks").forGetter(config -> config.rockBlocks),
            BlockState.CODEC.fieldOf("freeze_block").forGetter(config -> config.freezeBlock),
            BlockState.CODEC.fieldOf("additional_block").forGetter(config -> config.additionalBlock))
            .apply(instance, OverchargeRockFeatureConfig::new)
    );
    public final int height;
    public final RandomStateFeatureConfig rockBlocks;
    public final BlockState freezeBlock;
    public final BlockState additionalBlock;

    public OverchargeRockFeatureConfig(int height, RandomStateFeatureConfig blocks, BlockState freezeBlock, BlockState additionalBlock) {
        this.height = height;
        this.rockBlocks = blocks;
        this.freezeBlock = freezeBlock;
        this.additionalBlock = additionalBlock;
    }
}
