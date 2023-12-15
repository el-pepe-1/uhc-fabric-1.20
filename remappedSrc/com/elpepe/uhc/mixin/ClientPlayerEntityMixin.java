package com.elpepe.uhc.mixin;

import com.elpepe.uhc.client.UhcClientData;
import com.elpepe.uhc.effect.ModEffects;
import com.elpepe.uhc.networking.ModMessages;
import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.class_2540;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_746.class})
public abstract class ClientPlayerEntityMixin extends class_742 {
   private int jumpStrength;
   private boolean jumpDelta;

   public ClientPlayerEntityMixin(class_638 world, GameProfile profile) {
      super(world, profile);
   }

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   public void tick(CallbackInfo ci) {
      class_746 entity = (class_746)this;
      if (entity.method_6059(ModEffects.FOX_GRACE_EFFECT)) {
         if (entity.field_3913.field_3904 && !this.jumpDelta) {
            this.jumpDelta = true;
         } else if (!entity.field_3913.field_3904 && this.jumpDelta) {
            if (this.jumpStrength > 20) {
               float velocity = Math.min((float)this.jumpStrength, 130.0F) / 20.0F * 0.3F;
               class_2540 buf = PacketByteBufs.create();
               buf.writeFloat(velocity);
               ClientPlayNetworking.send(ModMessages.FOX_GRACE_JUMP_ID, buf);
            }

            this.jumpDelta = false;
            this.setJumpStrength(0);
         } else if (entity.field_3913.field_3904 && this.jumpDelta && this.jumpStrength < 80) {
            this.setJumpStrength(this.jumpStrength + 1);
         }
      }

   }

   @Unique
   private void setJumpStrength(int jumpStrength) {
      this.jumpStrength = jumpStrength;
      UhcClientData.jumpStrength = jumpStrength;
   }
}
