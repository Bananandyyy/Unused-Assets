package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.gizmo.unusedassets.UnusedAssets;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(
            at = @At("HEAD"),
            method = "getPushReaction",
            remap = false,
            cancellable = true
    )
    private void getPushReaction(CallbackInfoReturnable<PushReaction> info) {
        Entity entity = (Entity) (Object) this;

        if (UnusedAssets.ENTITY_PISTON_BEHAVIOR_NORMAL.func_230235_a_(entity.getType())) {
            info.setReturnValue(PushReaction.NORMAL);
        }
        if (UnusedAssets.PISTON_BEHAVIOR_IGNORE.func_230235_a_(entity.getType())) {
            info.setReturnValue(PushReaction.IGNORE);
        }
    }
}