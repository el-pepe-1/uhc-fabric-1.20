package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_243;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import net.minecraft.server.MinecraftServer;

public class FoxGraceJumpC2SPacket {
   public FoxGraceJumpC2SPacket() {
   }

   public static void receive(MinecraftServer server, class_3222 player, class_3244 handler, class_2540 buf, PacketSender responseSender) {
      float jumpStrength = buf.readFloat();
      class_243 vec = player.method_18798().method_1021(1.4);
      player.method_18800(vec.method_10216(), (double)jumpStrength, vec.method_10215());
      player.field_6037 = true;
   }
}
