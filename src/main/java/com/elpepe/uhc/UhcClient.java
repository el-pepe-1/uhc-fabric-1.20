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
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;

public class UhcClient implements ClientModInitializer {
   public void onInitializeClient() {
      ModMessages.registerS2CPackets();
      HudRenderCallback.EVENT.register(new NightVisionHelmetHudOverlay());
      HudRenderCallback.EVENT.register(new FoxGraceHudOverlay());
      HudRenderCallback.EVENT.register(new UhcLivesHudOverlay());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAST_IRON_CAULDRON, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_PLANKS_DOOR, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_PLANKS_TRAPDOOR, RenderLayer.getCutout());
      HandledScreens.register(ModScreenHandlers.CAST_IRON_CAULDRON_SCREEN_HANDLER, CastIronCauldronScreen::new);
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
      ModelPredicateProviderRegistry.register(ModItems.NIGHT_VISION_HELMET, new Identifier("broken"), (stack, world, entity, seed) -> NightVisionHelmetItem.isBroken(stack) ? 1.0F : 0.0F);
      ModelPredicateProviderRegistry.register(ModItems.HARPOON, new Identifier("shooting"), (stack, world, entity, seed) -> stack.getOrCreateNbt().getByte("shooting"));
   }
}
