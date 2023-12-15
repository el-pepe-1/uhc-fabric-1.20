package com.elpepe.uhc.world;

import java.util.List;
import net.minecraft.class_2960;
import net.minecraft.class_2975;
import net.minecraft.class_5321;
import net.minecraft.class_5450;
import net.minecraft.class_5452;
import net.minecraft.class_5843;
import net.minecraft.class_6016;
import net.minecraft.class_6732;
import net.minecraft.class_6792;
import net.minecraft.class_6795;
import net.minecraft.class_6796;
import net.minecraft.class_6797;
import net.minecraft.class_6880;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class ModPlacedFeature {
   public static final class_5321<class_6796> DEAD_TREE_PLACED_KEY = registryKey("dead_tree_placed");
   public static final class_5321<class_6796> BIG_ROCK_PLACED_KEY = registryKey("big_rock_placed");
   public static final class_5321<class_6796> NITHRIL_ORE_PLACED_KEY = registryKey("nithril_ore_placed");

   public ModPlacedFeature() {
   }

   public static void bootstrap(class_7891<class_6796> context) {
      class_7871<class_2975<?, ?>> configuredFeatureRegistryLookup = context.method_46799(class_7924.field_41239);
      register(context, DEAD_TREE_PLACED_KEY, configuredFeatureRegistryLookup.method_46747(ModConfiguredFeatures.DEAD_TREE_KEY), List.of(class_6732.method_39657(class_6016.method_34998(1), class_6016.method_34998(6)), class_5450.method_39639(), class_5452.method_39620(1), class_6792.method_39614()));
      register(context, BIG_ROCK_PLACED_KEY, configuredFeatureRegistryLookup.method_46747(ModConfiguredFeatures.BIG_ROCK_KEY), List.of(class_6732.method_39657(class_6016.method_34998(1), class_6016.method_34998(6)), class_5450.method_39639(), class_5452.method_39620(1), class_6792.method_39614()));
      register(context, NITHRIL_ORE_PLACED_KEY, configuredFeatureRegistryLookup.method_46747(ModConfiguredFeatures.NITHRIL_ORE_KEY), ModOrePlacement.modifiersWithCount(1, class_6795.method_39634(class_5843.method_33841(-80), class_5843.method_33841(80))));
   }

   public static class_5321<class_6796> registryKey(String name) {
      return class_5321.method_29179(class_7924.field_41245, new class_2960("uhc", name));
   }

   private static void register(class_7891<class_6796> context, class_5321<class_6796> key, class_6880<class_2975<?, ?>> configuredFeature, List<class_6797> modifiers) {
      context.method_46838(key, new class_6796(configuredFeature, List.copyOf(modifiers)));
   }
}
