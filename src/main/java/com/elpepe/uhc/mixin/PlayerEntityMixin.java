package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.armor.custom.SlimeBoots;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({PlayerEntity.class})
public abstract class PlayerEntityMixin extends LivingEntity {
   @Shadow
   public abstract void playSound(SoundEvent var1, float var2, float var3);

   protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
      super(entityType, world);
   }

   @Inject(
      at = {@At("TAIL")},
      method = {"jump"}
   )
   private void onJump(CallbackInfo info) {
      this.getArmorItems().forEach((stack) -> {
         if (stack.getItem() instanceof SlimeBoots) {
            SlimeBoots.onJump(this.getWorld(), this);
            SlimeBoots.slimeParticles(this.getWorld(), this.getPos());
         }

      });
   }
}
