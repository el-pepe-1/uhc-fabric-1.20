package com.elpepe.uhc.networking.packet;

import com.elpepe.uhc.client.UhcClientData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_2540;
import net.minecraft.class_310;
import net.minecraft.class_634;

public class UhcLivesSyncS2CPacket {
   public UhcLivesSyncS2CPacket() {
   }

   public static void receive(class_310 client, class_634 handler, class_2540 buf, PacketSender responseSender) {
      UhcClientData.uhcLives = buf.readInt();
   }
}
