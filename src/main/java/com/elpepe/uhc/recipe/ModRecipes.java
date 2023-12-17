package com.elpepe.uhc.recipe;

import com.elpepe.uhc.Uhc;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Uhc.MOD_ID, "cast_iron_cauldron"), CastIronCauldronRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Uhc.MOD_ID, "cast_iron_cauldron"), CastIronCauldronRecipe.Type.INSTANCE);
    }
}
