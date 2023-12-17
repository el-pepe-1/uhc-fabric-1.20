package com.elpepe.uhc.mixin;

import com.elpepe.uhc.util.IEntityDataSaver;
import com.elpepe.uhc.util.UhcLivesData;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ServerPlayerEntity.class})
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
   @Shadow
   public abstract void playerTick();

   public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
      super(world, pos, yaw, gameProfile);
   }

   @Inject(
      method = {"copyFrom"},
      at = {@At("HEAD")}
   )
   private void copyFrom(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
      ServerPlayerEntity player = (ServerPlayerEntity)this;
      int oldPlayerLives = UhcLivesData.getLives((IEntityDataSaver)oldPlayer) - 1;
      if (oldPlayerLives > 0) {
         UhcLivesData.setLives(player, oldPlayerLives);
      } else {
         player.interactionManager.changeGameMode(GameMode.SPECTATOR);
      }

   }
}
