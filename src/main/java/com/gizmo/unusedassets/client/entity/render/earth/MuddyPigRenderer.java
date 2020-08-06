package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.MuddyPigModel;
import com.gizmo.unusedassets.entity.earth.MuddyPigEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MuddyPigRenderer extends MobRenderer<MuddyPigEntity, MuddyPigModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/muddy_pig.png");
	
	public MuddyPigRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MuddyPigModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(MuddyPigEntity entity) {
		return TEXTURE;
	}
}
