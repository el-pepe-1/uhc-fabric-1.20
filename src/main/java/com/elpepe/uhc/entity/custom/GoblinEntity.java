package com.elpepe.uhc.entity.custom;

import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.goal.EntityWithHome;
import com.elpepe.uhc.entity.goal.FindHomeGoal;
import com.elpepe.uhc.entity.goal.SleepGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GoblinEntity extends HostileEntity implements EntityWithHome {
    private BlockPos home;

    public GoblinEntity(EntityType<? extends GoblinEntity> entityType, World world) {
        super(entityType, world);
        this.home = BlockPos.ORIGIN;
    }

    public GoblinEntity(World world) {
        super(ModEntities.GOBLIN_ENTITY, world);
        this.home = BlockPos.ORIGIN;
    }

    public static DefaultAttributeContainer.Builder createGoblinAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(5, new SleepGoal<>(this, 0.5F));
        this.goalSelector.add(4, new FindHomeGoal<>(this, 32, 40));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.5));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        super.initGoals();
    }

    @Override
    public BlockPos getHome() {
        return this.home;
    }

    @Override
    public void setHome(BlockPos home) {
        this.home = home;
    }
}
