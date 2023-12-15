package com.elpepe.uhc.util;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1928;
import net.minecraft.class_2540;
import net.minecraft.class_1928.class_5198;

public class ModGameRules {
   public static final class_1928.class_4313<class_1928.class_4310> UHC_ENABLED;

   public ModGameRules() {
   }

   public static void registerGameRules() {
      Uhc.LOGGER.info("Registering game rules for uhc");
   }

   static {
      UHC_ENABLED = GameRuleRegistry.register("uhcEnabled", class_5198.field_24094, GameRuleFactory.createBooleanRule(false, (server, value) -> {
         server.method_3760().method_14571().forEach((player) -> {
            UhcLivesData.setLives(player, 3);
            class_2540 buf = PacketByteBufs.create();
            buf.writeBoolean(value.method_20753());
            ServerPlayNetworking.send(player, ModMessages.UHC_ENABLED_SYNC_ID, buf);
         });
      }));
   }
}
