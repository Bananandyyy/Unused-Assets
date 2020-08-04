package com.gizmo.unusedassets.util.fabric;

import net.minecraft.fluid.Fluid;

public interface FluidBlockRendererRegistry {
	FluidBlockRendererRegistry INSTANCE = FluidBlockRendererRegistryImpl.INSTANCE;

	/**
	 * Get a {@link FluidRenderHandler} for a given Fluid.
	 * Supports vanilla and Fabric fluids.
	 *
	 * @param fluid The Fluid.
	 * @return The FluidRenderHandler.
	 */
	FluidBlockRenderer get(Fluid fluid);

	/**
	 * Register a {@link FluidRenderHandler} for a given Fluid.
	 *
	 * @param fluid The Fluid.
	 * @param renderer The FluidRenderHandler.
	 */
	void register(Fluid fluid, FluidBlockRenderer renderer);
}
