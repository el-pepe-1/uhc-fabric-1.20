package com.elpepe.uhc.item.food;

import com.elpepe.uhc.effect.ModEffects;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_4174;

public class ModFoodComponents {
   public static final class_4174 SWEET_BERRIES_JAM;
   public static final class_4174 GLOW_BERRIES_JAM;
   public static final class_4174 POISONOUS_SOUP;
   public static final class_4174 SEAFOOD_SOUP;
   public static final class_4174 GOAT_MEAT;
   public static final class_4174 COOKED_GOAT_MEAT;
   public static final class_4174 HORSE_LIKE_MEAT;
   public static final class_4174 COOKED_HORSE_LIKE_MEAT;
   public static final class_4174 LLAMA_MEAT;
   public static final class_4174 COOKED_LLAMA_MEAT;
   public static final class_4174 RAVAGER_MEAT;
   public static final class_4174 COOKED_RAVAGER_MEAT;

   public ModFoodComponents() {
   }

   static {
      SWEET_BERRIES_JAM = (new class_4174.class_4175()).method_19238(7).method_19237(0.4F).method_19239(new class_1293(ModEffects.FOX_GRACE_EFFECT, 2400, 1, true, true, true), 1.0F).method_19242();
      GLOW_BERRIES_JAM = (new class_4174.class_4175()).method_19238(5).method_19237(0.3F).method_19242();
      POISONOUS_SOUP = (new class_4174.class_4175()).method_19238(3).method_19237(0.15F).method_19239(new class_1293(class_1294.field_5899, 100, 0, true, false, false), 0.65F).method_19239(new class_1293(class_1294.field_5904, 200, 1, true, false, false), 1.0F).method_19239(new class_1293(class_1294.field_5916, 150, 1, true, false, false), 0.85F).method_19242();
      SEAFOOD_SOUP = (new class_4174.class_4175()).method_19238(5).method_19237(0.3F).method_19239(new class_1293(class_1294.field_5900, 4800, 1, true, false, false), 1.0F).method_19239(new class_1293(class_1294.field_5925, 4800, 1, true, false, false), 1.0F).method_19239(new class_1293(class_1294.field_5923, 4800, 1, true, false, false), 1.0F).method_19242();
      GOAT_MEAT = (new class_4174.class_4175()).method_19238(1).method_19237(0.15F).method_19236().method_19242();
      COOKED_GOAT_MEAT = (new class_4174.class_4175()).method_19238(4).method_19237(0.25F).method_19236().method_19241().method_19242();
      HORSE_LIKE_MEAT = (new class_4174.class_4175()).method_19238(2).method_19237(0.2F).method_19236().method_19242();
      COOKED_HORSE_LIKE_MEAT = (new class_4174.class_4175()).method_19238(7).method_19237(0.35F).method_19236().method_19242();
      LLAMA_MEAT = (new class_4174.class_4175()).method_19238(1).method_19237(0.1F).method_19236().method_19242();
      COOKED_LLAMA_MEAT = (new class_4174.class_4175()).method_19238(5).method_19237(0.25F).method_19236().method_19241().method_19240().method_19242();
      RAVAGER_MEAT = (new class_4174.class_4175()).method_19238(4).method_19237(0.2F).method_19236().method_19242();
      COOKED_RAVAGER_MEAT = (new class_4174.class_4175()).method_19238(10).method_19237(0.5F).method_19236().method_19242();
   }
}
