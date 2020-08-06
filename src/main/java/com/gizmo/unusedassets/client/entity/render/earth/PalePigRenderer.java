package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.PalePigModel;
import com.gizmo.unusedassets.entity.earth.PalePigEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PalePigRenderer extends MobRenderer<PalePigEntity, PalePigModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/pale_pig.png");
	
	public PalePigRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PalePigModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(PalePigEntity entity) {
		return TEXTURE;
	}
}
