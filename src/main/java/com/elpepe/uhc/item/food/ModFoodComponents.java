package com.elpepe.uhc.item.food;

import com.elpepe.uhc.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
   public static final FoodComponent SWEET_BERRIES_JAM;
   public static final FoodComponent GLOW_BERRIES_JAM;
   public static final FoodComponent POISONOUS_SOUP;
   public static final FoodComponent SEAFOOD_SOUP;
   public static final FoodComponent GOAT_MEAT;
   public static final FoodComponent COOKED_GOAT_MEAT;
   public static final FoodComponent HORSE_LIKE_MEAT;
   public static final FoodComponent COOKED_HORSE_LIKE_MEAT;
   public static final FoodComponent LLAMA_MEAT;
   public static final FoodComponent COOKED_LLAMA_MEAT;
   public static final FoodComponent RAVAGER_MEAT;
   public static final FoodComponent COOKED_RAVAGER_MEAT;

   static {
      SWEET_BERRIES_JAM = (new FoodComponent.class_4175()).hunger(7).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(ModEffects.FOX_GRACE_EFFECT, 2400, 1, true, true, true), 1.0F).build();
      GLOW_BERRIES_JAM = (new FoodComponent.class_4175()).hunger(5).saturationModifier(0.3F).build();
      POISONOUS_SOUP = (new FoodComponent.class_4175()).hunger(3).saturationModifier(0.15F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0, true, false, false), 0.65F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1, true, false, false), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, 1, true, false, false), 0.85F).build();
      SEAFOOD_SOUP = (new FoodComponent.class_4175()).hunger(5).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 4800, 1, true, false, false), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 4800, 1, true, false, false), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 4800, 1, true, false, false), 1.0F).build();
      GOAT_MEAT = (new FoodComponent.class_4175()).hunger(1).saturationModifier(0.15F).meat().build();
      COOKED_GOAT_MEAT = (new FoodComponent.class_4175()).hunger(4).saturationModifier(0.25F).meat().snack().build();
      HORSE_LIKE_MEAT = (new FoodComponent.class_4175()).hunger(2).saturationModifier(0.2F).meat().build();
      COOKED_HORSE_LIKE_MEAT = (new FoodComponent.class_4175()).hunger(7).saturationModifier(0.35F).meat().build();
      LLAMA_MEAT = (new FoodComponent.class_4175()).hunger(1).saturationModifier(0.1F).meat().build();
      COOKED_LLAMA_MEAT = (new FoodComponent.class_4175()).hunger(5).saturationModifier(0.25F).meat().snack().alwaysEdible().build();
      RAVAGER_MEAT = (new FoodComponent.class_4175()).hunger(4).saturationModifier(0.2F).meat().build();
      COOKED_RAVAGER_MEAT = (new FoodComponent.class_4175()).hunger(10).saturationModifier(0.5F).meat().build();
   }
}
