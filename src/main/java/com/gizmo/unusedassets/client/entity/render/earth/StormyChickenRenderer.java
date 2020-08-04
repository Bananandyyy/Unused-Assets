package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.StormyChickenModel;
import com.gizmo.unusedassets.entity.earth.StormyChickenEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class StormyChickenRenderer extends MobRenderer<StormyChickenEntity, StormyChickenModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/stormy_chicken.png");
	
	public StormyChickenRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new StormyChickenModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(StormyChickenEntity entity) {
		return TEXTURE;
	}
}
