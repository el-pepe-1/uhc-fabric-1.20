package com.elpepe.uhc.recipe;

import com.elpepe.uhc.Uhc;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

public class CastIronCauldronRecipe implements Recipe<SimpleInventory> {
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public CastIronCauldronRecipe(List<Ingredient> ingredients, ItemStack output) {
        this.output = output;
        this.recipeItems = ingredients;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;

        for (int j = 0; j < inventory.size(); ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (!itemStack.isEmpty()) {
                ++i;
                recipeMatcher.addInput(itemStack, 1);
            }
        }

        return i == this.recipeItems.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return this.output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return this.output;
    }

    public ItemStack getResult() {
        return this.output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(this.recipeItems);
        return list;
    }

    @Override
    public Identifier getId() {
        return new Identifier(Uhc.MOD_ID, "cast_iron_cauldron");
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CastIronCauldronRecipe.Serializer.INSTANCE;
    }

    @Override
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
            return Codecs.validate(Codecs.validate(
                            delegate.listOf(), list -> list.size() > max ?
                            DataResult.error(() -> "Recipe has too many ingredients!") :
                            DataResult.success(list)), list -> list.isEmpty() ?
                    DataResult.error(() -> "Recipe has no ingredients!") :
                    DataResult.success(list));
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();

            for (int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i), false);
                if (!ingredient.isEmpty()) {
                    defaultedList.add(ingredient);
                }
            }

            return defaultedList;
        }

        @Override
        public CastIronCauldronRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> defaultedList = getIngredients(JsonHelper.getArray(json, "ingredients"));
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            return new CastIronCauldronRecipe(defaultedList, itemStack);
        }

        @Override
        public CastIronCauldronRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));

            ItemStack output = buf.readItemStack();
            return new CastIronCauldronRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, CastIronCauldronRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getResult());
        }
    }
}
