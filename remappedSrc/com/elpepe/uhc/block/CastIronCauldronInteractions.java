package com.elpepe.uhc.block;

import com.elpepe.uhc.block.entity.CastIronCauldronBlockEntity;
import java.util.HashMap;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_1847;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import org.jetbrains.annotations.Nullable;

public class CastIronCauldronInteractions {
   private static final int WATER_LEVELS_IN_BUCKET = 3;
   private static final int WATER_LEVELS_IN_BOTTLE = 1;
   public static final HashMap<class_1792, class_1792> DEFAULT_FOOD_CONTAINERS = new HashMap<class_1792, class_1792>() {
   };
   public static final HashMap<class_1792, BlockInteraction<CastIronCauldronBlockEntity>> DEFAULT_INTERACTIONS = new HashMap<class_1792, BlockInteraction<CastIronCauldronBlockEntity>>() {
      {
         this.put(class_1802.field_8574, (level, pos, state, blockEntity, player, hand) -> {
            CastIronCauldronInteractions.fillPot(level, pos, state, 1, player, hand, class_3417.field_14826, new class_1799(class_1802.field_8469));
         });
         this.put(class_1802.field_8705, (level, pos, state, blockEntity, player, hand) -> {
            CastIronCauldronInteractions.fillPot(level, pos, state, 3, player, hand, class_3417.field_14834, new class_1799(class_1802.field_8550));
         });
         this.put(class_1802.field_8469, (level, pos, state, entity, player, hand) -> {
            CastIronCauldronInteractions.getWaterFromPot(level, pos, state, 1, player, hand, class_3417.field_14779, class_1844.method_8061(new class_1799(class_1802.field_8574), class_1847.field_8991));
         });
         this.put(class_1802.field_8550, (level, pos, state, entity, player, hand) -> {
            CastIronCauldronInteractions.getWaterFromPot(level, pos, state, 3, player, hand, class_3417.field_15126, new class_1799(class_1802.field_8705));
         });
      }
   };

   public CastIronCauldronInteractions() {
   }

   private static void fillPot(class_1937 world, class_2338 pos, class_2680 state, int toFill, class_1657 player, class_1268 hand, @Nullable class_3414 sound, @Nullable class_1799 itemAfterFilling) {
      int currentLevel = (Integer)state.method_11654(CastIronCauldronBlock.WATER_LEVEL);
      if (currentLevel + toFill <= 3) {
         world.method_8501(pos, (class_2680)state.method_11657(CastIronCauldronBlock.WATER_LEVEL, currentLevel + toFill));
         if (sound != null) {
            world.method_8396((class_1657)null, pos, sound, class_3419.field_15245, 1.0F, 1.0F);
         }

         if (itemAfterFilling != null) {
            player.method_6122(hand, itemAfterFilling);
         }
      }

   }

   private static void getWaterFromPot(class_1937 world, class_2338 pos, class_2680 state, int toGet, class_1657 player, class_1268 hand, @Nullable class_3414 sound, @Nullable class_1799 itemAfterGetting) {
      int currentLevel = (Integer)state.method_11654(CastIronCauldronBlock.WATER_LEVEL);
      if (currentLevel - toGet >= 0) {
         world.method_8501(pos, (class_2680)state.method_11657(CastIronCauldronBlock.WATER_LEVEL, currentLevel - toGet));
         if (sound != null) {
            world.method_8396((class_1657)null, pos, sound, class_3419.field_15245, 1.0F, 1.0F);
         }

         if (itemAfterGetting != null) {
            player.method_6122(hand, itemAfterGetting);
         }
      }

   }
}
