package com.elpepe.uhc.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1277;
import net.minecraft.class_1662;
import net.minecraft.class_1799;
import net.minecraft.class_1856;
import net.minecraft.class_1860;
import net.minecraft.class_1865;
import net.minecraft.class_1869;
import net.minecraft.class_1937;
import net.minecraft.class_2371;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_3518;
import net.minecraft.class_3956;
import net.minecraft.class_5455;
import net.minecraft.class_5699;

public class CastIronCauldronRecipe implements class_1860<class_1277> {
   private final class_1799 output;
   private final List<class_1856> recipeItems;

   public CastIronCauldronRecipe(List<class_1856> ingredients, class_1799 output) {
      this.output = output;
      this.recipeItems = ingredients;
   }

   public boolean matches(class_1277 inventory, class_1937 world) {
      if (world.method_8608()) {
         return false;
      } else {
         class_1662 recipeMatcher = new class_1662();
         int i = 0;

         for(int j = 0; j < inventory.method_5439(); ++j) {
            class_1799 itemStack = inventory.method_5438(j);
            if (!itemStack.method_7960()) {
               ++i;
               recipeMatcher.method_20478(itemStack, 1);
            }
         }

         return i == this.recipeItems.size() && recipeMatcher.method_7402(this, (IntList)null);
      }
   }

   public class_1799 craft(class_1277 inventory, class_5455 registryManager) {
      return this.output;
   }

   public boolean method_8113(int width, int height) {
      return true;
   }

   public class_1799 method_8110(class_5455 registryManager) {
      return this.output;
   }

   public class_1799 getResult(class_5455 registryManager) {
      return this.method_8110(registryManager);
   }

   public class_2371<class_1856> method_8117() {
      class_2371<class_1856> list = class_2371.method_37434(this.recipeItems.size());
      list.addAll(this.recipeItems);
      return list;
   }

   public class_2960 method_8114() {
      return new class_2960("uhc", "cast_iron_cauldron");
   }

   public class_1865<?> method_8119() {
      return CastIronCauldronRecipe.Serializer.INSTANCE;
   }

   public class_3956<?> method_17716() {
      return CastIronCauldronRecipe.Type.INSTANCE;
   }

   public static class Type implements class_3956<CastIronCauldronRecipe> {
      public static final Type INSTANCE = new Type();
      public static final String ID = "cast_iron_cauldron";

      public Type() {
      }
   }

   public static class Serializer implements class_1865<CastIronCauldronRecipe> {
      public static final Serializer INSTANCE = new Serializer();
      public static final String ID = "cast_iron_cauldron";

      public Serializer() {
      }

      private static Codec<List<class_1856>> validateAmount(Codec<class_1856> delegate, int max) {
         return class_5699.method_48112(class_5699.method_48112(delegate.listOf(), (list) -> {
            return list.size() > max ? DataResult.error(() -> {
               return "Recipe has too many ingredients!";
            }) : DataResult.success(list);
         }), (list) -> {
            return list.isEmpty() ? DataResult.error(() -> {
               return "Recipe has no ingredients!";
            }) : DataResult.success(list);
         });
      }

      public CastIronCauldronRecipe read(class_2960 id, JsonObject json) {
         class_2371<class_1856> defaultedList = getIngredients(class_3518.method_15261(json, "ingredients"));
         class_1799 itemStack = class_1869.method_35228(class_3518.method_15296(json, "output"));
         return new CastIronCauldronRecipe(defaultedList, itemStack);
      }

      private static class_2371<class_1856> getIngredients(JsonArray json) {
         class_2371<class_1856> defaultedList = class_2371.method_10211();

         for(int i = 0; i < json.size(); ++i) {
            class_1856 ingredient = class_1856.method_8102(json.get(i), false);
            if (!ingredient.method_8103()) {
               defaultedList.add(ingredient);
            }
         }

         return defaultedList;
      }

      public CastIronCauldronRecipe read(class_2960 id, class_2540 buf) {
         class_2371<class_1856> inputs = class_2371.method_10213(buf.readInt(), class_1856.field_9017);

         for(int i = 0; i < inputs.size(); ++i) {
            inputs.set(i, class_1856.method_8086(buf));
         }

         class_1799 output = buf.method_10819();
         return new CastIronCauldronRecipe(inputs, output);
      }

      public void write(class_2540 buf, CastIronCauldronRecipe recipe) {
         buf.writeInt(recipe.method_8117().size());
         Iterator var3 = recipe.method_8117().iterator();

         while(var3.hasNext()) {
            class_1856 ingredient = (class_1856)var3.next();
            ingredient.method_8088(buf);
         }

         buf.method_10793(recipe.method_8110((class_5455)null));
      }
   }
}
