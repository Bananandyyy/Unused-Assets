package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.entity.earth.base.SpiderBase;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpiderRenderBase extends MobRenderer<SpiderBase<? extends SpiderEntity>, SpiderModel<SpiderBase<? extends SpiderEntity>>> {

    private final String registryName;

    public SpiderRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new SpiderModel<>(), 0.8F);
        this.registryName = registryName;
    }

    protected float getDeathMaxRotation(SpiderBase<?> entityLivingBaseIn) {
        return 180.0F;
    }

    @Override
    public ResourceLocation getEntityTexture(SpiderBase<?> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/spider/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/spider/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}
