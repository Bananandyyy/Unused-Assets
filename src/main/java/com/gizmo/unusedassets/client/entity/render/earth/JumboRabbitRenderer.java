package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.JumboRabbitModel;
import com.gizmo.unusedassets.entity.earth.JumboRabbitEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class JumboRabbitRenderer extends MobRenderer<JumboRabbitEntity, JumboRabbitModel<JumboRabbitEntity>> {

    public JumboRabbitRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new JumboRabbitModel<>(), 0.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(JumboRabbitEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/rabbit/jumbo_rabbit/jumbo_rabbit.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/rabbit/jumbo_rabbit/jumbo_rabbit_blink.png");
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }


}