package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.HornedSheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.HornedSheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.HornedSheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HornedSheepRenderer extends MobRenderer<HornedSheepEntity, HornedSheepModel<HornedSheepEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/horned_sheep.png");
	
	public HornedSheepRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HornedSheepModel<>(), 0.7F);
		this.addLayer(new HornedSheepWoolLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(HornedSheepEntity entity) {
		return TEXTURE;
	}
}