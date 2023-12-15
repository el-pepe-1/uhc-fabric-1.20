package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.armor.custom.SlimeBoots;
import net.minecraft.class_1275;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2165;
import net.minecraft.class_243;
import net.minecraft.class_5568;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1297.class})
public abstract class EntityMixin implements class_1275, class_5568, class_2165 {
   public EntityMixin(class_1299<?> type, class_1937 world) {
   }

   @Inject(
      at = {@At("HEAD")},
      method = {"onLanding"}
   )
   private void onLand(CallbackInfo ci) {
      class_1297 entity = (class_1297)this;
      if (entity.method_5709()) {
         entity.method_5661().forEach((armor) -> {
            if (armor.method_7909() instanceof SlimeBoots && entity.field_6017 > 5.0F && !entity.method_5715()) {
               if (!entity.method_37908().method_8608()) {
                  class_243 vec3d = entity.method_18798();
                  entity.method_18800(vec3d.field_1352, 0.0784000015258789 * (double)entity.field_6017, vec3d.field_1350);
                  entity.field_6037 = true;
               } else {
                  SlimeBoots.onJump(entity.method_37908(), (class_1309)entity);
                  SlimeBoots.slimeParticles(entity.method_37908(), entity.method_19538());
               }
            }

         });
      }

   }
}
