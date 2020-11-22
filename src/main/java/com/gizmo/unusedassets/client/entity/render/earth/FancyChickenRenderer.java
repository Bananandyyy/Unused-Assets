package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.FancyChickenModel;
import com.gizmo.unusedassets.entity.earth.CluckShroomEntity;
import com.gizmo.unusedassets.entity.earth.FancyChickenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FancyChickenRenderer extends MobRenderer<FancyChickenEntity, FancyChickenModel<FancyChickenEntity>>{

	public FancyChickenRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FancyChickenModel<>(), 0.3F);
	}
	
	protected float handleRotationFloat(CluckShroomEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

	@Override
	public ResourceLocation getEntityTexture(FancyChickenEntity entity) {
		ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/chicken/fancy_chicken/fancy_chicken.png");
		ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/chicken/fancy_chicken/fancy_chicken_blink.png");
		 return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
	}

}
