package com.elpepe.uhc.world.feature.custom;

import com.elpepe.uhc.util.FeatureUtils;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.config.RandomStateFeatureConfig;
import com.mojang.serialization.Codec;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BigRockFeature extends Feature<OverchargeRockFeatureConfig> {
   public BigRockFeature(Codec<OverchargeRockFeatureConfig> configCodec) {
      super(configCodec);
   }

   public boolean generate(FeatureContext<OverchargeRockFeatureConfig> context) {
      BlockPos blockPos = context.getOrigin();
      StructureWorldAccess world = context.getWorld();
      Random random = context.getRandom();
      int height = ((OverchargeRockFeatureConfig)context.getConfig()).height;
      List<RandomStateFeatureConfig.RandomStateEntry> blocks = ((OverchargeRockFeatureConfig)context.getConfig()).rockBlocks.blocks;
      BlockState freezeBlock = ((OverchargeRockFeatureConfig)context.getConfig()).freezeBlock;
      BlockState additionalBLock = ((OverchargeRockFeatureConfig)context.getConfig()).additionalBlock;

      for(int i = 0; i < height; ++i) {
         int spreadX = random.nextInt(4);
         int spreadZ = random.nextInt(4);
         float f = (float)(spreadX + 0 + spreadZ) * 0.333F + 0.5F;
         Iterator<BlockPos> iterator = BlockPos.iterate(blockPos.add(-spreadX, 0, -spreadZ), blockPos.add(spreadX, 0, spreadZ)).iterator();

         while(iterator.hasNext()) {
            BlockPos pos = (BlockPos)iterator.next();
            if (pos.getSquaredDistance(blockPos) <= (double)(f * f)) {
               BlockState toSet;
               if (i >= height - 1) {
                  toSet = freezeBlock;
               } else if (i >= height - 2) {
                  toSet = additionalBLock;
               } else {
                  toSet = this.getRandomEntryIncludingChance(blocks).state;
               }

               FeatureUtils.setBlock(world, pos, toSet);
            }
         }

         blockPos = blockPos.up();
      }

      return true;
   }

   private RandomStateFeatureConfig.RandomStateEntry getRandomEntryIncludingChance(List<RandomStateFeatureConfig.RandomStateEntry> pool) {
      return this.getRandomEntryIncludingChance(pool, 0.0F);
   }

   private RandomStateFeatureConfig.RandomStateEntry getRandomEntryIncludingChance(List<RandomStateFeatureConfig.RandomStateEntry> pool, float min) {
      if (min >= 1.0F) {
         return (RandomStateFeatureConfig.RandomStateEntry)pool.get(0);
      } else {
         Random rand = new Random();
         float fl = rand.nextFloat(min, 1.0F);
         RandomStateFeatureConfig.RandomStateEntry entry = null;
         Iterator var6 = pool.iterator();

         while(var6.hasNext()) {
            RandomStateFeatureConfig.RandomStateEntry randomStateEntry = (RandomStateFeatureConfig.RandomStateEntry)var6.next();
            if (fl < randomStateEntry.chance) {
               entry = randomStateEntry;
               break;
            }
         }

         return entry == null ? this.getRandomEntryIncludingChance(pool, fl + 0.2F) : entry;
      }
   }
}
