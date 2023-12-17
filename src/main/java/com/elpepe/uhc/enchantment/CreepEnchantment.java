package com.elpepe.uhc.enchantment;

import com.elpepe.uhc.util.ServerUtils;
import java.util.List;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.world.World;
import net.minecraft.util.math.Box;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;

public class CreepEnchantment extends Enchantment {
   private static final String NBT_KEY = "creepEnchantmentHits";

   public CreepEnchantment(Enchantment.class_1888 weight, EquipmentSlot... slotTypes) {
      super(weight, EnchantmentTarget.WEAPON, slotTypes);
   }

   public void onTargetDamaged(LivingEntity user, Entity target, int level) {
      if (!user.getWorld().isClient()) {
         ItemStack stack = user.getStackInHand(Hand.MAIN_HAND);
         NbtCompound nbt = stack.getOrCreateNbt();
         if (nbt.getInt("creepEnchantmentHits") >= 10) {
            this.explode(user, target, user.getWorld());
            nbt.putInt("creepEnchantmentHits", 0);
         } else {
            user.sendMessage(Text.literal("increased"));
            nbt.putInt("creepEnchantmentHits", nbt.getInt("creepEnchantmentHits") + 1);
         }
      }

   }

   private void explode(LivingEntity user, Entity target, World world) {
      ServerWorld serverWorld = (ServerWorld)world;
      ServerUtils.playSound(serverWorld, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.MASTER, 15.0, user.getX(), user.getY(), user.getZ(), 1.0F, 1.0F);
      List<Entity> affectedEntities = world.getOtherEntities(user, new Box(target.getPos().subtract(4.0, 4.0, 4.0), target.getPos().add(4.0, 4.0, 4.0)), (entity) -> {
         return entity.isLiving();
      });
      affectedEntities.forEach((entity) -> {
         if (entity instanceof LivingEntity livingEntity) {
            livingEntity.damage(user.getDamageSources().explosion(entity, user), 9.0F);
         }

      });
   }
}
