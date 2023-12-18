package com.elpepe.uhc.villager.custom;

import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.goal.EntityWithHome;
import com.elpepe.uhc.entity.goal.FindHomeGoal;
import com.elpepe.uhc.entity.goal.SleepGoal;
import com.elpepe.uhc.villager.ModTradeOffers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MysteriousTraderEntity extends MerchantEntity implements EntityWithHome {
    private static final String HOME_KEY = "home";
    private BlockPos bed;

    public MysteriousTraderEntity(EntityType<? extends MysteriousTraderEntity> entityType, World world) {
        super(entityType, world);
        this.bed = BlockPos.ORIGIN;
        ((MobNavigation) this.getNavigation()).setCanPathThroughDoors(true);
        this.getNavigation().setCanSwim(true);
    }

    public MysteriousTraderEntity(World world) {
        super(ModEntities.MYSTERIOUS_TRADER, world);
        this.bed = BlockPos.ORIGIN;
        ((MobNavigation) this.getNavigation()).setCanPathThroughDoors(true);
        this.getNavigation().setCanSwim(true);
    }

    public static DefaultAttributeContainer.Builder createMysteriousTraderAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(6, new SleepGoal<>(this, 0.65F));
        this.goalSelector.add(5, new EscapeDangerGoal(this, 0.6499999761581421));
        this.goalSelector.add(5, new FindHomeGoal<>(this, 32, 40));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.5));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(1, new LongDoorInteractGoal(this, true));
        super.initGoals();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put(HOME_KEY, NbtHelper.fromBlockPos(this.getHome()));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setHome(NbtHelper.toBlockPos(nbt.getCompound(HOME_KEY)));
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.hasCustomer() && !this.isBaby()) {
            if (hand == Hand.MAIN_HAND) {
                player.incrementStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.getOffers().isEmpty()) {
                if (!this.getWorld().isClient) {
                    this.setCustomer(player);
                    this.sendOffers(player, this.getDisplayName(), 1);
                }
            }
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        if (offer.shouldRewardPlayerExperience()) {
            int i = 3 + this.random.nextInt(4);
            this.getWorld().spawnEntity(new ExperienceOrbEntity(this.getWorld(), this.getX(), this.getY() + 0.5, this.getZ(), i));
        }

    }

    @Override
    protected void fillRecipes() {
        TradeOffers.Factory[] factories = ModTradeOffers.MYSTERIOUS_TRADER_TRADES.get(1);
        if (factories != null) {
            TradeOfferList tradeOfferList = this.getOffers();
            this.fillRecipesFromPool(tradeOfferList, factories, 3);
        }
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.MYSTERIOUS_TRADER.create(world);
    }

    @Override
    public boolean isPersistent() {
        return true;
    }

    @Override
    public BlockPos getHome() {
        return this.bed;
    }

    @Override
    public void setHome(BlockPos home) {
        this.bed = home;
    }
}
