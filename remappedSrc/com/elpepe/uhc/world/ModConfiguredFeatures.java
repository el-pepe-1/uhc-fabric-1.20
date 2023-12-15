package com.elpepe.uhc.world;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.world.feature.ModFeatures;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.config.RandomStateFeatureConfig;
import java.util.List;
import net.minecraft.class_2246;
import net.minecraft.class_2960;
import net.minecraft.class_2963;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3124;
import net.minecraft.class_3819;
import net.minecraft.class_3825;
import net.minecraft.class_5321;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class ModConfiguredFeatures {
   public static final class_5321<class_2975<?, ?>> DEAD_TREE_KEY = registryKey("dead_tree");
   public static final class_5321<class_2975<?, ?>> BIG_ROCK_KEY = registryKey("big_rock");
   public static final class_5321<class_2975<?, ?>> NITHRIL_ORE_KEY = registryKey("nithril_ore");

   public ModConfiguredFeatures() {
   }

   public static void bootstrap(class_7891<class_2975<?, ?>> context) {
      class_3825 stoneReplaceables = new class_3819(ModBlocks.CRYOGENIC_STONE);
      List<class_3124.class_5876> overchargeNithrilOres = List.of(class_3124.method_33994(stoneReplaceables, ModBlocks.NITHRIL_ORE.method_9564()));
      register(context, DEAD_TREE_KEY, ModFeatures.DEAD_TREE, new class_2963(ModBlocks.DEAD_LOG.method_9564()));
      register(context, BIG_ROCK_KEY, ModFeatures.BIG_ROCK, new OverchargeRockFeatureConfig(4, new RandomStateFeatureConfig(List.of(new RandomStateFeatureConfig.RandomStateEntry(class_2246.field_10115.method_9564(), 0.1F), new RandomStateFeatureConfig.RandomStateEntry(class_2246.field_10445.method_9564(), 0.25F), new RandomStateFeatureConfig.RandomStateEntry(class_2246.field_10340.method_9564(), 0.75F))), ModBlocks.GRAY_ICE.method_9564(), ModBlocks.CRYOGENIC_STONE.method_9564()));
      register(context, NITHRIL_ORE_KEY, class_3031.field_13517, new class_3124(overchargeNithrilOres, 6));
   }

   public static class_5321<class_2975<?, ?>> registryKey(String name) {
      return class_5321.method_29179(class_7924.field_41239, new class_2960("uhc", name));
   }

   private static <FC extends class_3037, F extends class_3031<FC>> void register(class_7891<class_2975<?, ?>> context, class_5321<class_2975<?, ?>> key, F feature, FC configuration) {
      context.method_46838(key, new class_2975(feature, configuration));
   }
}
