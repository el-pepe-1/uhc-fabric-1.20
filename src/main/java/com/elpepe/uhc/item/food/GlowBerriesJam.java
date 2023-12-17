package com.elpepe.uhc.item.food;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GlowBerriesJam extends JamFood {
   public GlowBerriesJam(Item.class_1793 settings) {
      super(settings);
   }

   public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
      List<Entity> entities = world.getOtherEntities(user, user.getBoundingBox().offset(0.0, -1.5, 0.0).expand(25.0), (entityx) -> {
         return entityx instanceof LivingEntity;
      });
      Iterator var5 = entities.iterator();

      while(var5.hasNext()) {
         Entity entity = (Entity)var5.next();
         if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, true, false, false));
         }
      }

      return super.finishUsing(stack, world, user);
   }
}
