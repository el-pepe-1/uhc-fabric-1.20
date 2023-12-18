package com.elpepe.uhc.entity.goal;

import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.Optional;

public class FindHomeGoal<E extends PathAwareEntity & EntityWithHome> extends IntervalGoal {
    private final E entity;
    private final int radius;
    private final int interval;

    public FindHomeGoal(E entity, int radius, int interval) {
        this.entity = entity;
        this.radius = radius;
        this.interval = interval;
    }

    @Override
    public boolean canStart() {
        return (this.entity.getHome() == BlockPos.ORIGIN || !this.entity.getWorld().getBlockState(this.entity.getHome()).isIn(BlockTags.BEDS)) && super.canStart();
    }

    @Override
    public void start() {
        this.tryFindHome();
        super.start();
    }

    @Override
    protected int getInterval() {
        return this.interval;
    }

    private void tryFindHome() {
        ServerWorld serverWorld = (ServerWorld) this.entity.getWorld();
        BlockPos blockPos = this.entity.getBlockPos();
        Optional<BlockPos> optional = serverWorld.getPointOfInterestStorage().getPosition(registryEntry -> registryEntry.matchesKey(PointOfInterestTypes.HOME), (pos) -> true,
                PointOfInterestStorage.OccupationStatus.HAS_SPACE, blockPos, this.radius, this.entity.getRandom());
        if (optional.isEmpty()) {
            this.entity.setHome(BlockPos.ORIGIN);
        }

        optional.ifPresent(pos -> this.entity.setHome(pos.toImmutable()));
    }
}
