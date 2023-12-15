package com.elpepe.uhc.recipe;

import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModRecipes {
   public ModRecipes() {
   }

   public static void registerRecipes() {
      class_2378.method_10230(class_7923.field_41189, new class_2960("uhc", "cast_iron_cauldron"), CastIronCauldronRecipe.Serializer.INSTANCE);
      class_2378.method_10230(class_7923.field_41188, new class_2960("uhc", "cast_iron_cauldron"), CastIronCauldronRecipe.Type.INSTANCE);
   }
}
