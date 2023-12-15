package com.elpepe.uhc.block;

import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;

@FunctionalInterface
public interface BlockInteraction<T extends class_2586> {
   void interact(class_1937 var1, class_2338 var2, class_2680 var3, T var4, class_1657 var5, class_1268 var6);
}
