package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.client.entity.model.AgentModel;
import com.gizmo.unusedassets.entity.AgentEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AgentRenderer extends MobRenderer<AgentEntity, AgentModel<AgentEntity>>{

	public AgentRenderer(EntityRendererManager renderManagerIn) {
		 super(renderManagerIn, new AgentModel<>(), 0.0F);
	}

	@Override
	public ResourceLocation getEntityTexture(AgentEntity entity) {
		return entity.getTexture();
	}

}
