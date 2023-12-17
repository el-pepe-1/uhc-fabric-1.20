package com.elpepe.uhc.entity.custom;

import com.elpepe.uhc.entity.ModEntities;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.hit.HitResult.class_240;

public class HarpoonProjectileEntity extends PersistentProjectileEntity {
   private static final List<EntityType<?>> BIG_ENTITIES;
   private static final TrackedData<Integer> CAN_FLY;
   private static final TrackedData<Integer> FLEW;
   private ItemStack heldItem;
   private Vec3d moveDirection;
   private boolean goesBackwards;
   private UUID caughtEntityUUID;

   public HarpoonProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
      super(entityType, world);
   }

   public HarpoonProjectileEntity(World world, PlayerEntity player, ItemStack heldItem) {
      super(ModEntities.HARPOON_PROJECTILE, world);
      this.setOwner(player);
      this.heldItem = heldItem;
      this.moveDirection = player.getRotationVector();
      this.goesBackwards = false;
      this.caughtEntityUUID = null;
      this.refreshPositionAndAngles(player.getX(), player.getY() + 1.75, player.getZ(), this.getYaw(), this.getPitch());
      this.heldItem.getOrCreateNbt().putByte("shooting", (byte)1);
   }

   public void tick() {
      super.tick();
      if (this.inGround || this.age > 300) {
         this.discard();
      }

      if (!this.getWorld().isClient()) {
         if (this.getOwner() != null) {
            ((LivingEntity)this.getOwner()).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 100, false, false, false));
            this.setOwnerVelocity(new Vec3d(0.0, this.getOwner().isOnGround() ? 0.0 : this.getOwner().getVelocity().getY(), 0.0));
            ((PlayerEntity)this.getOwner()).getItemCooldownManager().set(this.heldItem.getItem(), 100);
         }

         if (this.getFlew() >= this.getCanFly() && this.goesBackwards) {
            this.discard();
         } else if (this.getFlew() >= this.getCanFly() && !this.goesBackwards) {
            this.goesBackwards = true;
            this.setFlew(0);
         }

         if (this.moveDirection != null) {
            int direction = this.goesBackwards ? -1 : 1;
            Vec3d vec = this.moveDirection.multiply(0.35).multiply((double)direction);
            this.setVelocity(vec);
            if (this.caughtEntityUUID != null) {
               World world = this.getWorld();
               if (world instanceof ServerWorld serverWorld) {
                   Entity entity = serverWorld.getEntity(this.caughtEntityUUID);
                  if (entity instanceof LivingEntity) {
                     entity.setVelocity(vec.multiply(1.0, 0.0, 1.0));
                     entity.velocityModified = true;
                  }
               }
            }
         }
      }

      HitResult hitresult = ProjectileUtil.getCollision(this, (x$0) -> this.canHit(x$0));
      if (hitresult.getType() != HitResult.Type.MISS) {
         this.onCollision(hitresult);
      }

      this.updateRotation();
      if (this.getWorld().getStatesInBox(this.getBoundingBox()).noneMatch(AbstractBlock.class_4971::method_26215)) {
         this.discard();
      } else if (this.isInsideWaterOrBubbleColumn()) {
         this.discard();
      }

      this.setFlew(this.getFlew() + 1);
   }

   protected void onEntityHit(EntityHitResult entityHitResult) {
      if (!this.getWorld().isClient()) {
         if (this.getOwner() == null) {
            this.discard();
         }

         if (entityHitResult.getEntity() == this.getOwner()) {
            return;
         }

         if (!this.goesBackwards) {
            entityHitResult.getEntity().damage(this.getDamageSources().arrow(this, this.getOwner()), 2.0F);
         }

         if (BIG_ENTITIES.contains(entityHitResult.getEntity().getType())) {
            this.caughtEntityUUID = this.getOwner().getUuid();
            this.moveDirection = this.moveDirection.multiply(-1.0);
            this.setInvisible(true);
            this.teleport(this.getOwner().getX(), this.getOwner().getY() + 1.75, this.getOwner().getZ());
         } else {
            this.caughtEntityUUID = entityHitResult.getEntity().getUuid();
         }

         this.setCanFly(this.getFlew());
         this.setFlew(0);
         this.goesBackwards = true;
      }

   }

   protected void onBlockHit(BlockHitResult blockHitResult) {
      if (this.getOwner() != null && !this.getWorld().isClient()) {
         Vec3d vec = blockHitResult.getPos().subtract(this.getOwner().getPos()).normalize();
         this.setOwnerVelocity(vec.multiply(2.5, 1.0, 2.5));
      }

      this.discard();
   }

   private void setOwnerVelocity(Vec3d velocity) {
      if (this.getOwner() != null) {
         this.getOwner().setVelocity(velocity);
         this.getOwner().velocityModified = true;
      }

   }

   public void setCanFly(int canFly) {
      this.dataTracker.set(CAN_FLY, canFly);
   }

   public void setFlew(int flew) {
      this.dataTracker.set(FLEW, flew);
   }

   public int getCanFly() {
      return (Integer)this.dataTracker.get(CAN_FLY);
   }

   public int getFlew() {
      return (Integer)this.dataTracker.get(FLEW);
   }

   protected void initDataTracker() {
      super.initDataTracker();
      this.dataTracker.startTracking(CAN_FLY, 0);
      this.dataTracker.startTracking(FLEW, 0);
   }

   protected ItemStack asItemStack() {
      return ItemStack.EMPTY;
   }

   public boolean hasNoGravity() {
      return true;
   }

   public void onRemoved() {
      this.heldItem.getOrCreateNbt().putByte("shooting", (byte)0);
      super.onRemoved();
   }

   static {
      BIG_ENTITIES = List.of(EntityType.IRON_GOLEM, EntityType.PANDA, EntityType.POLAR_BEAR, EntityType.HOGLIN, EntityType.ZOGLIN, EntityType.SNIFFER, EntityType.CAMEL, EntityType.ENDER_DRAGON, EntityType.WITHER, EntityType.RAVAGER);
      CAN_FLY = DataTracker.registerData(HarpoonProjectileEntity.class, TrackedDataHandlerRegistry.INTEGER);
      FLEW = DataTracker.registerData(HarpoonProjectileEntity.class, TrackedDataHandlerRegistry.INTEGER);
   }
}
