package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.gizmo.unusedassets.UnusedAssets;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {
	
	@Inject(at = @At("HEAD"), method = "getPushReaction", cancellable = true)
	
	private void getPushReaction(CallbackInfoReturnable<PushReaction> info) {
		BlockState state = (BlockState) (Object) this;

		if (UnusedAssets.PISTON_BEHAVIOR_NORMAL.contains(state.getBlock())) {
			info.setReturnValue(PushReaction.NORMAL);
		}
		if (UnusedAssets.PISTON_BEHAVIOR_DESTROY.contains(state.getBlock())) {
			info.setReturnValue(PushReaction.DESTROY);
		}
		if (UnusedAssets.PISTON_BEHAVIOR_BLOCK.contains(state.getBlock())) {
			info.setReturnValue(PushReaction.BLOCK);
		}
		if (UnusedAssets.PISTON_BEHAVIOR_PUSH_ONLY.contains(state.getBlock())) {
			info.setReturnValue(PushReaction.PUSH_ONLY);
		}
	}
}