package com.elpepe.uhc.util;

import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_3222;

public class UhcLivesData {
   public UhcLivesData() {
   }

   public static int setLives(class_3222 player, int amount) {
      IEntityDataSaver dataSaver = (IEntityDataSaver)player;
      class_2487 nbt = dataSaver.getPersistentData();
      int lives = Math.min(Math.max(amount, 0), 3);
      nbt.method_10569("lives", lives);
      syncUhcLives(player, lives);
      return lives;
   }

   public static int getLives(IEntityDataSaver player) {
      class_2487 nbt = player.getPersistentData();
      return nbt.method_10550("lives");
   }

   private static void syncUhcLives(class_3222 player, int amount) {
      class_2540 buf = PacketByteBufs.create();
      buf.writeInt(amount);
      ServerPlayNetworking.send(player, ModMessages.UHC_LIVES_SYNC_ID, buf);
   }
}
