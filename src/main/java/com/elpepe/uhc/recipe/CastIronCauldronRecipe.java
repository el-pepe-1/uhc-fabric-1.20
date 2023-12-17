package com.elpepe.uhc.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.world.World;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.dynamic.Codecs;

public class CastIronCauldronRecipe implements Recipe<SimpleInventory> {
   private final ItemStack output;
   private final List<Ingredient> recipeItems;

   public CastIronCauldronRecipe(List<Ingredient> ingredients, ItemStack output) {
      this.output = output;
      this.recipeItems = ingredients;
   }

   public boolean matches(SimpleInventory inventory, World world) {
      if (world.isClient()) {
         return false;
      } else {
         RecipeMatcher recipeMatcher = new RecipeMatcher();
         int i = 0;

         for(int j = 0; j < inventory.size(); ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (!itemStack.isEmpty()) {
               ++i;
               recipeMatcher.addInput(itemStack, 1);
            }
         }

         return i == this.recipeItems.size() && recipeMatcher.match(this, (IntList)null);
      }
   }

   public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
      return this.output;
   }

   public boolean fits(int width, int height) {
      return true;
   }

   public ItemStack getOutput(DynamicRegistryManager registryManager) {
      return this.output;
   }

   public ItemStack getResult(DynamicRegistryManager registryManager) {
      return this.getOutput(registryManager);
   }

   public DefaultedList<Ingredient> getIngredients() {
      DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
      list.addAll(this.recipeItems);
      return list;
   }

   public Identifier getId() {
      return new Identifier(Uhc.MOD_ID, "cast_iron_cauldron");
   }

   public RecipeSerializer<?> getSerializer() {
      return CastIronCauldronRecipe.Serializer.INSTANCE;
   }

   public RecipeType<?> getType() {
      return CastIronCauldronRecipe.Type.INSTANCE;
   }

   public static class Type implements RecipeType<CastIronCauldronRecipe> {
      public static final Type INSTANCE = new Type();
      public static final String ID = "cast_iron_cauldron";
   }

   public static class Serializer implements RecipeSerializer<CastIronCauldronRecipe> {
      public static final Serializer INSTANCE = new Serializer();
      public static final String ID = "cast_iron_cauldron";

      private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
         return Codecs.validate(Codecs.validate(delegate.listOf(), (list) -> {
            return list.size() > max ? DataResult.error(() -> {
               return "Recipe has too many ingredients!";
            }) : DataResult.success(list);
         }), (list) -> {
            return list.isEmpty() ? DataResult.error(() -> {
               return "Recipe has no ingredients!";
            }) : DataResult.success(list);
         });
      }

      public CastIronCauldronRecipe read(Identifier id, JsonObject json) {
         DefaultedList<Ingredient> defaultedList = getIngredients(JsonHelper.getArray(json, "ingredients"));
         ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
         return new CastIronCauldronRecipe(defaultedList, itemStack);
      }

      private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
         DefaultedList<Ingredient> defaultedList = DefaultedList.of();

         for(int i = 0; i < json.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i), false);
            if (!ingredient.isEmpty()) {
               defaultedList.add(ingredient);
            }
         }

         return defaultedList;
      }

      public CastIronCauldronRecipe read(Identifier id, PacketByteBuf buf) {
         DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

         for(int i = 0; i < inputs.size(); ++i) {
            inputs.set(i, Ingredient.fromPacket(buf));
         }

         ItemStack output = buf.readItemStack();
         return new CastIronCauldronRecipe(inputs, output);
      }

      public void write(PacketByteBuf buf, CastIronCauldronRecipe recipe) {
         buf.writeInt(recipe.getIngredients().size());
         Iterator var3 = recipe.getIngredients().iterator();

         while(var3.hasNext()) {
            Ingredient ingredient = (Ingredient)var3.next();
            ingredient.write(buf);
         }

         buf.writeItemStack(recipe.getOutput((DynamicRegistryManager)null));
      }
   }
}
