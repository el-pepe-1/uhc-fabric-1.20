package com.elpepe.uhc.sound;

import com.elpepe.uhc.Uhc;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;

public class ModSounds {
   public static final class_3414 HEALTH_JAR_CONSUME = registerSoundEvent("health_jar_consume");
   public static final class_3414 AIRTAG_ALARM = registerSoundEvent("airtag_alarm");

   public ModSounds() {
   }

   private static class_3414 registerSoundEvent(String name) {
      class_2960 id = new class_2960("uhc", name);
      return (class_3414)class_2378.method_10230(class_7923.field_41172, id, class_3414.method_47908(id));
   }

   public static void registerSounds() {
      Uhc.LOGGER.info("Registering Sounds for uhc");
   }
}
