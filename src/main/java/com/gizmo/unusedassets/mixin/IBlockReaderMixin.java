package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.gizmo.unusedassets.client.DynamicLightingManager;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

@Mixin(IBlockReader.class)
public interface IBlockReaderMixin {
	@Overwrite
	default int getLightValue(BlockPos pos)
	{
		if (DynamicLightingManager.SOURCES.containsKey(pos) && DynamicLightingManager.SOURCES.get(pos).shouldStay)
			return 12;
		return this.getBlockState(pos).getLightValue((IBlockReader) (Object) this, pos);
	}

	@Shadow
	BlockState getBlockState(BlockPos pos);
}
