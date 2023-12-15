package com.elpepe.uhc.networking.packet;

import com.elpepe.uhc.client.UhcClientData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_2540;
import net.minecraft.class_310;
import net.minecraft.class_634;

public class DamageSyncS2CPacket {
   public DamageSyncS2CPacket() {
   }

   public static void receive(class_310 client, class_634 handler, class_2540 buf, PacketSender responseSender) {
      UhcClientData.damageAmount = buf.readFloat();
      UhcClientData.renderDamageAmountTime = 50;
   }
}
