package com.elpepe.uhc;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.client.FoxGraceHudOverlay;
import com.elpepe.uhc.client.NightVisionHelmetHudOverlay;
import com.elpepe.uhc.client.UhcLivesHudOverlay;
import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.client.GoblinModel;
import com.elpepe.uhc.entity.client.GoblinRenderer;
import com.elpepe.uhc.entity.client.HarpoonProjectileModel;
import com.elpepe.uhc.entity.client.HarpoonProjectileRenderer;
import com.elpepe.uhc.entity.client.LavaSwordProjectileModel;
import com.elpepe.uhc.entity.client.LavaSwordProjectileRenderer;
import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.item.armor.custom.NightVisionHelmetItem;
import com.elpepe.uhc.networking.ModMessages;
import com.elpepe.uhc.particle.LightningParticle;
import com.elpepe.uhc.particle.ModParticles;
import com.elpepe.uhc.screen.CastIronCauldronScreen;
import com.elpepe.uhc.screen.ModScreenHandlers;
import com.elpepe.uhc.villager.custom.MysteriousTraderRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3929;
import net.minecraft.class_5272;

public class UhcClient implements ClientModInitializer {
   public UhcClient() {
   }

   public void onInitializeClient() {
      ModMessages.registerS2CPackets();
      HudRenderCallback.EVENT.register(new NightVisionHelmetHudOverlay());
      HudRenderCallback.EVENT.register(new FoxGraceHudOverlay());
      HudRenderCallback.EVENT.register(new UhcLivesHudOverlay());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAST_IRON_CAULDRON, class_1921.method_23581());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_PLANKS_DOOR, class_1921.method_23581());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_PLANKS_TRAPDOOR, class_1921.method_23581());
      class_3929.method_17542(ModScreenHandlers.CAST_IRON_CAULDRON_SCREEN_HANDLER, CastIronCauldronScreen::new);
      ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTNING_PARTICLE, LightningParticle.Factory::new);
      EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HARPOON_PROJECTILE, HarpoonProjectileModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LAVA_SWORD_PROJECTILE, LavaSwordProjectileModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GOBLIN, GoblinModel::getTexturedModelData);
      EntityRendererRegistry.register(ModEntities.HARPOON_PROJECTILE, HarpoonProjectileRenderer::new);
      EntityRendererRegistry.register(ModEntities.MYSTERIOUS_TRADER, MysteriousTraderRenderer::new);
      EntityRendererRegistry.register(ModEntities.LAVA_SWORD_PROJECTILE, LavaSwordProjectileRenderer::new);
      EntityRendererRegistry.register(ModEntities.GOBLIN_ENTITY, GoblinRenderer::new);
      registerModelsPredicates();
   }

   private static void registerModelsPredicates() {
      class_5272.method_27879(ModItems.NIGHT_VISION_HELMET, new class_2960("broken"), (stack, world, entity, seed) -> {
         return NightVisionHelmetItem.isBroken(stack) ? 1.0F : 0.0F;
      });
      class_5272.method_27879(ModItems.HARPOON, new class_2960("shooting"), (stack, world, entity, seed) -> {
         return (float)stack.method_7948().method_10571("shooting");
      });
   }
}
