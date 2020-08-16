package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.entity.earth.base.RabbitBase;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.RabbitModel;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RabbitRenderBase extends MobRenderer<RabbitBase<? extends RabbitEntity>, RabbitModel<RabbitBase<? extends RabbitEntity>>> {

    private final String registryName;

    public RabbitRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new RabbitModel<>(), 0.3F);
        this.registryName = registryName;
    }

    @Override
    public ResourceLocation getEntityTexture(RabbitBase<? extends RabbitEntity> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/rabbit/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/rabbit/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }

}
