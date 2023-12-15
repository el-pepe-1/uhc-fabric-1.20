package com.elpepe.uhc.item.armor;

import com.elpepe.uhc.item.ModItems;
import java.util.function.Supplier;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_3414;
import net.minecraft.class_3417;

public enum ModArmorMaterials implements class_1741 {
   NITHRIL("nithril", 20, new int[]{2, 7, 6, 2}, 22, class_3417.field_14862, 1.0F, 0.0F, () -> {
      return class_1856.method_8091(new class_1935[]{ModItems.NITHRIL_INGOT});
   }),
   POSEIDON("poseidon", 25, new int[]{2, 0, 0, 0}, 19, class_3417.field_14684, 1.0F, 0.0F, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8207});
   }),
   NIGHT_VISION("night_vision", 15, new int[]{2, 0, 0, 0}, 15, class_3417.field_14862, 0.0F, 0.0F, () -> {
      return class_1856.field_9017;
   }),
   DEATHRUN("deathrun", 15, new int[]{0, 0, -5, 0}, 22, class_3417.field_14862, 0.0F, 0.0F, () -> {
      return class_1856.field_9017;
   }),
   MAGMA("magma", 20, new int[]{0, 0, 0, 2}, 25, class_3417.field_15103, 1.0F, 0.0F, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8354});
   }),
   AIRTAG("airtag", 5, new int[]{1, 0, 0, 0}, 15, class_3417.field_14862, 0.0F, 0.0F, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8530});
   }),
   SLIME("slime", 15, new int[]{0, 0, 0, 1}, 12, class_3417.field_15191, 0.0F, 0.0F, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8777});
   }),
   FEATHER("feather", 5, new int[]{0, 0, 0, 1}, 15, class_3417.field_14581, 0.0F, 0.0F, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8153});
   });

   private final String name;
   private final int durabilityMultiplier;
   private final int[] protectionAmounts;
   private final int enchantability;
   private final class_3414 equipSound;
   private final float toughness;
   private final float knockbackResistance;
   private final Supplier<class_1856> repairIngredient;
   private static final int[] BASE_DURABILITY = new int[]{11, 16, 15, 13};

   private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, class_3414 equipSound, float toughness, float knockbackResistance, Supplier repairIngredient) {
      this.name = name;
      this.durabilityMultiplier = durabilityMultiplier;
      this.protectionAmounts = protectionAmounts;
      this.enchantability = enchantability;
      this.equipSound = equipSound;
      this.toughness = toughness;
      this.knockbackResistance = knockbackResistance;
      this.repairIngredient = repairIngredient;
   }

   public int method_48402(class_1738.class_8051 type) {
      return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
   }

   public int method_48403(class_1738.class_8051 type) {
      return this.protectionAmounts[type.ordinal()];
   }

   public int method_7699() {
      return this.enchantability;
   }

   public class_3414 method_7698() {
      return this.equipSound;
   }

   public class_1856 method_7695() {
      return (class_1856)this.repairIngredient.get();
   }

   public String method_7694() {
      return "uhc:" + this.name;
   }

   public float method_7700() {
      return this.toughness;
   }

   public float method_24355() {
      return this.knockbackResistance;
   }
}
