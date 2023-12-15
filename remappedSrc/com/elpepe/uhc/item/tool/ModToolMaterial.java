package com.elpepe.uhc.item.tool;

import com.elpepe.uhc.item.ModItems;
import java.util.function.Supplier;
import net.minecraft.class_1802;
import net.minecraft.class_1832;
import net.minecraft.class_1856;
import net.minecraft.class_1935;

public enum ModToolMaterial implements class_1832 {
   NITHRIL(4, 512, 25.0F, 2.0F, 23, () -> {
      return class_1856.method_8091(new class_1935[]{ModItems.NITHRIL_INGOT});
   }),
   EMERALD(0, 512, 0.0F, 5.5F, 19, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8687});
   }),
   LAVA(0, 1016, 0.0F, 6.0F, 25, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8187});
   }),
   DRAGON(5, 2518, 70.0F, 7.0F, 25, () -> {
      return class_1856.method_8091(new class_1935[]{class_1802.field_8449});
   });

   private final int miningLevel;
   private final int itemDurability;
   private final float miningSpeed;
   private final float attackDamage;
   private final int enchantability;
   private final Supplier<class_1856> repairIngredient;

   private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
      this.miningLevel = miningLevel;
      this.itemDurability = itemDurability;
      this.miningSpeed = miningSpeed;
      this.attackDamage = attackDamage;
      this.enchantability = enchantability;
      this.repairIngredient = repairIngredient;
   }

   public int method_8025() {
      return this.itemDurability;
   }

   public float method_8027() {
      return this.miningSpeed;
   }

   public float method_8028() {
      return this.attackDamage;
   }

   public int method_8024() {
      return this.miningLevel;
   }

   public int method_8026() {
      return this.enchantability;
   }

   public class_1856 method_8023() {
      return (class_1856)this.repairIngredient.get();
   }
}
