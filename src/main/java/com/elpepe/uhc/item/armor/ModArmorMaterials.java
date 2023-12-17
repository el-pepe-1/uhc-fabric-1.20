package com.elpepe.uhc.item.armor;

import com.elpepe.uhc.item.ModItems;
import java.util.function.Supplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ModArmorMaterials implements ArmorMaterial {
   NITHRIL("nithril", 20, new int[]{2, 7, 6, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> {
      return Ingredient.ofItems(new ItemConvertible[]{ModItems.NITHRIL_INGOT});
   }),
   POSEIDON("poseidon", 25, new int[]{2, 0, 0, 0}, 19, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 1.0F, 0.0F, () -> {
      return Ingredient.ofItems(new ItemConvertible[]{Items.HEART_OF_THE_SEA});
   }),
   NIGHT_VISION("night_vision", 15, new int[]{2, 0, 0, 0}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
      return Ingredient.EMPTY;
   }),
   DEATHRUN("deathrun", 15, new int[]{0, 0, -5, 0}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
      return Ingredient.EMPTY;
   }),
   MAGMA("magma", 20, new int[]{0, 0, 0, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> {
      return Ingredient.ofItems(new ItemConvertible[]{Items.MAGMA_BLOCK});
   }),
   AIRTAG("airtag", 5, new int[]{1, 0, 0, 0}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
      return Ingredient.ofItems(new ItemConvertible[]{Items.REDSTONE_TORCH});
   }),
   SLIME("slime", 15, new int[]{0, 0, 0, 1}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
      return Ingredient.ofItems(new ItemConvertible[]{Items.SLIME_BALL});
   }),
   FEATHER("feather", 5, new int[]{0, 0, 0, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
      return Ingredient.ofItems(new ItemConvertible[]{Items.FEATHER});
   });

   private final String name;
   private final int durabilityMultiplier;
   private final int[] protectionAmounts;
   private final int enchantability;
   private final SoundEvent equipSound;
   private final float toughness;
   private final float knockbackResistance;
   private final Supplier<Ingredient> repairIngredient;
   private static final int[] BASE_DURABILITY = new int[]{11, 16, 15, 13};

   private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier repairIngredient) {
      this.name = name;
      this.durabilityMultiplier = durabilityMultiplier;
      this.protectionAmounts = protectionAmounts;
      this.enchantability = enchantability;
      this.equipSound = equipSound;
      this.toughness = toughness;
      this.knockbackResistance = knockbackResistance;
      this.repairIngredient = repairIngredient;
   }

   public int getDurability(ArmorItem.class_8051 type) {
      return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
   }

   public int getProtection(ArmorItem.class_8051 type) {
      return this.protectionAmounts[type.ordinal()];
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public SoundEvent getEquipSound() {
      return this.equipSound;
   }

   public Ingredient getRepairIngredient() {
      return (Ingredient)this.repairIngredient.get();
   }

   public String getName() {
      return "uhc:" + this.name;
   }

   public float getToughness() {
      return this.toughness;
   }

   public float getKnockbackResistance() {
      return this.knockbackResistance;
   }
}
