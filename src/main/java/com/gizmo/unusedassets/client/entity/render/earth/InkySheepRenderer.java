package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.SingleColorSheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.SingleColorSheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.SingleColoredSheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class InkySheepRenderer<T extends SingleColoredSheepEntity<T>> extends MobRenderer<T, SingleColorSheepModel<T>> {

	public InkySheepRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SingleColorSheepModel<T>(), 0.5F);
		this.addLayer(new SingleColorSheepWoolLayer<T>(this, "unusedassets:textures/entity/earth/sheep/inky_sheep/inky_sheep_fur.png"));
	}

	@Override
	public ResourceLocation getEntityTexture(T entity) {
		ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/sheep/inky_sheep/inky_sheep.png");
		ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/sheep/inky_sheep/inky_sheep_blink.png");
		 return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
	}

}
