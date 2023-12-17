package com.elpepe.uhc.particle;

import com.elpepe.uhc.Uhc;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticles {
   public static final DefaultParticleType LIGHTNING_PARTICLE = registerParticle("lightning_particle", FabricParticleTypes.simple());

   private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
      return (DefaultParticleType) Registry.register(Registries.PARTICLE_TYPE, new Identifier(Uhc.MOD_ID, name), particleType);
   }

   public static void registerParticles() {
      Uhc.LOGGER.info("Registering Particles for " + Uhc.MOD_ID);
   }
}
