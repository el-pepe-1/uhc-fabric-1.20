package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2540;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_7923;

public class SpawnParticleS2CPacket {
   public SpawnParticleS2CPacket() {
   }

   public static void receive(class_310 client, class_634 handler, class_2540 buf, PacketSender responseSender) {
      class_2396<?> particleType = (class_2396)buf.method_42064(class_7923.field_41180);
      class_2394 particleEffect = readParticleParameters(buf, particleType);
      double x = buf.readDouble();
      double y = buf.readDouble();
      double z = buf.readDouble();
      double velocityX = buf.readDouble();
      double velocityY = buf.readDouble();
      double velocityZ = buf.readDouble();
      if (client.field_1724 != null && client.field_1724.method_37908() != null) {
         client.field_1724.method_37908().method_8406(particleEffect, x, y, z, velocityX, velocityY, velocityZ);
      }

   }

   private static <T extends class_2394> T readParticleParameters(class_2540 buf, class_2396<T> type) {
      return type.method_10298().method_10297(type, buf);
   }
}
