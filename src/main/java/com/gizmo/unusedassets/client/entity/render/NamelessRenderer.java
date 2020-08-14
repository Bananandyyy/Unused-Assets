package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.client.entity.model.NamelessModel;
import com.gizmo.unusedassets.entity.dungeons.NamelessEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NamelessRenderer { //extends MobRenderer<NamelessEntity, NamelessModel> {

/*	public NamelessRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NamelessModel(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(NamelessEntity entity) {
		return entity.getTexture();
	}

*/
}
