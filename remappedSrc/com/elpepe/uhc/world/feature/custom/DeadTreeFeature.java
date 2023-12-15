package com.elpepe.uhc.world.feature.custom;

import com.elpepe.uhc.util.FeatureUtils;
import com.mojang.serialization.Codec;
import net.minecraft.class_2338;
import net.minecraft.class_2470;
import net.minecraft.class_2680;
import net.minecraft.class_2963;
import net.minecraft.class_3031;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_5821;

public class DeadTreeFeature extends class_3031<class_2963> {
   private static final int MAX_LOGS = 5;

   public DeadTreeFeature(Codec<class_2963> configCodec) {
      super(configCodec);
   }

   public boolean method_13151(class_5821<class_2963> context) {
      class_2338 blockPos = context.method_33655();
      class_5281 world = context.method_33652();
      class_2680 state = ((class_2963)context.method_33656()).field_13356;
      class_5819 random = context.method_33654();
      if (blockPos.method_10264() <= world.method_31607() + 3) {
         return false;
      } else {
         int entries = 0;

         int randomX;
         for(boolean previousPlaced = true; previousPlaced; ++entries) {
            randomX = random.method_43048(5);
            if (randomX != 4 && entries < 5) {
               FeatureUtils.setBlock(world, blockPos, state);
               blockPos = blockPos.method_10084();
            } else {
               previousPlaced = false;
            }
         }

         randomX = random.method_39332(-1, 1);
         int randomZ = random.method_39332(-1, 1);
         if (Math.abs(randomX) + Math.abs(randomZ) == 0) {
            if (random.method_39332(0, 1) == 0) {
               ++randomX;
            } else {
               ++randomZ;
            }
         }

         class_2338 blockPos1 = blockPos.method_10069(randomX, 0, randomZ);
         FeatureUtils.setBlock(world, blockPos1, state.method_26186(class_2470.field_11463));
         return true;
      }
   }
}
