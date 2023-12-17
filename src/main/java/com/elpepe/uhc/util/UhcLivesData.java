package com.elpepe.uhc.util;

import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class UhcLivesData {
    private static final String LIVES_KEY = "lives";

    public static int setLives(ServerPlayerEntity player, int amount) {
        IEntityDataSaver dataSaver = (IEntityDataSaver) player;
        NbtCompound nbt = dataSaver.getPersistentData();
        int lives = Math.min(Math.max(amount, 0), 3);
        nbt.putInt(LIVES_KEY, lives);
        syncUhcLives(player, lives);
        return lives;
    }

    public static int getLives(IEntityDataSaver player) {
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt(LIVES_KEY);
    }

    private static void syncUhcLives(ServerPlayerEntity player, int amount) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(amount);
        ServerPlayNetworking.send(player, ModMessages.UHC_LIVES_SYNC_ID, buf);
    }
}
