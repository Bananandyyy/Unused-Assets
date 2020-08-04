package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.AshenCowModel;
import com.gizmo.unusedassets.entity.earth.AshenCowEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AshenCowRenderer extends MobRenderer<AshenCowEntity, AshenCowModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/ashen_cow.png");

	public AshenCowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new AshenCowModel(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(AshenCowEntity entity) {
		return TEXTURE;
	}

}
