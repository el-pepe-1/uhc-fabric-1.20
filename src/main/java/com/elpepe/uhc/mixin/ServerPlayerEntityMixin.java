package com.elpepe.uhc.mixin;

import com.elpepe.uhc.util.IEntityDataSaver;
import com.elpepe.uhc.util.UhcLivesData;
import com.mojang.authlib.GameProfile;
import net.minecraft.class_1657;
import net.minecraft.class_1934;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_3222.class})
public abstract class ServerPlayerEntityMixin extends class_1657 {
   @Shadow
   public abstract void method_14226();

   public ServerPlayerEntityMixin(class_1937 world, class_2338 pos, float yaw, GameProfile gameProfile) {
      super(world, pos, yaw, gameProfile);
   }

   @Inject(
      method = {"copyFrom"},
      at = {@At("HEAD")}
   )
   private void copyFrom(class_3222 oldPlayer, boolean alive, CallbackInfo ci) {
      class_3222 player = (class_3222)this;
      int oldPlayerLives = UhcLivesData.getLives((IEntityDataSaver)oldPlayer) - 1;
      if (oldPlayerLives > 0) {
         UhcLivesData.setLives(player, oldPlayerLives);
      } else {
         player.field_13974.method_30118(class_1934.field_9219);
      }

   }
}
