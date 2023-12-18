package com.elpepe.uhc.mixin;

import com.elpepe.uhc.client.UhcClientData;
import com.elpepe.uhc.effect.ModEffects;
import com.elpepe.uhc.networking.ModMessages;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Unique private int jumpStrength;
    @Unique private boolean jumpDelta;

    @Inject(method = "tick", at = {@At("HEAD")})
    public void tick(CallbackInfo ci) {
        ClientPlayerEntity clientPlayerEntity = (ClientPlayerEntity) (Object) this;
        if (clientPlayerEntity.hasStatusEffect(ModEffects.FOX_GRACE_EFFECT)) {
            if (clientPlayerEntity.input.jumping && !this.jumpDelta) {
                this.jumpDelta = true;
            } else if (!clientPlayerEntity.input.jumping && this.jumpDelta) {
                if (this.jumpStrength > 20) {
                    float velocity = Math.min((float) this.jumpStrength, 130.0F) / 20.0F * 0.3F;
                    PacketByteBuf buf = PacketByteBufs.create();
                    buf.writeFloat(velocity);
                    ClientPlayNetworking.send(ModMessages.FOX_GRACE_JUMP_ID, buf);
                }

                this.jumpDelta = false;
                this.setJumpStrength(0);
            } else if (clientPlayerEntity.input.jumping && this.jumpStrength < 80) {
                this.setJumpStrength(this.jumpStrength + 1);
            }
        }

    }

    @Unique
    private void setJumpStrength(int jumpStrength) {
        this.jumpStrength = jumpStrength;
        UhcClientData.jumpStrength = jumpStrength;
    }
}
