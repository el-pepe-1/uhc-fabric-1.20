package com.elpepe.uhc.entity.custom;

import com.elpepe.uhc.entity.ModEntities;
import java.util.List;
import java.util.Random;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7094;

public class LavaSwordProjectileEntity extends class_1308 {
   public final class_7094 idleAnimationState = new class_7094();
   private class_1657 owner = null;
   private int idleAnimationCooldown = 0;
   private int attackCooldown = 0;

   public LavaSwordProjectileEntity(class_1299<? extends class_1308> entityType, class_1937 world) {
      super(entityType, world);
   }

   public LavaSwordProjectileEntity(class_1937 world, class_1657 player) {
      super(ModEntities.LAVA_SWORD_PROJECTILE, world);
      this.setOwner(player);
      this.method_5808(player.method_23317(), player.method_23318() + 1.65, player.method_23321(), this.method_36454(), this.method_36455());
   }

   public static class_5132.class_5133 createLavaSwordProjectileAttributes() {
      return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23719, 0.20000000298023224).method_26868(class_5134.field_23724, 0.5).method_26868(class_5134.field_23721, 1.0);
   }

   protected void method_48565(float posDelta) {
      float f = this.method_18376() == class_4050.field_18077 ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
      this.field_42108.method_48568(f, 0.2F);
   }

   private void setupAnimationStates() {
      if (this.idleAnimationCooldown <= 0) {
         this.idleAnimationCooldown = 80;
         this.idleAnimationState.method_41322(this.field_6012);
      } else {
         --this.idleAnimationCooldown;
      }

   }

   public void method_5773() {
      super.method_5773();
      if (this.method_37908().method_8608()) {
         this.setupAnimationStates();
      }

      class_1297 attacker = this.getOwner() != null ? this.getOwner() : this;
      if (!this.method_37908().method_8608()) {
         if (this.method_24828()) {
            this.method_18800(0.0, 0.1, 0.0);
            this.field_6037 = true;
         }

         if (this.field_6012 > 1500) {
            this.method_31472();
         }

         if (this.attackCooldown <= 0) {
            List<class_1309> entities = this.method_37908().method_8390(class_1309.class, class_238.method_30048(this.method_19538(), 10.0, 10.0, 10.0), (entity) -> {
               return !entity.equals(this.getOwner()) && !entity.equals(this);
            });
            entities.forEach((entity) -> {
               entity.method_5643(this.method_48923().method_48815(this, attacker), 2.0F);
               entity.method_20803(60);
               this.attackCooldown = 100;
            });
         }

         --this.attackCooldown;
      } else if (this.field_5974.method_39332(0, 3) == 1) {
         this.spawnFireParticles(this.method_19538().method_1031(0.0, 1.5, 0.0), 3.0, 1, 2);
         this.method_37908().method_8396((class_1657)null, this.method_24515(), class_3417.field_15102, class_3419.field_15251, 1.0F, 1.2F);
      }

   }

   private void spawnFireParticles(class_243 pos, double distance, int particlesMin, int particlesMax) {
      int randomizedParticlesCount = this.field_5974.method_39332(particlesMin, particlesMax);
      this.spawnFireParticles(pos, distance, randomizedParticlesCount);
   }

   private void spawnFireParticles(class_243 pos, double distance, int particlesCount) {
      Random rand = new Random();

      for(int i = 0; i < particlesCount; ++i) {
         class_243 randomVec = new class_243(rand.nextDouble(-distance, distance), rand.nextDouble(-distance, distance), rand.nextDouble(-distance, distance));
         class_243 velocity = randomVec.method_1029().method_1021(0.15);
         class_243 newPos = pos.method_1019(randomVec);
         this.method_37908().method_8406(class_2398.field_11240, newPos.field_1352, newPos.field_1351, newPos.field_1350, velocity.field_1352, velocity.field_1351, velocity.field_1350);
      }

   }

   public class_1657 getOwner() {
      return this.owner;
   }

   public void setOwner(class_1657 owner) {
      this.owner = owner;
   }

   public boolean method_5654(double offsetX, double offsetY, double offsetZ) {
      return true;
   }

   public int method_20802() {
      return 0;
   }

   public boolean method_5643(class_1282 source, float amount) {
      return false;
   }

   public boolean method_5679(class_1282 damageSource) {
      return true;
   }

   public boolean method_5740() {
      return true;
   }

   public boolean method_5810() {
      return false;
   }
}
