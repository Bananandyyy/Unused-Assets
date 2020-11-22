package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.LobberZombieModel;
import com.gizmo.unusedassets.entity.earth.LobberZombieEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LobberZombieRenderer extends MobRenderer<LobberZombieEntity, LobberZombieModel<LobberZombieEntity>>{

	public LobberZombieRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LobberZombieModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(LobberZombieEntity entity) {
		ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/zombie/lobber_zombie/lobber_zombie.png");
		 return texture;
	}

}
