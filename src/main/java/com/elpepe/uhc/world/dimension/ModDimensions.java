package com.elpepe.uhc.world.dimension;

import com.elpepe.uhc.Uhc;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> OVERCHARGE_KEY = RegistryKey.of(RegistryKeys.DIMENSION, new Identifier(Uhc.MOD_ID, "overcharge"));
    public static final RegistryKey<World> OVERCHARGE_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD, new Identifier(Uhc.MOD_ID, "overcharge"));
    public static final RegistryKey<DimensionType> OVERCHARGE_DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(Uhc.MOD_ID, "overcharge_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(OVERCHARGE_DIMENSION_TYPE, new DimensionType(
                OptionalLong.of(12000L),
                false,
                true,
                false,
                false,
                1.0,
                false,
                false,
                0,
                256,
                256,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID,
                0.1F, new DimensionType.MonsterSettings(false, false, ConstantIntProvider.create(7), 15)
                )
        );
    }
}
