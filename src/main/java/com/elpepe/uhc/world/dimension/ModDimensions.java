package com.elpepe.uhc.world.dimension;

import java.util.OptionalLong;
import net.minecraft.class_1937;
import net.minecraft.class_2874;
import net.minecraft.class_2960;
import net.minecraft.class_3481;
import net.minecraft.class_5321;
import net.minecraft.class_5363;
import net.minecraft.class_6016;
import net.minecraft.class_7134;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class ModDimensions {
   public static final class_5321<class_5363> OVERCHARGE_KEY;
   public static final class_5321<class_1937> OVERCHARGE_LEVEL_KEY;
   public static final class_5321<class_2874> OVERCHARGE_DIMENSION_TYPE;

   public ModDimensions() {
   }

   public static void bootstrapType(class_7891<class_2874> context) {
      context.method_46838(OVERCHARGE_DIMENSION_TYPE, new class_2874(OptionalLong.of(12000L), false, true, false, false, 1.0, false, false, 0, 256, 256, class_3481.field_25588, class_7134.field_37670, 0.1F, new class_2874.class_7512(false, false, class_6016.method_34998(7), 15)));
   }

   static {
      OVERCHARGE_KEY = class_5321.method_29179(class_7924.field_41224, new class_2960("uhc", "overcharge"));
      OVERCHARGE_LEVEL_KEY = class_5321.method_29179(class_7924.field_41223, new class_2960("uhc", "overcharge"));
      OVERCHARGE_DIMENSION_TYPE = class_5321.method_29179(class_7924.field_41241, new class_2960("uhc", "overcharge_type"));
   }
}
