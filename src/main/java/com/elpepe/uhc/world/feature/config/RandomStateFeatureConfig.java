package com.elpepe.uhc.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.dynamic.Codecs;

public class RandomStateFeatureConfig implements FeatureConfig {
   public static final Codec<RandomStateFeatureConfig> CODEC;
   public final List<RandomStateEntry> blocks;

   public RandomStateFeatureConfig(List<RandomStateEntry> blocks) {
      this.blocks = blocks;
   }

   static {
      CODEC = Codecs.nonEmptyList(RandomStateFeatureConfig.RandomStateEntry.CODEC.listOf()).fieldOf("states").xmap(RandomStateFeatureConfig::new, (config) -> {
         return config.blocks;
      }).codec();
   }

   public static class RandomStateEntry {
      public static final Codec<RandomStateEntry> CODEC = RecordCodecBuilder.create((instance) -> {
         return instance.group(BlockState.CODEC.fieldOf("state").forGetter((config) -> {
            return config.state;
         }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter((config) -> {
            return config.chance;
         })).apply(instance, RandomStateEntry::new);
      });
      public final BlockState state;
      public final float chance;

      public RandomStateEntry(BlockState state, float chance) {
         this.state = state;
         this.chance = chance;
      }
   }
}
