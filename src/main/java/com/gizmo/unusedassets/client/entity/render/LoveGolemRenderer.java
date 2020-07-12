package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.client.entity.model.LoveGolemModel;
import com.gizmo.unusedassets.entity.LoveGolemEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LoveGolemRenderer extends MobRenderer<LoveGolemEntity, LoveGolemModel<LoveGolemEntity>>{

	public LoveGolemRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LoveGolemModel<>(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(LoveGolemEntity entity) {
		return entity.getTexture();
	}

}
