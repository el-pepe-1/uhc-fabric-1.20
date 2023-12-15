package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import com.elpepe.uhc.particle.ModParticles;
import com.elpepe.uhc.util.ServerUtils;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Random;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_437;
import net.minecraft.class_5134;
import net.minecraft.class_1322.class_1323;
import org.jetbrains.annotations.Nullable;

public class DeathrunLeggings extends class_1738 implements TickableArmor {
   private final Multimap<class_1320, class_1322> defaultModifiers;

   public DeathrunLeggings(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
      ImmutableMultimap.Builder<class_1320, class_1322> builder = ImmutableMultimap.builder();
      builder.put(class_5134.field_23724, new class_1322("Armor modifier", (double)material.method_48403(type), class_1323.field_6328));
      builder.put(class_5134.field_23725, new class_1322("Armor toughness", (double)material.method_7700(), class_1323.field_6328));
      builder.put(class_5134.field_23719, new class_1322("Armor speed", 0.1, class_1323.field_6328));
      this.defaultModifiers = builder.build();
   }

   public Multimap<class_1320, class_1322> method_7844(class_1304 slot) {
      return slot == this.field_41933.method_48399() ? this.defaultModifiers : super.method_7844(slot);
   }

   public void tick(class_1309 user) {
      if (!user.method_37908().method_8608()) {
         class_3218 world = (class_3218)user.method_37908();
         Random rand = new Random();
         if (rand.nextInt(3) == 2) {
            class_243 pos = user.method_19538();
            double minVelocity = -0.75;
            double maxVelocity = 0.75;
            class_243 vec = new class_243(rand.nextDouble(minVelocity, maxVelocity), rand.nextDouble(minVelocity, maxVelocity), rand.nextDouble(minVelocity, maxVelocity));
            ServerUtils.spawnParticle(world, ModParticles.LIGHTNING_PARTICLE, pos.field_1352 + rand.nextDouble(-1.0, 1.0), pos.field_1351 + rand.nextDouble(-1.0, 1.0) + 1.0, pos.field_1350 + rand.nextDouble(-1.0, 1.0), vec);
         }

         if (rand.nextInt(21) == 20) {
            class_1799 stack = user.method_6118(this.field_41933.method_48399());
            class_2487 nbt = stack.method_7948();
            int runtime = nbt.method_10550("runtime");
            if (runtime >= 60) {
               user.method_5643(user.method_48923().method_48831(), 1.0F);
            }

            if (user.method_5624()) {
               nbt.method_10569("runtime", runtime + 1);
            } else {
               nbt.method_10569("runtime", runtime - 1);
            }
         }
      }

   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         tooltip.add(class_2561.method_43471("tooltip.uhc.deathrun_leggings"));
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

      super.method_7851(stack, world, tooltip, context);
   }
}
