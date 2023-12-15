package com.elpepe.uhc.particle;

import net.minecraft.particle.DefaultParticleType;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;

public class LightningParticle extends SpriteBillboardParticle {
   public LightningParticle(ClientWorld world, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
      super(world, xCoord, yCoord, zCoord, xd, yd, zd);
      this.velocityMultiplier = 0.5F;
      this.velocityX = xd;
      this.velocityY = yd;
      this.velocityZ = zd;
      this.scale *= 0.75F;
      this.maxAge = 10;
      this.setSpriteForAge(spriteSet);
      this.red = 1.0F;
      this.green = 1.0F;
      this.blue = 1.0F;
   }

   @Override
   public ParticleTextureSheet getType() {
      return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
   }

   public static class Factory implements ParticleFactory<DefaultParticleType> {
      private final SpriteProvider sprites;

      public Factory(SpriteProvider spriteProvider) {
         this.sprites = spriteProvider;
      }

      public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
         return new LightningParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
      }
   }
}
