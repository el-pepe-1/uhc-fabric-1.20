package com.elpepe.uhc.entity;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import com.elpepe.uhc.villager.custom.MysteriousTraderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HarpoonProjectileEntity> HARPOON_PROJECTILE = Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "harpoon_projectile"),
            FabricEntityTypeBuilder.<HarpoonProjectileEntity>create(SpawnGroup.MISC, HarpoonProjectileEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());

    public static final EntityType<MysteriousTraderEntity> MYSTERIOUS_TRADER = Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "mysterious_trader"),
            FabricEntityTypeBuilder.<MysteriousTraderEntity>create(SpawnGroup.MISC, MysteriousTraderEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).build());

    public static final EntityType<LavaSwordProjectileEntity> LAVA_SWORD_PROJECTILE = Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "lava_sword_projectile"),
            FabricEntityTypeBuilder.<LavaSwordProjectileEntity>create(SpawnGroup.MISC, LavaSwordProjectileEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());

    public static final EntityType<GoblinEntity> GOBLIN_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "goblin"),
            FabricEntityTypeBuilder.<GoblinEntity>create(SpawnGroup.MONSTER, GoblinEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).build());

    public static void registerModEntities() {
        Uhc.LOGGER.info("Registering Mod Entities for " + Uhc.MOD_ID);
    }
}
