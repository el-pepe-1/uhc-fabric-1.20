package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.EffectArmorItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class SlimeBootsItem extends EffectArmorItem {
    public SlimeBootsItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
    }

    public static void onJump(World world, LivingEntity user) {
        world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_SLIME_BLOCK_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F, true);
    }

    public static void slimeParticles(World world, Vec3d pos) {
        Random rand = new Random();
        int particlesCount = rand.nextInt(10, 20);

        for (int i = 0; i < particlesCount; ++i) {
            double d = 1.5;
            Vec3d vec = new Vec3d(rand.nextDouble(-d, d), rand.nextDouble(-d, d), rand.nextDouble(-d, d));
            world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.SLIME_BLOCK.getDefaultState()), pos.x, pos.y, pos.z, vec.x, vec.y, vec.z);
        }
    }
}
