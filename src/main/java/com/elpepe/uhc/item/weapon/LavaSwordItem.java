package com.elpepe.uhc.item.weapon;

import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.util.ServerUtils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class LavaSwordItem extends SwordItem {
    public LavaSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Random rand = new Random();
        ItemStack stack = user.getStackInHand(hand);
        ItemStack feetStack = user.getEquippedStack(EquipmentSlot.FEET);
        if (feetStack.getItem().equals(ModItems.MAGMA_BOOTS) && user.isSneaking()) {
            this.fireSphereAbility(world, user);
            stack.damage(3, user, player -> player.sendToolBreakStatus(hand));
            feetStack.damage(2, user, player -> player.sendEquipmentBreakStatus(EquipmentSlot.FEET));
            user.getItemCooldownManager().set(this, 2000);
        } else {
            this.fireShieldAbility(rand, world, user);
            stack.damage(1, user, player -> player.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this, 50);
        }

        return super.use(world, user, hand);
    }

    private void fireSphereAbility(World world, PlayerEntity user) {
        if (!world.isClient()) {
            LavaSwordProjectileEntity lavaSwordProjectile = new LavaSwordProjectileEntity(world, user);
            lavaSwordProjectile.setVelocity(user.getRotationVector().multiply(1.15, 1.05, 1.15));
            lavaSwordProjectile.velocityModified = true;
            world.spawnEntity(lavaSwordProjectile);
            ServerWorld serverWorld = (ServerWorld) world;
            ServerUtils.playSound(serverWorld, SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.MASTER, 15.0, user.getX(), user.getY(), user.getZ(), 1.0F, 1.8F);
        }

    }

    private void fireShieldAbility(Random random, World world, PlayerEntity user) {
        if (!world.isClient()) {
            Vec3d vec1 = this.getRotationVector(user.getPitch(), user.getYaw() - 90.0F).subtract(0.0, 1.0, 0.0);
            Vec3d vec2 = user.getRotationVector().multiply(6.0);
            Box box = new Box(user.getPos().subtract(vec1.multiply(2.5)), user.getPos().add(vec2.add(vec1.multiply(2.5))).add(0.0, 3.0, 0.0));
            List<Entity> entities = world.getOtherEntities(user, box, entity -> entity instanceof LivingEntity);
            entities.forEach(entity -> {
                entity.setFireTicks(80);
                entity.damage(user.getDamageSources().mobAttack(user), 2.0F);
                entity.setVelocity(entity.getPos().subtract(user.getPos()).normalize().multiply(1.1));
            });
            ServerWorld serverWorld = (ServerWorld) world;
            ServerUtils.playSound(serverWorld, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 15.0, user.getX(), user.getY(), user.getZ(), 1.0F, 1.35F);

            for (int i = -8; i < 8; i += 4) {
                for (int j = -50; j < 50; j += 10) {
                    Vec3d vec = this.getRotationVector(user.getPitch() + (float) i, user.getYaw() + (float) j).multiply(0.45);
                    if (random.nextInt(1, 4) != 3) {
                        ServerUtils.spawnParticle(serverWorld, ParticleTypes.FLAME, user.getX(), user.getY() + 1.6, user.getZ(), vec);
                    }
                }
            }
        }

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("▶ ").formatted(Formatting.GOLD).append(Text.translatable("tooltip.uhc.lava_sword_ability_1_name")));
            tooltip.add(Text.literal("      ").append(Text.translatable("tooltip.uhc.lava_sword_ability_1_description")));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("▶ ").formatted(Formatting.GOLD).append(Text.translatable("tooltip.uhc.lava_sword_ability_2_name")));
            tooltip.add(Text.literal("      ").append(Text.translatable("tooltip.uhc.lava_sword_ability_2_description")));
        } else {
            tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private Vec3d getRotationVector(float pitch, float yaw) {
        float f = pitch * 0.017453292F;
        float g = -yaw * 0.017453292F;
        float h = MathHelper.cos(g);
        float i = MathHelper.sin(g);
        float j = MathHelper.cos(f);
        float k = MathHelper.sin(f);
        return new Vec3d(i * j, -k, h * j);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFireTicks(100);
        return super.postHit(stack, target, attacker);
    }
}
