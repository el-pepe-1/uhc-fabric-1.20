package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.registry.Registries;

public class SpawnParticleS2CPacket {
   public SpawnParticleS2CPacket() {
   }

   public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
      ParticleType<?> particleType = (ParticleType)buf.readRegistryValue(Registries.PARTICLE_TYPE);
      ParticleEffect particleEffect = readParticleParameters(buf, particleType);
      double x = buf.readDouble();
      double y = buf.readDouble();
      double z = buf.readDouble();
      double velocityX = buf.readDouble();
      double velocityY = buf.readDouble();
      double velocityZ = buf.readDouble();
      if (client.player != null && client.player.getWorld() != null) {
         client.player.getWorld().addParticle(particleEffect, x, y, z, velocityX, velocityY, velocityZ);
      }

   }

   private static <T extends ParticleEffect> T readParticleParameters(PacketByteBuf buf, ParticleType<T> type) {
      return type.getParametersFactory().read(type, buf);
   }
}
