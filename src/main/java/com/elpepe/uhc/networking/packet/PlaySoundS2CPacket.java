package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.registry.Registries;

public class PlaySoundS2CPacket {
   public PlaySoundS2CPacket() {
   }

   public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
      SoundEvent sound = (SoundEvent)buf.readRegistryValue(Registries.SOUND_EVENT);
      SoundCategory category = (SoundCategory)buf.readEnumConstant(SoundCategory.class);
      double x = buf.readDouble();
      double y = buf.readDouble();
      double z = buf.readDouble();
      float volume = buf.readFloat();
      float pitch = buf.readFloat();
      client.player.getWorld().playSound(client.player, x, y, z, sound, category, volume, pitch);
   }
}
