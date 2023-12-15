package com.elpepe.uhc.block;

import com.elpepe.uhc.item.ModItems;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2470;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import org.jetbrains.annotations.Nullable;

public class RadarBlock extends class_2248 {
   public static final class_2753 FACING;
   public static final class_2746 ACTIVE;
   private static final double SEARCH_DISTANCE = 100.0;

   public RadarBlock(class_4970.class_2251 settings) {
      super(settings);
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      class_1799 stack = player.method_5998(hand);
      if (stack.method_31574(ModItems.RUBY) && !(Boolean)state.method_11654(ACTIVE)) {
         if (world.method_8608()) {
            world.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), class_3417.field_15134, class_3419.field_15245, 1.0F, 1.75F, true);
         } else {
            class_1657 nearest = world.method_8604((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), 100.0, (entity) -> {
               boolean var10000;
               if (!entity.equals(player) && entity instanceof class_1657 playerEntity) {
                  if (!playerEntity.method_7337() && !playerEntity.method_7325()) {
                     var10000 = true;
                     return var10000;
                  }
               }

               var10000 = false;
               return var10000;
            });
            if (nearest != null) {
               world.method_8501(pos, (class_2680)state.method_11657(ACTIVE, true));
               player.method_43496(class_2561.method_43469("block.uhc.radar_block.found_player", new Object[]{100.0}));
            } else {
               player.method_43496(class_2561.method_43469("block.uhc.radar_block.player_not_found", new Object[]{100.0}));
            }

            stack.method_7934(1);
         }
      }

      return class_1269.field_5812;
   }

   public @Nullable class_2680 method_9605(class_1750 ctx) {
      return (class_2680)((class_2680)super.method_9605(ctx).method_11657(FACING, ctx.method_8042().method_10153())).method_11657(ACTIVE, false);
   }

   public class_2680 method_9598(class_2680 state, class_2470 rotation) {
      return (class_2680)state.method_11657(FACING, rotation.method_10503((class_2350)state.method_11654(FACING)));
   }

   public class_2680 method_9569(class_2680 state, class_2415 mirror) {
      return state.method_26186(mirror.method_10345((class_2350)state.method_11654(FACING)));
   }

   protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{FACING, ACTIVE});
   }

   static {
      FACING = class_2741.field_12481;
      ACTIVE = class_2746.method_11825("active");
   }
}
