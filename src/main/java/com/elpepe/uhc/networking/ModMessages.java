package com.elpepe.uhc.networking;

import com.elpepe.uhc.networking.packet.DamageSyncS2CPacket;
import com.elpepe.uhc.networking.packet.FoxGraceJumpC2SPacket;
import com.elpepe.uhc.networking.packet.PlaySoundS2CPacket;
import com.elpepe.uhc.networking.packet.SpawnParticleS2CPacket;
import com.elpepe.uhc.networking.packet.UhcEnabledSyncS2CPacket;
import com.elpepe.uhc.networking.packet.UhcLivesSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2960;

public class ModMessages {
   public static final class_2960 FOX_GRACE_JUMP_ID = new class_2960("uhc", "fox_grace_jump");
   public static final class_2960 DAMAGE_SYNC_ID = new class_2960("uhc", "damage_sync");
   public static final class_2960 UHC_LIVES_SYNC_ID = new class_2960("uhc", "uhc_lives_sync");
   public static final class_2960 UHC_ENABLED_SYNC_ID = new class_2960("uhc", "uhc_enabled_sync");
   public static final class_2960 SPAWN_PARTICLE_ID = new class_2960("uhc", "spawn_particle");
   public static final class_2960 PLAY_SOUND_ID = new class_2960("uhc", "play_sound");

   public ModMessages() {
   }

   public static void registerC2SPackets() {
      ServerPlayNetworking.registerGlobalReceiver(FOX_GRACE_JUMP_ID, FoxGraceJumpC2SPacket::receive);
   }

   public static void registerS2CPackets() {
      ClientPlayNetworking.registerGlobalReceiver(DAMAGE_SYNC_ID, DamageSyncS2CPacket::receive);
      ClientPlayNetworking.registerGlobalReceiver(UHC_LIVES_SYNC_ID, UhcLivesSyncS2CPacket::receive);
      ClientPlayNetworking.registerGlobalReceiver(UHC_ENABLED_SYNC_ID, UhcEnabledSyncS2CPacket::receive);
      ClientPlayNetworking.registerGlobalReceiver(SPAWN_PARTICLE_ID, SpawnParticleS2CPacket::receive);
      ClientPlayNetworking.registerGlobalReceiver(PLAY_SOUND_ID, PlaySoundS2CPacket::receive);
   }
}
