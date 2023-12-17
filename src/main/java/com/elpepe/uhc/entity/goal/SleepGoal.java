package com.elpepe.uhc.entity.goal;

import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.registry.tag.BlockTags;

public class SleepGoal<E extends PathAwareEntity & EntityWithHome> extends Goal {
   private final E entity;
   private final float speed;
   private boolean reached;

   public SleepGoal(E entity, float speed) {
      this.entity = entity;
      this.speed = speed;
   }

   public boolean canStart() {
      return this.entity.getWorld().isNight() && ((EntityWithHome)this.entity).getHome() != BlockPos.ORIGIN && this.entity.getWorld().getBlockState(((EntityWithHome)this.entity).getHome()).isIn(BlockTags.BEDS);
   }

   public double getDesiredDistanceToTarget() {
      return 2.0;
   }

   public void tick() {
      BlockPos pos = ((EntityWithHome)this.entity).getHome();
      boolean withinDistance = pos.up().isWithinDistance(this.entity.getPos(), this.getDesiredDistanceToTarget());
      if (!withinDistance) {
         this.reached = false;
         this.entity.getNavigation().startMovingTo((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)this.speed);
      } else {
         this.reached = true;
         this.entity.sleep(((EntityWithHome)this.entity).getHome());
      }

      super.tick();
   }

   public void stop() {
      super.stop();
      this.reached = false;
      this.entity.wakeUp();
   }

   public boolean shouldRunEveryTick() {
      return true;
   }
}
