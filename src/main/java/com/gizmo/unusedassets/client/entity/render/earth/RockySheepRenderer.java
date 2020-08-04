package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.RockySheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.RockySheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.RockySheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RockySheepRenderer extends MobRenderer<RockySheepEntity, RockySheepModel<RockySheepEntity>>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/rocky_sheep.png");
	
	public RockySheepRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RockySheepModel<>(), 0.7F);
		this.addLayer(new RockySheepWoolLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(RockySheepEntity entity) {
		return TEXTURE;
	}
}
