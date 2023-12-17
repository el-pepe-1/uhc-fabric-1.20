package com.elpepe.uhc.entity.custom;

import com.elpepe.uhc.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class LavaSwordProjectileEntity extends MobEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private PlayerEntity owner = null;
    private int idleAnimationCooldown = 0;
    private int attackCooldown = 0;

    public LavaSwordProjectileEntity(EntityType<? extends LavaSwordProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public LavaSwordProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.LAVA_SWORD_PROJECTILE, world);
        this.setOwner(player);
        this.refreshPositionAndAngles(player.getX(), player.getY() + 1.65, player.getZ(), this.getYaw(), this.getPitch());
    }

    public static DefaultAttributeContainer.Builder createLavaSwordProjectileAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.FALL_FLYING ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }

    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        Entity attacker = this.getOwner() != null ? this.getOwner() : this;
        if (!this.getWorld().isClient()) {
            if (this.isOnGround()) {
                this.setVelocity(0.0, 0.1, 0.0);
                this.velocityModified = true;
            }

            if (this.age > 1500) {
                this.discard();
            }

            if (this.attackCooldown <= 0) {
                List<LivingEntity> entities = this.getWorld().getEntitiesByClass(LivingEntity.class, Box.of(this.getPos(), 10.0, 10.0, 10.0), entity -> entity != this.owner && entity != this);
                entities.forEach(entity -> {
                    entity.damage(this.getDamageSources().indirectMagic(this, attacker), 2.0F);
                    entity.setFireTicks(60);
                    this.attackCooldown = 100;
                });
            }

            --this.attackCooldown;
        } else if (this.random.nextBetween(0, 3) == 1) {
            this.spawnFireParticles(this.getPos().add(0.0, 1.5, 0.0), 3.0, 1, 2);
            this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.HOSTILE, 1.0F, 1.2F);
        }

    }

    private void spawnFireParticles(Vec3d pos, double distance, int particlesMin, int particlesMax) {
        int randomizedParticlesCount = this.random.nextBetween(particlesMin, particlesMax);
        this.spawnFireParticles(pos, distance, randomizedParticlesCount);
    }

    private void spawnFireParticles(Vec3d pos, double distance, int particlesCount) {
        Random rand = new Random();

        for (int i = 0; i < particlesCount; ++i) {
            Vec3d randomVec = new Vec3d(rand.nextDouble(-distance, distance), rand.nextDouble(-distance, distance), rand.nextDouble(-distance, distance));
            Vec3d velocity = randomVec.normalize().multiply(0.15);
            Vec3d newPos = pos.add(randomVec);
            this.getWorld().addParticle(ParticleTypes.FLAME, newPos.x, newPos.y, newPos.z, velocity.x, velocity.y, velocity.z);
        }

    }

    public PlayerEntity getOwner() {
        return this.owner;
    }

    public void setOwner(PlayerEntity owner) {
        this.owner = owner;
    }

    @Override
    public boolean doesNotCollide(double offsetX, double offsetY, double offsetZ) {
        return true;
    }

    @Override
    public int getFireTicks() {
        return 0;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return true;
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}
