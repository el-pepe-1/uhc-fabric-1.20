package com.elpepe.uhc.entity.goal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class SleepGoal<E extends PathAwareEntity & EntityWithHome> extends Goal {
    private final E entity;
    private final float speed;
    private boolean reached;

    public SleepGoal(E entity, float speed) {
        this.entity = entity;
        this.speed = speed;
    }

    @Override
    public boolean canStart() {
        return this.entity.getWorld().isNight() && this.entity.getHome() != BlockPos.ORIGIN && this.entity.getWorld().getBlockState(this.entity.getHome()).isIn(BlockTags.BEDS);
    }

    public double getDesiredDistanceToTarget() {
        return 2.0;
    }

    @Override
    public void tick() {
        BlockPos pos = this.entity.getHome();
        boolean withinDistance = pos.up().isWithinDistance(this.entity.getPos(), this.getDesiredDistanceToTarget());
        if (!withinDistance) {
            this.reached = false;
            this.entity.getNavigation().startMovingTo(pos.getX(), pos.getY(), pos.getZ(), this.speed);
        } else {
            this.reached = true;
            this.entity.sleep(this.entity.getHome());
        }

        super.tick();
    }

    @Override
    public void stop() {
        super.stop();
        this.reached = false;
        this.entity.wakeUp();
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }
}
