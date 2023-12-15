package com.elpepe.uhc.world.feature;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.world.feature.config.OverchargeRockFeatureConfig;
import com.elpepe.uhc.world.feature.custom.BigRockFeature;
import com.elpepe.uhc.world.feature.custom.DeadTreeFeature;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_2963;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_7923;

public class ModFeatures {
   public static final class_3031<class_2963> DEAD_TREE;
   public static final class_3031<OverchargeRockFeatureConfig> BIG_ROCK;

   public ModFeatures() {
   }

   private static <C extends class_3037, F extends class_3031<C>> F register(String name, F feature) {
      return (class_3031)class_2378.method_10230(class_7923.field_41144, new class_2960("uhc", name), feature);
   }

   public static void registerFeatures() {
      Uhc.LOGGER.info("Registering Features for uhc");
   }

   static {
      DEAD_TREE = register("dead_tree", new DeadTreeFeature(class_2963.field_24874));
      BIG_ROCK = register("big_rock", new BigRockFeature(OverchargeRockFeatureConfig.CODEC));
   }
}
