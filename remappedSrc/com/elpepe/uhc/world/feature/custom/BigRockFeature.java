package com.elpepe.uhc.world.feature.custom;

import com.elpepe.uhc.util.FeatureUtils;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.config.RandomStateFeatureConfig;
import com.mojang.serialization.Codec;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3031;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_5821;

public class BigRockFeature extends class_3031<OverchargeRockFeatureConfig> {
   public BigRockFeature(Codec<OverchargeRockFeatureConfig> configCodec) {
      super(configCodec);
   }

   public boolean method_13151(class_5821<OverchargeRockFeatureConfig> context) {
      class_2338 blockPos = context.method_33655();
      class_5281 world = context.method_33652();
      class_5819 random = context.method_33654();
      int height = ((OverchargeRockFeatureConfig)context.method_33656()).height;
      List<RandomStateFeatureConfig.RandomStateEntry> blocks = ((OverchargeRockFeatureConfig)context.method_33656()).rockBlocks.blocks;
      class_2680 freezeBlock = ((OverchargeRockFeatureConfig)context.method_33656()).freezeBlock;
      class_2680 additionalBLock = ((OverchargeRockFeatureConfig)context.method_33656()).additionalBlock;

      for(int i = 0; i < height; ++i) {
         int spreadX = random.method_43048(4);
         int spreadZ = random.method_43048(4);
         float f = (float)(spreadX + 0 + spreadZ) * 0.333F + 0.5F;
         Iterator<class_2338> iterator = class_2338.method_10097(blockPos.method_10069(-spreadX, 0, -spreadZ), blockPos.method_10069(spreadX, 0, spreadZ)).iterator();

         while(iterator.hasNext()) {
            class_2338 pos = (class_2338)iterator.next();
            if (pos.method_10262(blockPos) <= (double)(f * f)) {
               class_2680 toSet;
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

         blockPos = blockPos.method_10084();
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
