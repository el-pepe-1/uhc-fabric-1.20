package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.armor.custom.SlimeBootsItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(at = @At("HEAD"), method = "onLanding")
    private void onLand(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof LivingEntity livingEntity && livingEntity.getEquippedStack(EquipmentSlot.FEET).getItem() instanceof SlimeBootsItem && entity.fallDistance > 5.0F && !entity.isSneaking()) {
            if (!entity.getWorld().isClient()) {
                Vec3d vec3d = entity.getVelocity();
                entity.setVelocity(vec3d.x, 0.0784000015258789 * (double) entity.fallDistance, vec3d.z);
                entity.velocityModified = true;
            } else {
                SlimeBootsItem.onJump(entity.getWorld(), (LivingEntity) entity);
                SlimeBootsItem.slimeParticles(entity.getWorld(), entity.getPos());
            }
        }
    }
}
