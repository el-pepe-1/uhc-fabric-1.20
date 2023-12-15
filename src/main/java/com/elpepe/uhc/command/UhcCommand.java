package com.elpepe.uhc.command;

import com.elpepe.uhc.util.IEntityDataSaver;
import com.elpepe.uhc.util.UhcLivesData;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2186;
import net.minecraft.class_2561;
import net.minecraft.class_3222;

public class UhcCommand {
   public UhcCommand() {
   }

   public static void register(CommandDispatcher<class_2168> dispatcher) {
      dispatcher.register((LiteralArgumentBuilder)class_2170.method_9247("uhc").then(class_2170.method_9247("lives").then(((RequiredArgumentBuilder)class_2170.method_9244("player", class_2186.method_9305()).then(class_2170.method_9247("get").executes((context) -> {
         return getLives((class_2168)context.getSource(), class_2186.method_9315(context, "player"));
      }))).then(class_2170.method_9247("set").then(class_2170.method_9244("lives", IntegerArgumentType.integer(0)).executes((context) -> {
         return setLives((class_2168)context.getSource(), class_2186.method_9315(context, "player"), IntegerArgumentType.getInteger(context, "lives"));
      }))))));
   }

   private static int getLives(class_2168 source, class_3222 target) {
      int lives = UhcLivesData.getLives((IEntityDataSaver)target);
      target.method_43496(class_2561.method_43470(String.valueOf(lives)));
      return lives;
   }

   private static int setLives(class_2168 source, class_3222 target, int lives) {
      return UhcLivesData.setLives(target, lives);
   }
}
