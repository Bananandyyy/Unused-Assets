package com.gizmo.unusedassets.client;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UnusedDimensionsRenderInfo extends DimensionRenderInfo{

	public UnusedDimensionsRenderInfo() {
		super(Float.NaN, true, DimensionRenderInfo.FogType.NONE, false, true);
	}

	@Override
	public Vector3d func_230494_a_(Vector3d vector, float sun) {
		return vector;
	}

	@Override
	public boolean func_230493_a_(int x, int y) {
		return false;
	}

}
