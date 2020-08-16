package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.RainbowSheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.RainbowSheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.RainbowSheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RainbowSheepRenderer extends MobRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> {
    public RainbowSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RainbowSheepModel<>(), 0.7F);
        this.addLayer(new RainbowSheepWoolLayer(this));
    }

    @Override
    public ResourceLocation getEntityTexture(RainbowSheepEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/sheep/rainbow_sheep/rainbow_sheep.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/sheep/rainbow_sheep/rainbow_sheep_blink.png");
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}
