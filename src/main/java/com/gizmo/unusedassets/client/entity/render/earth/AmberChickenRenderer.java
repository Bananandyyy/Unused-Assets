package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.AmberChickenModel;
import com.gizmo.unusedassets.entity.earth.AmberChickenEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AmberChickenRenderer extends MobRenderer<AmberChickenEntity, AmberChickenModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/amber_chicken.png");
	
	public AmberChickenRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new AmberChickenModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(AmberChickenEntity entity) {
		return TEXTURE;
	}

}
