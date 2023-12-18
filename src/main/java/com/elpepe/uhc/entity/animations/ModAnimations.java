package com.elpepe.uhc.entity.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.minecraft.client.render.entity.animation.Transformation.Targets;
import net.minecraft.client.render.entity.animation.Transformation.Interpolations;

public class ModAnimations {
    public static final Animation LAVA_SWORD_PROJECTILE_IDLE = Animation.Builder.create(4.0F).looping()
            .addBoneAnimation("lava_sword_projectile", new Transformation(Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring", new Transformation(Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring", new Transformation(Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 180.0F), Interpolations.LINEAR),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 360.0F), Interpolations.LINEAR),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 540.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 720.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring", new Transformation(Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.100000023841858, 1.100000023841858, 1.0), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createScalingVector(1.100000023841858, 1.100000023841858, 1.0), Interpolations.LINEAR)))
            .addBoneAnimation("ring2", new Transformation(Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring2", new Transformation(Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 15.0F), Interpolations.LINEAR),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 360.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 540.0F, 15.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 720.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring2", new Transformation(Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0, 1.0, 1.0), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createScalingVector(1.0, 1.0, 1.0), Interpolations.LINEAR)))
            .addBoneAnimation("ring3", new Transformation(Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring3", new Transformation(Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 360.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 720.0F), Interpolations.LINEAR)))
            .addBoneAnimation("ring3", new Transformation(Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0, 0.8999999761581421, 0.8999999761581421), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createScalingVector(1.0, 0.8999999761581421, 0.8999999761581421), Interpolations.LINEAR)))
            .addBoneAnimation("heart", new Transformation(Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("heart", new Transformation(Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 14.0F, 0.0F), Interpolations.LINEAR),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 360.0F, 42.5F), Interpolations.LINEAR),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 720.0F, -42.5F), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 360.0F, 0.0F), Interpolations.LINEAR)))
            .addBoneAnimation("heart", new Transformation(Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0, 1.0, 1.0), Interpolations.LINEAR),
                    new Keyframe(2.0F, AnimationHelper.createScalingVector(1.25, 1.25, 1.25), Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createScalingVector(1.0, 1.0, 1.0), Interpolations.LINEAR)))
            .build();
}
