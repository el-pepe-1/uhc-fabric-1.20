package com.elpepe.uhc.screen;

import com.elpepe.uhc.Uhc;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3917;
import net.minecraft.class_7923;

public class ModScreenHandlers {
   public static final class_3917<CastIronCauldronScreenHandler> CAST_IRON_CAULDRON_SCREEN_HANDLER;

   public ModScreenHandlers() {
   }

   public static void registerScreenHandlers() {
      Uhc.LOGGER.info("Registering Screen Handlers for uhc");
   }

   static {
      CAST_IRON_CAULDRON_SCREEN_HANDLER = (class_3917)class_2378.method_10230(class_7923.field_41187, new class_2960("uhc", "cast_iron_cauldron"), new ExtendedScreenHandlerType(CastIronCauldronScreenHandler::new));
   }
}
