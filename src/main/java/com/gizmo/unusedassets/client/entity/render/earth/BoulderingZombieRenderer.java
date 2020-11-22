package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.BoulderingZombieModel;
import com.gizmo.unusedassets.entity.earth.BoulderingZombieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BoulderingZombieRenderer extends MobRenderer<BoulderingZombieEntity, BoulderingZombieModel<BoulderingZombieEntity>>{

	public BoulderingZombieRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BoulderingZombieModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(BoulderingZombieEntity entity) {
		ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/zombie/bouldering_zombie/bouldering_zombie.png");
		 return texture;
	}

}
