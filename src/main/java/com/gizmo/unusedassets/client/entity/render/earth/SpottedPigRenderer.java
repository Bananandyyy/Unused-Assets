package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.SpottedPigModel;
import com.gizmo.unusedassets.entity.earth.SpottedPigEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpottedPigRenderer extends MobRenderer<SpottedPigEntity, SpottedPigModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/spotted_pig.png");
	
	public SpottedPigRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SpottedPigModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(SpottedPigEntity entity) {
		return TEXTURE;
	}
}