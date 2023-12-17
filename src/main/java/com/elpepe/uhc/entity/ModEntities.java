package com.elpepe.uhc.entity;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import com.elpepe.uhc.villager.custom.MysteriousTraderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.registry.Registries;

public class ModEntities {
   public static final EntityType<HarpoonProjectileEntity> HARPOON_PROJECTILE;
   public static final EntityType<MysteriousTraderEntity> MYSTERIOUS_TRADER;
   public static final EntityType<LavaSwordProjectileEntity> LAVA_SWORD_PROJECTILE;
   public static final EntityType<GoblinEntity> GOBLIN_ENTITY;

   public static void registerModEntities() {
      Uhc.LOGGER.info("Registering Mod Entities for " + Uhc.MOD_ID);
   }

   static {
      HARPOON_PROJECTILE = (EntityType)Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "harpoon_projectile"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, HarpoonProjectileEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());
      MYSTERIOUS_TRADER = (EntityType)Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "mysterious_trader"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, MysteriousTraderEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).build());
      LAVA_SWORD_PROJECTILE = (EntityType)Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "lava_sword_projectile"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, LavaSwordProjectileEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());
      GOBLIN_ENTITY = (EntityType)Registry.register(Registries.ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "goblin"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GoblinEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).build());
   }
}
