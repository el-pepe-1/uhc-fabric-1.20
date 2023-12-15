package com.elpepe.uhc.util;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import com.elpepe.uhc.villager.custom.MysteriousTraderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
   public ModRegistries() {
   }

   public static void registerModStuff() {
      registerEntitiesAttributes();
      registerStrippables();
      registerFlammables();
   }

   private static void registerEntitiesAttributes() {
      FabricDefaultAttributeRegistry.register(ModEntities.GOBLIN_ENTITY, GoblinEntity.createGoblinAttributes());
      FabricDefaultAttributeRegistry.register(ModEntities.MYSTERIOUS_TRADER, MysteriousTraderEntity.createMysteriousTraderAttributes());
      FabricDefaultAttributeRegistry.register(ModEntities.LAVA_SWORD_PROJECTILE, LavaSwordProjectileEntity.createLavaSwordProjectileAttributes());
   }

   private static void registerFlammables() {
      FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_LOG, 5, 5);
      FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_WOOD, 5, 5);
      FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DEAD_LOG, 5, 5);
      FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DEAD_WOOD, 5, 5);
      FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_PLANKS, 5, 20);
   }

   private static void registerStrippables() {
      StrippableBlockRegistry.register(ModBlocks.DEAD_LOG, ModBlocks.STRIPPED_DEAD_LOG);
      StrippableBlockRegistry.register(ModBlocks.DEAD_WOOD, ModBlocks.STRIPPED_DEAD_WOOD);
   }
}
