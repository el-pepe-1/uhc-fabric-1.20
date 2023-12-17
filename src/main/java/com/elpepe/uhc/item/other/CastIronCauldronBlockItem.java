package com.elpepe.uhc.item.other;

import com.elpepe.uhc.block.ModBlocks;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Equipment;
import net.minecraft.entity.attribute.EntityAttributeModifier.class_1323;

public class CastIronCauldronBlockItem extends BlockItem implements Equipment {
   private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

   public CastIronCauldronBlockItem(Item.class_1793 settings, float protection) {
      super(ModBlocks.CAST_IRON_CAULDRON, settings);
      ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", (double)protection, class_1323.ADDITION));
      this.defaultModifiers = builder.build();
   }

   public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
      return slot == this.getSlotType() ? this.defaultModifiers : super.getAttributeModifiers(slot);
   }

   public EquipmentSlot getSlotType() {
      return EquipmentSlot.HEAD;
   }

   public SoundEvent getEquipSound() {
      return SoundEvents.BLOCK_ANVIL_PLACE;
   }
}
