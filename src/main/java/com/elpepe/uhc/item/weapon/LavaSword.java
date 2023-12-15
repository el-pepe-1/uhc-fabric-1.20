package com.elpepe.uhc.item.weapon;

import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.util.ServerUtils;
import java.util.List;
import java.util.Random;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public class LavaSword extends class_1829 {
   public LavaSword(class_1832 toolMaterial, int attackDamage, float attackSpeed, class_1792.class_1793 settings) {
      super(toolMaterial, attackDamage, attackSpeed, settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      Random rand = new Random();
      class_1799 stack = user.method_5998(hand);
      class_1799 feetStack = user.method_6118(class_1304.field_6166);
      if (feetStack.method_7909().equals(ModItems.MAGMA_BOOTS) && user.method_5715()) {
         this.fireSphereAbility(world, user);
         stack.method_7956(3, user, (player) -> {
            player.method_20236(hand);
         });
         feetStack.method_7956(2, user, (player) -> {
            player.method_20235(class_1304.field_6166);
         });
         user.method_7357().method_7906(this, 2000);
      } else {
         this.fireShieldAbility(rand, world, user);
         stack.method_7956(1, user, (player) -> {
            player.method_20236(hand);
         });
         user.method_7357().method_7906(this, 50);
      }

      return super.method_7836(world, user, hand);
   }

   private void fireSphereAbility(class_1937 world, class_1657 user) {
      if (!world.method_8608()) {
         LavaSwordProjectileEntity lavaSwordProjectile = new LavaSwordProjectileEntity(world, user);
         lavaSwordProjectile.method_18799(user.method_5720().method_18805(1.15, 1.05, 1.15));
         lavaSwordProjectile.field_6037 = true;
         world.method_8649(lavaSwordProjectile);
         class_3218 serverWorld = (class_3218)world;
         ServerUtils.playSound(serverWorld, class_3417.field_14671, class_3419.field_15250, 15.0, user.method_23317(), user.method_23318(), user.method_23321(), 1.0F, 1.8F);
      }

   }

   private void fireShieldAbility(Random random, class_1937 world, class_1657 user) {
      if (!world.method_8608()) {
         class_243 vec1 = this.getRotationVector(user.method_36455(), user.method_36454() - 90.0F).method_1023(0.0, 1.0, 0.0);
         class_243 vec2 = user.method_5720().method_1021(6.0);
         class_238 box = new class_238(user.method_19538().method_1020(vec1.method_1021(2.5)), user.method_19538().method_1019(vec2.method_1019(vec1.method_1021(2.5))).method_1031(0.0, 3.0, 0.0));
         List<class_1297> entities = world.method_8333(user, box, (entity) -> {
            return entity instanceof class_1309;
         });
         entities.forEach((entity) -> {
            entity.method_20803(80);
            entity.method_5643(user.method_48923().method_48812(user), 2.0F);
            entity.method_18799(entity.method_19538().method_1020(user.method_19538()).method_1029().method_1021(1.1));
         });
         class_3218 serverWorld = (class_3218)world;
         ServerUtils.playSound(serverWorld, class_3417.field_14970, class_3419.field_15250, 15.0, user.method_23317(), user.method_23318(), user.method_23321(), 1.0F, 1.35F);

         for(int i = -8; i < 8; i += 4) {
            for(int j = -50; j < 50; j += 10) {
               class_243 vec = this.getRotationVector(user.method_36455() + (float)i, user.method_36454() + (float)j).method_1021(0.45);
               if (random.nextInt(1, 4) != 3) {
                  ServerUtils.spawnParticle(serverWorld, class_2398.field_11240, user.method_23317(), user.method_23318() + 1.6, user.method_23321(), vec);
               }
            }
         }
      }

   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         tooltip.add(class_2561.method_43470("▶ ").method_27692(class_124.field_1065).method_10852(class_2561.method_43471("tooltip.uhc.lava_sword_ability_1_name")));
         tooltip.add(class_2561.method_43470("      ").method_10852(class_2561.method_43471("tooltip.uhc.lava_sword_ability_1_description")));
         tooltip.add(class_2561.method_43470(""));
         tooltip.add(class_2561.method_43470("▶ ").method_27692(class_124.field_1065).method_10852(class_2561.method_43471("tooltip.uhc.lava_sword_ability_2_name")));
         tooltip.add(class_2561.method_43470("      ").method_10852(class_2561.method_43471("tooltip.uhc.lava_sword_ability_2_description")));
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

      super.method_7851(stack, world, tooltip, context);
   }

   private class_243 getRotationVector(float pitch, float yaw) {
      float f = pitch * 0.017453292F;
      float g = -yaw * 0.017453292F;
      float h = class_3532.method_15362(g);
      float i = class_3532.method_15374(g);
      float j = class_3532.method_15362(f);
      float k = class_3532.method_15374(f);
      return new class_243((double)(i * j), (double)(-k), (double)(h * j));
   }

   public boolean method_7873(class_1799 stack, class_1309 target, class_1309 attacker) {
      target.method_20803(100);
      return super.method_7873(stack, target, attacker);
   }
}
