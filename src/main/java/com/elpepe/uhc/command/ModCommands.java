package com.elpepe.uhc.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {
   public ModCommands() {
   }

   public static void register() {
      CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
         UhcCommand.register(dispatcher);
      });
   }
}
