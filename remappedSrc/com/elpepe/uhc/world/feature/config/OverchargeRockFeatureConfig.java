package com.elpepe.uhc.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_2680;
import net.minecraft.class_3037;

public class OverchargeRockFeatureConfig implements class_3037 {
   public static final Codec<OverchargeRockFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
      return instance.group(Codec.INT.fieldOf("height").forGetter((config) -> {
         return config.height;
      }), RandomStateFeatureConfig.CODEC.fieldOf("blocks").forGetter((config) -> {
         return config.rockBlocks;
      }), class_2680.field_24734.fieldOf("freeze_block").forGetter((config) -> {
         return config.freezeBlock;
      }), class_2680.field_24734.fieldOf("additional_block").forGetter((config) -> {
         return config.additionalBlock;
      })).apply(instance, OverchargeRockFeatureConfig::new);
   });
   public final int height;
   public final RandomStateFeatureConfig rockBlocks;
   public final class_2680 freezeBlock;
   public final class_2680 additionalBlock;

   public OverchargeRockFeatureConfig(int height, RandomStateFeatureConfig blocks, class_2680 freezeBlock, class_2680 additionalBlock) {
      this.height = height;
      this.rockBlocks = blocks;
      this.freezeBlock = freezeBlock;
      this.additionalBlock = additionalBlock;
   }
}
