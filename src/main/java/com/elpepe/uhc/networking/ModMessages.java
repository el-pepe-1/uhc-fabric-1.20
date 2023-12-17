package com.elpepe.uhc.networking;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.networking.packet.DamageSyncS2CPacket;
import com.elpepe.uhc.networking.packet.FoxGraceJumpC2SPacket;
import com.elpepe.uhc.networking.packet.PlaySoundS2CPacket;
import com.elpepe.uhc.networking.packet.SpawnParticleS2CPacket;
import com.elpepe.uhc.networking.packet.UhcEnabledSyncS2CPacket;
import com.elpepe.uhc.networking.packet.UhcLivesSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
   public static final Identifier FOX_GRACE_JUMP_ID = new Identifier(Uhc.MOD_ID, "fox_grace_jump");
   public static final Identifier DAMAGE_SYNC_ID = new Identifier(Uhc.MOD_ID, "damage_sync");
   public static final Identifier UHC_LIVES_SYNC_ID = new Identifier(Uhc.MOD_ID, "uhc_lives_sync");
   public static final Identifier UHC_ENABLED_SYNC_ID = new Identifier(Uhc.MOD_ID, "uhc_enabled_sync");
   public static final Identifier SPAWN_PARTICLE_ID = new Identifier(Uhc.MOD_ID, "spawn_particle");
   public static final Identifier PLAY_SOUND_ID = new Identifier(Uhc.MOD_ID, "play_sound");

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
