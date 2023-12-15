package com.elpepe.uhc.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.class_2680;
import net.minecraft.class_3037;
import net.minecraft.class_5699;

public class RandomStateFeatureConfig implements class_3037 {
   public static final Codec<RandomStateFeatureConfig> CODEC;
   public final List<RandomStateEntry> blocks;

   public RandomStateFeatureConfig(List<RandomStateEntry> blocks) {
      this.blocks = blocks;
   }

   static {
      CODEC = class_5699.method_36973(RandomStateFeatureConfig.RandomStateEntry.CODEC.listOf()).fieldOf("states").xmap(RandomStateFeatureConfig::new, (config) -> {
         return config.blocks;
      }).codec();
   }

   public static class RandomStateEntry {
      public static final Codec<RandomStateEntry> CODEC = RecordCodecBuilder.create((instance) -> {
         return instance.group(class_2680.field_24734.fieldOf("state").forGetter((config) -> {
            return config.state;
         }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter((config) -> {
            return config.chance;
         })).apply(instance, RandomStateEntry::new);
      });
      public final class_2680 state;
      public final float chance;

      public RandomStateEntry(class_2680 state, float chance) {
         this.state = state;
         this.chance = chance;
      }
   }
}
