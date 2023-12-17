package com.elpepe.uhc.util;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.GameRules;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.GameRules.class_5198;

public class ModGameRules {
   public static final GameRules.class_4313<GameRules.class_4310> UHC_ENABLED;

   public static void registerGameRules() {
      Uhc.LOGGER.info("Registering Game Rules for " + Uhc.MOD_ID);
   }

   static {
      UHC_ENABLED = GameRuleRegistry.register("uhcEnabled", class_5198.PLAYER, GameRuleFactory.createBooleanRule(false, (server, value) -> {
         server.getPlayerManager().getPlayerList().forEach((player) -> {
            UhcLivesData.setLives(player, 3);
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBoolean(value.get());
            ServerPlayNetworking.send(player, ModMessages.UHC_ENABLED_SYNC_ID, buf);
         });
      }));
   }
}
