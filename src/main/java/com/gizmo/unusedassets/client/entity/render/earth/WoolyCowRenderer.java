package com.gizmo.unusedassets.client.entity.render.earth;

import java.util.Map;

import com.gizmo.unusedassets.client.entity.model.earth.WoolyCowModel;
import com.gizmo.unusedassets.entity.earth.WoolyCowEntity;
import com.google.common.collect.Maps;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

public class WoolyCowRenderer extends MobRenderer<WoolyCowEntity, WoolyCowModel<WoolyCowEntity>> {

	private static final Map<WoolyCowEntity.Type, ResourceLocation> types = Util.make(Maps.newHashMap(), (p_217773_0_) -> {
	      p_217773_0_.put(WoolyCowEntity.Type.SHEARED, new ResourceLocation("unusedassets", "textures/entity/earth/wooly_cow_sheared.png"));
	      p_217773_0_.put(WoolyCowEntity.Type.NORMAL, new ResourceLocation("unusedassets", "textures/entity/earth/wooly_cow.png"));
	   });

	public WoolyCowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WoolyCowModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(WoolyCowEntity entity) {
		return types.get(entity.getCowSheared());
	}

}
