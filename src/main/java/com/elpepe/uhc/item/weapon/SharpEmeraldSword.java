package com.elpepe.uhc.item.weapon;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SharpEmeraldSword extends SwordItem {
   public SharpEmeraldSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.class_1793 settings) {
      super(toolMaterial, attackDamage, attackSpeed, settings);
   }

   public boolean hasGlint(ItemStack stack) {
      return true;
   }
}
