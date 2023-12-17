package com.elpepe.uhc.item.other;

import com.elpepe.uhc.block.ModBlocks;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CastIronCauldronBlockItem extends BlockItem implements Equipment {
    private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

    public CastIronCauldronBlockItem(Item.Settings settings, float protection) {
        super(ModBlocks.CAST_IRON_CAULDRON, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", protection, Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == this.getSlotType() ? this.defaultModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_ANVIL_PLACE;
    }
}
