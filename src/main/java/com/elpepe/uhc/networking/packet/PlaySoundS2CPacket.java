package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_2540;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_634;
import net.minecraft.class_7923;

public class PlaySoundS2CPacket {
   public PlaySoundS2CPacket() {
   }

   public static void receive(class_310 client, class_634 handler, class_2540 buf, PacketSender responseSender) {
      class_3414 sound = (class_3414)buf.method_42064(class_7923.field_41172);
      class_3419 category = (class_3419)buf.method_10818(class_3419.class);
      double x = buf.readDouble();
      double y = buf.readDouble();
      double z = buf.readDouble();
      float volume = buf.readFloat();
      float pitch = buf.readFloat();
      client.field_1724.method_37908().method_43128(client.field_1724, x, y, z, sound, category, volume, pitch);
   }
}
