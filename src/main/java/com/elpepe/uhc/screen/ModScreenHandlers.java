package com.elpepe.uhc.screen;

import com.elpepe.uhc.Uhc;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.registry.Registries;

public class ModScreenHandlers {
   public static final ScreenHandlerType<CastIronCauldronScreenHandler> CAST_IRON_CAULDRON_SCREEN_HANDLER;

   public static void registerScreenHandlers() {
      Uhc.LOGGER.info("Registering Screen Handlers for " + Uhc.MOD_ID);
   }

   static {
      CAST_IRON_CAULDRON_SCREEN_HANDLER = (ScreenHandlerType)Registry.register(Registries.SCREEN_HANDLER, new Identifier(Uhc.MOD_ID, "cast_iron_cauldron"), new ExtendedScreenHandlerType(CastIronCauldronScreenHandler::new));
   }
}
