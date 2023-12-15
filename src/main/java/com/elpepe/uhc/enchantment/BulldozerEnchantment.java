package com.elpepe.uhc.enchantment;

import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1810;
import net.minecraft.class_1886;
import net.minecraft.class_1887;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3481;

public class BulldozerEnchantment extends class_1887 {
   protected BulldozerEnchantment(class_1887.class_1888 rarity, class_1304... slotTypes) {
      super(rarity, class_1886.field_9069, slotTypes);
   }

   public int method_8183() {
      return 1;
   }

   public boolean method_8192(class_1799 stack) {
      return stack.method_7909() instanceof class_1810;
   }

   public static void postMine(class_1937 world, class_2338 pos, class_1309 miner, class_1799 stack, class_2680 minedBlock) {
      if (miner instanceof class_1657 player) {
         if (!miner.method_5715()) {
            switch (miner.method_5735()) {
               case field_11043:
               case field_11035:
                  mineBlock(player, world, pos.method_10078(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10067(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10084(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10084().method_10078(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10084().method_10067(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10074(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10074().method_10078(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10074().method_10067(), stack, minedBlock);
                  break;
               case field_11034:
               case field_11039:
                  mineBlock(player, world, pos.method_10072(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10095(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10084(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10084().method_10072(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10084().method_10095(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10074(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10074().method_10072(), stack, minedBlock);
                  mineBlock(player, world, pos.method_10074().method_10095(), stack, minedBlock);
            }
         }
      }

   }

   private static void mineBlock(class_1657 miner, class_1937 world, class_2338 pos, class_1799 stack, class_2680 minedBlock) {
      if (blocksAreSame(minedBlock, world.method_8320(pos))) {
         world.method_8651(pos, true, miner);
         stack.method_7956(1, miner, (entity) -> {
            entity.method_20236(class_1268.field_5808);
         });
      }

   }

   private static boolean blocksAreSame(class_2680 minedBlock, class_2680 second) {
      if (minedBlock.method_26164(class_3481.field_25806) && second.method_26164(class_3481.field_25806)) {
         return true;
      } else {
         return minedBlock.method_26164(class_3481.field_25807) && second.method_26164(class_3481.field_25807) ? true : minedBlock.method_27852(second.method_26204());
      }
   }
}
