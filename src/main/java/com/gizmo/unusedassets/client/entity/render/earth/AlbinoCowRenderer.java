package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.AlbinoCowModel;
import com.gizmo.unusedassets.entity.earth.AlbinoCowEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AlbinoCowRenderer extends MobRenderer<AlbinoCowEntity, AlbinoCowModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/albino_cow.png");
	
	public AlbinoCowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new AlbinoCowModel(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(AlbinoCowEntity entity) {
		return TEXTURE;
	}

	
}
