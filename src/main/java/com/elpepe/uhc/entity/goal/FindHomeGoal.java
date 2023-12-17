package com.elpepe.uhc.entity.goal;

import java.util.Optional;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.minecraft.world.poi.PointOfInterestStorage.class_4155;

public class FindHomeGoal<E extends PathAwareEntity & EntityWithHome> extends IntervalGoal {
   private final E entity;
   private final int radius;
   private final int interval;

   public FindHomeGoal(E entity, int radius, int interval) {
      this.entity = entity;
      this.radius = radius;
      this.interval = interval;
   }

   public boolean canStart() {
      return (((EntityWithHome)this.entity).getHome() == BlockPos.ORIGIN || !this.entity.getWorld().getBlockState(((EntityWithHome)this.entity).getHome()).isIn(BlockTags.BEDS)) && super.canStart();
   }

   public void start() {
      this.tryFindHome();
      super.start();
   }

   protected int getInterval() {
      return this.interval;
   }

   private void tryFindHome() {
      ServerWorld serverWorld = (ServerWorld)this.entity.getWorld();
      BlockPos blockPos = this.entity.getBlockPos();
      Optional<BlockPos> optional = serverWorld.getPointOfInterestStorage().getPosition((registryEntry) -> {
         return registryEntry.matchesKey(PointOfInterestTypes.HOME);
      }, (pos) -> {
         return true;
      }, class_4155.HAS_SPACE, blockPos, this.radius, this.entity.getRandom());
      if (optional.isEmpty()) {
         ((EntityWithHome)this.entity).setHome(BlockPos.ORIGIN);
      }

      optional.ifPresent((pos) -> {
         ((EntityWithHome)this.entity).setHome(pos.toImmutable());
      });
   }
}
