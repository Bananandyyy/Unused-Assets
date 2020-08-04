package com.gizmo.unusedassets.util.fabric;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.util.SMHeight;

import net.minecraft.client.renderer.texture.SpriteMap;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

public interface FluidBlockRenderer {
	/**
	 * Get the sprites for a fluid being rendered at a given position.
	 * For optimal performance, the sprites should be loaded as part of a
	 * resource reload and *not* looked up every time the method is called.
	 *
	 * @param view The world view pertaining to the fluid. May be null!
	 * @param pos The position of the fluid in the world. May be null!
	 * @param state The current state of the fluid.
	 * @return An array of size two: the first entry contains the "still" sprite,
	 * while the second entry contains the "flowing" sprite.
	 */
	SMHeight[] getFluidSprites(@Nullable IBlockDisplayReader view, @Nullable BlockPos pos, FluidState state);

	/**
	 * Get the tint color for a fluid being rendered at a given position.
	 *
	 * <p>Note: As of right now, our hook cannot handle setting a custom alpha
	 * tint here - as such, it must be contained in the texture itself!
	 *
	 * @param view The world view pertaining to the fluid. May be null!
	 * @param pos The position of the fluid in the world. May be null!
	 * @param state The current state of the fluid.
	 * @return The tint color of the fluid.
	 */
	default int getFluidColor(@Nullable IBlockDisplayReader view, @Nullable BlockPos pos, FluidState state) {
		return -1;
	}
}