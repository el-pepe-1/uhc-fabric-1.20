package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.armor.custom.SlimeBoots;
import net.minecraft.util.Nameable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.entity.EntityLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Entity.class})
public abstract class EntityMixin implements Nameable, EntityLike, CommandOutput {
   public EntityMixin(EntityType<?> type, World world) {
   }

   @Inject(
      at = {@At("HEAD")},
      method = {"onLanding"}
   )
   private void onLand(CallbackInfo ci) {
      Entity entity = (Entity)this;
      if (entity.isLiving()) {
         entity.getArmorItems().forEach((armor) -> {
            if (armor.getItem() instanceof SlimeBoots && entity.fallDistance > 5.0F && !entity.isSneaking()) {
               if (!entity.getWorld().isClient()) {
                  Vec3d vec3d = entity.getVelocity();
                  entity.setVelocity(vec3d.x, 0.0784000015258789 * (double)entity.fallDistance, vec3d.z);
                  entity.velocityModified = true;
               } else {
                  SlimeBoots.onJump(entity.getWorld(), (LivingEntity)entity);
                  SlimeBoots.slimeParticles(entity.getWorld(), entity.getPos());
               }
            }

         });
      }

   }
}
