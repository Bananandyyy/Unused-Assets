package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.CluckShroomModel;
import com.gizmo.unusedassets.entity.earth.CluckShroomEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CluckShroomRenderer extends MobRenderer<CluckShroomEntity, CluckShroomModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/cluck_shroom.png");
	
	public CluckShroomRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CluckShroomModel(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(CluckShroomEntity entity) {
		return TEXTURE;
	}
}
