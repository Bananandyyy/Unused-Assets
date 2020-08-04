package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.SunsetCowModel;
import com.gizmo.unusedassets.entity.earth.SunsetCowEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SunsetCowRenderer extends MobRenderer<SunsetCowEntity, SunsetCowModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/sunset_cow.png");

	public SunsetCowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SunsetCowModel(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(SunsetCowEntity entity) {
		return TEXTURE;
	}

}
