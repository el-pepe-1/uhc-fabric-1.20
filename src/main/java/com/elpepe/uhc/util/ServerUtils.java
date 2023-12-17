package com.elpepe.uhc.util;

import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public class ServerUtils {
    public static void spawnParticle(ServerWorld world, ParticleEffect particle, double x, double y, double z, Vec3d velocity) {
        world.getPlayers().forEach((player) -> {
            if (player.getBlockPos().isWithinDistance(new Vec3d(x, y, z), 32.0)) {
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeRegistryValue(Registries.PARTICLE_TYPE, particle.getType());
                buf.writeDouble(x);
                buf.writeDouble(y);
                buf.writeDouble(z);
                buf.writeDouble(velocity.x);
                buf.writeDouble(velocity.y);
                buf.writeDouble(velocity.z);
                ServerPlayNetworking.send(player, ModMessages.SPAWN_PARTICLE_ID, buf);
            }

        });
    }

    public static void playSound(ServerWorld world, SoundEvent event, SoundCategory category, double distance, double x, double y, double z, float volume, float pitch) {
        world.getPlayers().forEach((player) -> {
            if (player.getBlockPos().isWithinDistance(new Vec3d(x, y, z), distance)) {
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeRegistryValue(Registries.SOUND_EVENT, event);
                buf.writeEnumConstant(category);
                buf.writeDouble(x);
                buf.writeDouble(y);
                buf.writeDouble(z);
                buf.writeFloat(volume);
                buf.writeFloat(pitch);
                ServerPlayNetworking.send(player, ModMessages.PLAY_SOUND_ID, buf);
            }

        });
    }

    public static double getRandomDouble(Random rand, double min, double max) {
        return min + rand.nextDouble() * (max + 1.0 - min);
    }
}
