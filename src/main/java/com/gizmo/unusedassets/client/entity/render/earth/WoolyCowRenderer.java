package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.entity.earth.WoolyCowEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.ResourceLocation;

public class WoolyCowRenderer extends MobRenderer<WoolyCowEntity, CowModel<WoolyCowEntity>> {

    public WoolyCowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CowModel<>(), 0.7F);
    }

    public ResourceLocation getEntityTexture(WoolyCowEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/cow/wooly_cow/wooly_cow.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/cow/wooly_cow/wooly_cow_blink.png");
        ResourceLocation textureSheared = new ResourceLocation("unusedassets:textures/entity/earth/cow/wooly_cow/wooly_cow_sheared.png");
        ResourceLocation textureShearedBlink = new ResourceLocation("unusedassets:textures/entity/earth/cow/wooly_cow/wooly_cow_sheared_blink.png");
        boolean blink = entity.getBlinkRemainingTicks() > 0;
        return entity.getSheared() ?
                blink ?
                        textureShearedBlink : textureSheared
                :
                blink ?
                        textureBlink : texture;
    }
}
