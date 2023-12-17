package com.elpepe.uhc.entity.goal;

import net.minecraft.entity.ai.goal.Goal;

public abstract class IntervalGoal extends Goal {
    protected int cooldown;

    @Override
    public boolean canStart() {
        if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        } else {
            this.cooldown = this.getInterval();
            return true;
        }
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }

    protected abstract int getInterval();
}
