package com.elpepe.uhc.world.feature.custom;

import com.elpepe.uhc.util.FeatureUtils;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.config.RandomStateFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.List;

public class BigRockFeature extends Feature<OverchargeRockFeatureConfig> {
    public BigRockFeature(Codec<OverchargeRockFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<OverchargeRockFeatureConfig> context) {
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        int height = context.getConfig().height;
        List<RandomStateFeatureConfig.RandomStateEntry> blocks = context.getConfig().rockBlocks.blocks;
        BlockState freezeBlock = context.getConfig().freezeBlock;
        BlockState additionalBLock = context.getConfig().additionalBlock;

        for (int i = 0; i < height; ++i) {
            int spreadX = random.nextInt(4);
            int spreadZ = random.nextInt(4);
            float f = (float) (spreadX + spreadZ) * 0.333F + 0.5F;

            for (BlockPos pos : BlockPos.iterate(blockPos.add(-spreadX, 0, -spreadZ), blockPos.add(spreadX, 0, spreadZ))) {
                if (pos.getSquaredDistance(blockPos) <= (double) (f * f)) {
                    BlockState toSet;
                    if (i >= height - 1) {
                        toSet = freezeBlock;
                    } else if (i >= height - 2) {
                        toSet = additionalBLock;
                    } else {
                        toSet = this.getRandomEntryIncludingChance(blocks, random).state;
                    }

                    FeatureUtils.setBlock(world, pos, toSet);
                }
            }

            blockPos = blockPos.up();
        }

        return true;
    }

    private RandomStateFeatureConfig.RandomStateEntry getRandomEntryIncludingChance(List<RandomStateFeatureConfig.RandomStateEntry> pool, Random random) {
        return this.getRandomEntryIncludingChance(pool, 0.0F, random);
    }

    private RandomStateFeatureConfig.RandomStateEntry getRandomEntryIncludingChance(List<RandomStateFeatureConfig.RandomStateEntry> pool, float min, Random random) {
        if (min >= 1.0F) {
            return pool.get(0);
        }
        float fl = random.nextFloat();
        RandomStateFeatureConfig.RandomStateEntry entry = null;

        for (RandomStateFeatureConfig.RandomStateEntry randomStateEntry : pool) {
            if (fl < randomStateEntry.chance) {
                entry = randomStateEntry;
                break;
            }
        }

        return entry == null ? this.getRandomEntryIncludingChance(pool, fl + 0.2F, random) : entry;

    }
}
