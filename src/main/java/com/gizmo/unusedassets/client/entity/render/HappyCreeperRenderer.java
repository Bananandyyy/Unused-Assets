package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.client.entity.model.HappyCreeperModel;
import com.gizmo.unusedassets.entity.HappyCreeperEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HappyCreeperRenderer extends MobRenderer<HappyCreeperEntity, HappyCreeperModel<HappyCreeperEntity>>{

	public HappyCreeperRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HappyCreeperModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(HappyCreeperEntity entity) {
		return entity.getTexture();
	}

}
