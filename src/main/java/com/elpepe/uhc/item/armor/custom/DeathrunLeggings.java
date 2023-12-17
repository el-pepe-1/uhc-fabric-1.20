package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import com.elpepe.uhc.particle.ModParticles;
import com.elpepe.uhc.util.ServerUtils;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Random;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.class_1323;
import org.jetbrains.annotations.Nullable;

public class DeathrunLeggings extends ArmorItem implements TickableArmor {
   private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

   public DeathrunLeggings(ArmorMaterial material, ArmorItem.class_8051 type, Item.class_1793 settings) {
      super(material, type, settings);
      ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", (double)material.getProtection(type), class_1323.ADDITION));
      builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier("Armor toughness", (double)material.getToughness(), class_1323.ADDITION));
      builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier("Armor speed", 0.1, class_1323.ADDITION));
      this.defaultModifiers = builder.build();
   }

   public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
      return slot == this.type.getEquipmentSlot() ? this.defaultModifiers : super.getAttributeModifiers(slot);
   }

   public void tick(LivingEntity user) {
      if (!user.getWorld().isClient()) {
         ServerWorld world = (ServerWorld)user.getWorld();
         Random rand = new Random();
         if (rand.nextInt(3) == 2) {
            Vec3d pos = user.getPos();
            double minVelocity = -0.75;
            double maxVelocity = 0.75;
            Vec3d vec = new Vec3d(rand.nextDouble(minVelocity, maxVelocity), rand.nextDouble(minVelocity, maxVelocity), rand.nextDouble(minVelocity, maxVelocity));
            ServerUtils.spawnParticle(world, ModParticles.LIGHTNING_PARTICLE, pos.x + rand.nextDouble(-1.0, 1.0), pos.y + rand.nextDouble(-1.0, 1.0) + 1.0, pos.z + rand.nextDouble(-1.0, 1.0), vec);
         }

         if (rand.nextInt(21) == 20) {
            ItemStack stack = user.getEquippedStack(this.type.getEquipmentSlot());
            NbtCompound nbt = stack.getOrCreateNbt();
            int runtime = nbt.getInt("runtime");
            if (runtime >= 60) {
               user.damage(user.getDamageSources().magic(), 1.0F);
            }

            if (user.isSprinting()) {
               nbt.putInt("runtime", runtime + 1);
            } else {
               nbt.putInt("runtime", runtime - 1);
            }
         }
      }

   }

   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      if (Screen.hasShiftDown()) {
         tooltip.add(Text.translatable("tooltip.uhc.deathrun_leggings"));
      } else {
         tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
      }

      super.appendTooltip(stack, world, tooltip, context);
   }
}
