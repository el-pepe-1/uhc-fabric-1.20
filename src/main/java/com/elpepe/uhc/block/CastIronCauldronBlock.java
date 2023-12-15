package com.elpepe.uhc.block;

import com.elpepe.uhc.block.entity.CastIronCauldronBlockEntity;
import com.elpepe.uhc.block.entity.ModBlockEntities;
import com.elpepe.uhc.item.food.JamFood;
import java.util.HashMap;
import net.minecraft.class_1264;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1756;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2464;
import net.minecraft.class_2470;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2753;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;

public class CastIronCauldronBlock extends class_2237 implements class_2343 {
   private static final class_265 SHAPE = class_2248.method_9541(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
   public static final class_2746 ABOVE_CAMPFIRE = class_2746.method_11825("above_campfire");
   public static final class_2758 WATER_LEVEL = class_2758.method_11867("water_level", 0, 3);
   public static final class_2753 FACING;
   private static final HashMap<class_1792, BlockInteraction<CastIronCauldronBlockEntity>> interactions;
   private static final HashMap<class_1792, class_1792> foodContainers;

   public CastIronCauldronBlock(class_4970.class_2251 settings) {
      super(settings);
   }

   public @Nullable class_2680 method_9605(class_1750 ctx) {
      return (class_2680)((class_2680)super.method_9605(ctx).method_11657(FACING, ctx.method_8042().method_10153())).method_11657(ABOVE_CAMPFIRE, false);
   }

   public class_2680 method_9598(class_2680 state, class_2470 rotation) {
      return (class_2680)state.method_11657(FACING, rotation.method_10503((class_2350)state.method_11654(FACING)));
   }

   public class_2680 method_9569(class_2680 state, class_2415 mirror) {
      return state.method_26186(mirror.method_10345((class_2350)state.method_11654(FACING)));
   }

   protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{ABOVE_CAMPFIRE, WATER_LEVEL, FACING});
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   public class_2464 method_9604(class_2680 state) {
      return class_2464.field_11458;
   }

   public @Nullable class_2586 method_10123(class_2338 pos, class_2680 state) {
      return new CastIronCauldronBlockEntity(pos, state);
   }

   public void method_9536(class_2680 state, class_1937 world, class_2338 pos, class_2680 newState, boolean moved) {
      if (state.method_26204() != newState.method_26204()) {
         class_2586 blockEntity = world.method_8321(pos);
         if (blockEntity instanceof CastIronCauldronBlockEntity) {
            class_1264.method_5451(world, pos, (CastIronCauldronBlockEntity)blockEntity);
            world.method_8455(pos, this);
         }

         super.method_9536(state, world, pos, newState, moved);
      }

   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (!world.method_8608()) {
         CastIronCauldronBlockEntity blockEntity = (CastIronCauldronBlockEntity)world.method_8321(pos);
         if (blockEntity != null) {
            class_1799 stack = player.method_5998(hand);
            if (blockEntity.getOutputItemStack().method_7960()) {
               if (interactions.containsKey(stack.method_7909())) {
                  ((BlockInteraction)interactions.get(stack.method_7909())).interact(world, pos, state, blockEntity, player, hand);
               } else {
                  player.method_17355(blockEntity);
               }
            } else {
               if (!this.playerHasCorrectContainer(stack, blockEntity.getOutputItemStack().method_7909())) {
                  return class_1269.field_5814;
               }

               stack.method_7934(1);
               player.method_7270(blockEntity.getOutputItemStack().method_46651(1));
               blockEntity.decrementOutputSlot();
               world.method_8501(pos, (class_2680)state.method_11657(WATER_LEVEL, (Integer)state.method_11654(WATER_LEVEL) - 1));
            }
         }
      }

      return class_1269.field_5812;
   }

   private boolean playerHasCorrectContainer(class_1799 handStack, class_1792 outputItem) {
      class_1792 resultContainer = class_1802.field_8162;
      if (foodContainers.containsKey(outputItem)) {
         resultContainer = (class_1792)foodContainers.get(outputItem);
      } else if (outputItem instanceof class_1756) {
         resultContainer = class_1802.field_8428;
      } else if (outputItem instanceof JamFood) {
         resultContainer = class_1802.field_8469;
      }

      return handStack.method_31574(resultContainer) || resultContainer == class_1802.field_8162;
   }

   private void getItemStackFromOutputSlot(class_1657 player, CastIronCauldronBlockEntity blockEntity) {
   }

   public <T extends class_2586> @Nullable class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
      return method_31618(type, ModBlockEntities.CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> {
         blockEntity.tick(world1, pos, state1);
      });
   }

   static {
      FACING = class_2741.field_12481;
      interactions = CastIronCauldronInteractions.DEFAULT_INTERACTIONS;
      foodContainers = CastIronCauldronInteractions.DEFAULT_FOOD_CONTAINERS;
   }
}
