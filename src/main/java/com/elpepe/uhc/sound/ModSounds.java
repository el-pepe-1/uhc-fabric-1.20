package com.elpepe.uhc.sound;

import com.elpepe.uhc.Uhc;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent HEALTH_JAR_CONSUME = registerSoundEvent("health_jar_consume");
    public static final SoundEvent AIRTAG_ALARM = registerSoundEvent("airtag_alarm");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Uhc.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Uhc.LOGGER.info("Registering Sounds for " + Uhc.MOD_ID);
    }
}
