package com.elpepe.uhc.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class PlaySoundS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        SoundEvent sound = buf.readRegistryValue(Registries.SOUND_EVENT);
        SoundCategory category = buf.readEnumConstant(SoundCategory.class);
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float volume = buf.readFloat();
        float pitch = buf.readFloat();
        client.player.getWorld().playSound(client.player, x, y, z, sound, category, volume, pitch);
    }
}
