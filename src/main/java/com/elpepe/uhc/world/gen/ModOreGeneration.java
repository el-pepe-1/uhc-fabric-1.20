package com.elpepe.uhc.world.gen;

import com.elpepe.uhc.world.ModPlacedFeature;
import com.elpepe.uhc.world.dimension.ModDimensions;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.class_2893.class_2895;

public class ModOreGeneration {
   public ModOreGeneration() {
   }

   public static void generateOres() {
      BiomeModifications.addFeature(foundInOvercharge(), class_2895.field_13176, ModPlacedFeature.NITHRIL_ORE_PLACED_KEY);
   }

   public static Predicate<BiomeSelectionContext> foundInOvercharge() {
      return (context) -> {
         return context.canGenerateIn(ModDimensions.OVERCHARGE_KEY);
      };
   }
}