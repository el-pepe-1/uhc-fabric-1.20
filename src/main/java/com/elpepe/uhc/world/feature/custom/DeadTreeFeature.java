package com.elpepe.uhc.world.feature.custom;

import com.elpepe.uhc.util.FeatureUtils;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.BlockRotation;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class DeadTreeFeature extends Feature<SingleStateFeatureConfig> {
   private static final int MAX_LOGS = 5;

   public DeadTreeFeature(Codec<SingleStateFeatureConfig> configCodec) {
      super(configCodec);
   }

   public boolean generate(FeatureContext<SingleStateFeatureConfig> context) {
      BlockPos blockPos = context.getOrigin();
      StructureWorldAccess world = context.getWorld();
      BlockState state = ((SingleStateFeatureConfig)context.getConfig()).state;
      Random random = context.getRandom();
      if (blockPos.getY() <= world.getBottomY() + 3) {
         return false;
      } else {
         int entries = 0;

         int randomX;
         for(boolean previousPlaced = true; previousPlaced; ++entries) {
            randomX = random.nextInt(5);
            if (randomX != 4 && entries < 5) {
               FeatureUtils.setBlock(world, blockPos, state);
               blockPos = blockPos.up();
            } else {
               previousPlaced = false;
            }
         }

         randomX = random.nextBetween(-1, 1);
         int randomZ = random.nextBetween(-1, 1);
         if (Math.abs(randomX) + Math.abs(randomZ) == 0) {
            if (random.nextBetween(0, 1) == 0) {
               ++randomX;
            } else {
               ++randomZ;
            }
         }

         BlockPos blockPos1 = blockPos.add(randomX, 0, randomZ);
         FeatureUtils.setBlock(world, blockPos1, state.rotate(BlockRotation.CLOCKWISE_90));
         return true;
      }
   }
}
