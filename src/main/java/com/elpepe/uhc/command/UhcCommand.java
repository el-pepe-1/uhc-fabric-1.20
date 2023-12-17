package com.elpepe.uhc.command;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.util.IEntityDataSaver;
import com.elpepe.uhc.util.UhcLivesData;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.text.Text;
import net.minecraft.server.network.ServerPlayerEntity;

public class UhcCommand {
   public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
      dispatcher.register(CommandManager.literal(Uhc.MOD_ID)
              .then(CommandManager.literal("lives")
                      .then((CommandManager.argument("player", EntityArgumentType.player())
                              .then(CommandManager.literal("get")
                                      .executes(context -> getLives(context.getSource(), EntityArgumentType.getPlayer(context, "player"))))).then(CommandManager.literal("set").then(CommandManager.argument("lives", IntegerArgumentType.integer(0)).executes((context) -> setLives(context.getSource(), EntityArgumentType.getPlayer(context, "player"), IntegerArgumentType.getInteger(context, "lives"))))))));
   }

   private static int getLives(ServerCommandSource source, ServerPlayerEntity target) {
      int lives = UhcLivesData.getLives((IEntityDataSaver)target);
      target.sendMessage(Text.literal(String.valueOf(lives)));
      return lives;
   }

   private static int setLives(ServerCommandSource source, ServerPlayerEntity target, int lives) {
      return UhcLivesData.setLives(target, lives);
   }
}
