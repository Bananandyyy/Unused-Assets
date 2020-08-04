package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.InkySheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.InkySheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.InkySheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class InkySheepRenderer  extends MobRenderer<InkySheepEntity, InkySheepModel<InkySheepEntity>>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets", "textures/entity/earth/inky_sheep.png");
	
	public InkySheepRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new InkySheepModel<>(), 0.7F);
		this.addLayer(new InkySheepWoolLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(InkySheepEntity entity) {
		return TEXTURE;
	}}
