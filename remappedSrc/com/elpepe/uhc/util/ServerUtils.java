package com.elpepe.uhc.util;

import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2394;
import net.minecraft.class_243;
import net.minecraft.class_2540;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_5819;
import net.minecraft.class_7923;

public class ServerUtils {
   public ServerUtils() {
   }

   public static void spawnParticle(class_3218 world, class_2394 particle, double x, double y, double z, class_243 velocity) {
      world.method_18456().forEach((player) -> {
         if (player.method_24515().method_19769(new class_243(x, y, z), 32.0)) {
            class_2540 buf = PacketByteBufs.create();
            buf.method_42065(class_7923.field_41180, particle.method_10295());
            buf.writeDouble(x);
            buf.writeDouble(y);
            buf.writeDouble(z);
            buf.writeDouble(velocity.field_1352);
            buf.writeDouble(velocity.field_1351);
            buf.writeDouble(velocity.field_1350);
            ServerPlayNetworking.send(player, ModMessages.SPAWN_PARTICLE_ID, buf);
         }

      });
   }

   public static void playSound(class_3218 world, class_3414 event, class_3419 category, double distance, double x, double y, double z, float volume, float pitch) {
      world.method_18456().forEach((player) -> {
         if (player.method_24515().method_19769(new class_243(x, y, z), distance)) {
            class_2540 buf = PacketByteBufs.create();
            buf.method_42065(class_7923.field_41172, event);
            buf.method_10817(category);
            buf.writeDouble(x);
            buf.writeDouble(y);
            buf.writeDouble(z);
            buf.writeFloat(volume);
            buf.writeFloat(pitch);
            ServerPlayNetworking.send(player, ModMessages.PLAY_SOUND_ID, buf);
         }

      });
   }

   public static double getRandomDouble(class_5819 rand, double min, double max) {
      return min + rand.method_43058() * (max + 1.0 - min);
   }
}
