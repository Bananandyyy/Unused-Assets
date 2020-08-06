package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.PiebaldPigModel;
import com.gizmo.unusedassets.entity.earth.PiebaldPigEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PiebaldPigRenderer extends MobRenderer<PiebaldPigEntity, PiebaldPigModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/piebald_pig.png");
	
	public PiebaldPigRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PiebaldPigModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(PiebaldPigEntity entity) {
		return TEXTURE;
	}
}