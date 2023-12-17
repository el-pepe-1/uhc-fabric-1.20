package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class FoxGraceJumpC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        float jumpStrength = buf.readFloat();
        Vec3d vec = player.getVelocity().multiply(1.4);
        player.setVelocity(vec.getX(), jumpStrength, vec.getZ());
        player.velocityModified = true;
    }
}
