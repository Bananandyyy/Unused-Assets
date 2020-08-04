package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.MidnightChickenModel;
import com.gizmo.unusedassets.entity.earth.MidnightChickenEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MidnightChickenRenderer extends MobRenderer<MidnightChickenEntity, MidnightChickenModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/midnight_chicken.png");
	
	public MidnightChickenRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MidnightChickenModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(MidnightChickenEntity entity) {
		return TEXTURE;
	}
}
