package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.FleckedSheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.FleckedSheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.FleckedSheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FleckedSheepRenderer extends MobRenderer<FleckedSheepEntity, FleckedSheepModel<FleckedSheepEntity>>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/flecked_sheep.png");
	
	public FleckedSheepRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FleckedSheepModel<>(), 0.7F);
		this.addLayer(new FleckedSheepWoolLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(FleckedSheepEntity entity) {
		return TEXTURE;
	}
}
