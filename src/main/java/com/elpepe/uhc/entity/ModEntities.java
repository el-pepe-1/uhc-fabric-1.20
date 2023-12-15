package com.elpepe.uhc.entity;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import com.elpepe.uhc.villager.custom.MysteriousTraderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_7923;

public class ModEntities {
   public static final class_1299<HarpoonProjectileEntity> HARPOON_PROJECTILE;
   public static final class_1299<MysteriousTraderEntity> MYSTERIOUS_TRADER;
   public static final class_1299<LavaSwordProjectileEntity> LAVA_SWORD_PROJECTILE;
   public static final class_1299<GoblinEntity> GOBLIN_ENTITY;

   public ModEntities() {
   }

   public static void registerModEntities() {
      Uhc.LOGGER.info("Registering Mod Entities for uhc");
   }

   static {
      HARPOON_PROJECTILE = (class_1299)class_2378.method_10230(class_7923.field_41177, new class_2960("uhc", "harpoon_projectile"), FabricEntityTypeBuilder.create(class_1311.field_17715, HarpoonProjectileEntity::new).dimensions(class_4048.method_18385(0.5F, 0.5F)).build());
      MYSTERIOUS_TRADER = (class_1299)class_2378.method_10230(class_7923.field_41177, new class_2960("uhc", "mysterious_trader"), FabricEntityTypeBuilder.create(class_1311.field_17715, MysteriousTraderEntity::new).dimensions(class_4048.method_18385(0.6F, 1.8F)).build());
      LAVA_SWORD_PROJECTILE = (class_1299)class_2378.method_10230(class_7923.field_41177, new class_2960("uhc", "lava_sword_projectile"), FabricEntityTypeBuilder.create(class_1311.field_17715, LavaSwordProjectileEntity::new).dimensions(class_4048.method_18385(0.5F, 0.5F)).build());
      GOBLIN_ENTITY = (class_1299)class_2378.method_10230(class_7923.field_41177, new class_2960("uhc", "goblin"), FabricEntityTypeBuilder.create(class_1311.field_6302, GoblinEntity::new).dimensions(class_4048.method_18385(0.6F, 1.8F)).build());
   }
}
