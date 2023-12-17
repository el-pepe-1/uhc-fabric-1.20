package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.class_1323;
import org.jetbrains.annotations.Nullable;

public class MagmaBoots extends ArmorItem implements TickableArmor {
   private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

   public MagmaBoots(ArmorMaterial material, ArmorItem.class_8051 type, Item.class_1793 settings) {
      super(material, type, settings);
      ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", (double)material.getProtection(type), class_1323.ADDITION));
      builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier("Armor toughness", (double)material.getToughness(), class_1323.ADDITION));
      builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier("Armor health", -0.5, class_1323.MULTIPLY_BASE));
      this.defaultModifiers = builder.build();
   }

   public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
      return slot == this.type.getEquipmentSlot() ? this.defaultModifiers : super.getAttributeModifiers(slot);
   }

   public void tick(LivingEntity user) {
      if (user.getSteppingBlockState().getBlock().equals(Blocks.LAVA)) {
         user.setPos(user.getX(), (double)(user.getSteppingPos().getY() + 1), user.getZ());
         user.setVelocity(user.getVelocity().getX(), 0.0, user.getVelocity().getZ());
         user.setFireTicks(0);
         user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 0, true, false, false));
      }

   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         tooltip.add(Text.translatable("tooltip.uhc.magma_boots"));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }
}
