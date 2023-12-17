package com.elpepe.uhc.networking.packet;

import com.elpepe.uhc.client.UhcClientData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class DamageSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        UhcClientData.damageAmount = buf.readFloat();
        UhcClientData.renderDamageAmountTime = 50;
    }
}
