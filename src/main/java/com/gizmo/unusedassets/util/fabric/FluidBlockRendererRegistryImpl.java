package com.gizmo.unusedassets.util.fabric;

import java.util.IdentityHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.util.SMHeight;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.Biomes;

public class FluidBlockRendererRegistryImpl implements FluidBlockRendererRegistry {
	public static final FluidBlockRendererRegistryImpl INSTANCE = new FluidBlockRendererRegistryImpl();
	private final Map<Fluid, FluidBlockRenderer> handlers = new IdentityHashMap<>();
	private final Map<Fluid, FluidBlockRenderer> modHandlers = new IdentityHashMap<>();

	private FluidBlockRendererRegistryImpl() {
	}

	public FluidBlockRenderer get(Fluid fluid) {
		return handlers.get(fluid);
	}

	public FluidBlockRenderer getOverride(Fluid fluid) {
		return modHandlers.get(fluid);
	}

	public void register(Fluid fluid, FluidBlockRenderer renderer) {
		handlers.put(fluid, renderer);
		modHandlers.put(fluid, renderer);
	}

	public void onFluidRendererReload(SMHeight[] waterSprites, SMHeight[] lavaSprites) {
		FluidBlockRenderer waterHandler = new FluidBlockRenderer() {
			public SMHeight[] getFluidSprites(@Nullable IBlockDisplayReader view, @Nullable BlockPos pos, FluidState state) {
				return waterSprites;
			}

			public int getFluidColor(@Nullable IBlockDisplayReader view, @Nullable BlockPos pos, FluidState state) {
				if (view != null && pos != null) {
					return BiomeColors.getWaterColor(view, pos);
				} else {
					return Biomes.DEFAULT.getWaterColor();
				}
			}
		};

		FluidBlockRenderer lavaHandler = new FluidBlockRenderer() {
			public SMHeight[] getFluidSprites(@Nullable IBlockDisplayReader view, @Nullable BlockPos pos, FluidState state) {
				return lavaSprites;
			}
		};

		register(Fluids.WATER, waterHandler);
		register(Fluids.FLOWING_WATER, waterHandler);
		register(Fluids.LAVA, lavaHandler);
		register(Fluids.FLOWING_LAVA, lavaHandler);
		handlers.putAll(modHandlers);
	}
}