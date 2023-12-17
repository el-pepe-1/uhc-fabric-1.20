package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;

public class ModRecipeProvider extends FabricRecipeProvider {
   public ModRecipeProvider(FabricDataOutput output) {
      super(output);
   }

   public void generate(Consumer<RecipeJsonProvider> exporter) {
      offerFoodCookingRecipe(exporter, "goat", RecipeSerializer.SMELTING, 200, ModItems.GOAT_MEAT, ModItems.COOKED_GOAT_MEAT, 5.0F);
      offerFoodCookingRecipe(exporter, "horselike", RecipeSerializer.SMELTING, 200, ModItems.HORSE_LIKE_MEAT, ModItems.COOKED_HORSE_LIKE_MEAT, 5.0F);
      offerFoodCookingRecipe(exporter, "llama", RecipeSerializer.SMELTING, 200, ModItems.LLAMA_MEAT, ModItems.COOKED_LLAMA_MEAT, 5.0F);
      offerFoodCookingRecipe(exporter, "ravager", RecipeSerializer.SMELTING, 500, ModItems.RAVAGER_MEAT, ModItems.COOKED_RAVAGER_MEAT, 25.0F);
      offerFoodCookingRecipe(exporter, "goat_smoking", RecipeSerializer.SMOKING, 200, ModItems.GOAT_MEAT, ModItems.COOKED_GOAT_MEAT, 5.0F);
      offerFoodCookingRecipe(exporter, "horselike_smoking", RecipeSerializer.SMOKING, 200, ModItems.HORSE_LIKE_MEAT, ModItems.COOKED_HORSE_LIKE_MEAT, 5.0F);
      offerFoodCookingRecipe(exporter, "llama_smoking", RecipeSerializer.SMOKING, 200, ModItems.LLAMA_MEAT, ModItems.COOKED_LLAMA_MEAT, 5.0F);
      offerFoodCookingRecipe(exporter, "ravager_smoking", RecipeSerializer.SMOKING, 500, ModItems.RAVAGER_MEAT, ModItems.COOKED_RAVAGER_MEAT, 25.0F);
      offerShapelessRecipe(exporter, ModBlocks.DEAD_PLANKS, ModBlocks.DEAD_LOG, "dead_log", 4);
      offerShapelessRecipe(exporter, ModBlocks.DEAD_PLANKS, ModBlocks.DEAD_WOOD, "dead_wood", 3);
      createDoorRecipe(ModBlocks.DEAD_PLANKS_DOOR, Ingredient.ofItems(new ItemConvertible[]{ModBlocks.DEAD_PLANKS})).criterion(hasItem(ModBlocks.DEAD_PLANKS), conditionsFromItem(ModBlocks.DEAD_PLANKS)).offerTo(exporter);
      offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NITHRIL_BLOCK, ModItems.NITHRIL_INGOT);
      offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_NITHRIL_BLOCK, ModItems.RAW_NITHRIL);
      ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EMERALD_SWORD, 1).pattern("  e").pattern(" E ").pattern("s  ").input('s', Items.STICK).input('E', Items.EMERALD_BLOCK).input('e', Items.EMERALD).criterion(hasItem(Items.EMERALD_BLOCK), conditionsFromItem(Items.EMERALD_BLOCK)).criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD)).offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_SWORD)));
      ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DRAGON_PICKAXE, 1).pattern("LHL").pattern("EPE").pattern("ObO").input('L', Items.LAPIS_BLOCK).input('H', Items.DRAGON_HEAD).input('E', Items.EMERALD_BLOCK).input('P', Items.DIAMOND_PICKAXE).input('O', Items.OBSIDIAN).input('b', Items.DRAGON_BREATH).criterion(hasItem(Items.DRAGON_HEAD), conditionsFromItem(Items.DRAGON_HEAD)).criterion(hasItem(Items.DRAGON_BREATH), conditionsFromItem(Items.DRAGON_BREATH)).offerTo(exporter, new Identifier(getRecipeName(ModItems.DRAGON_PICKAXE)));
      SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(new ItemConvertible[]{ModItems.DRAGON_PICKAXE}), Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT}), RecipeCategory.TOOLS, ModItems.NETHERITE_COVERED_DRAGON_PICKAXE).criterion(hasItem(ModItems.DRAGON_PICKAXE), conditionsFromItem(ModItems.DRAGON_PICKAXE)).offerTo(exporter, new Identifier(getRecipeName(ModItems.NETHERITE_COVERED_DRAGON_PICKAXE)));
      SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(new ItemConvertible[]{ModItems.EMERALD_SWORD}), Ingredient.ofItems(new ItemConvertible[]{ModItems.SHARP_STONE}), RecipeCategory.COMBAT, ModItems.SHARP_EMERALD_SWORD).criterion(hasItem(ModItems.EMERALD_SWORD), conditionsFromItem(ModItems.EMERALD_SWORD)).criterion(hasItem(ModItems.SHARP_STONE), conditionsFromItem(ModItems.SHARP_STONE)).offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARP_EMERALD_SWORD)));
      offerSmithingTrimRecipe(exporter, ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE, new Identifier(getRecipeName(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE)));
   }
}
