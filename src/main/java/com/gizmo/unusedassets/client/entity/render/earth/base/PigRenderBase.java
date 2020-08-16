package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.client.entity.render.earth.layers.BasePigSaddleLayer;
import com.gizmo.unusedassets.entity.earth.base.PigBase;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PigRenderBase extends MobRenderer<PigBase<? extends PigEntity>, PigModel<PigBase<? extends PigEntity>>> {

    private final String registryName;

    public PigRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new PigModel<>(), 0.7F);
        this.addLayer(new BasePigSaddleLayer(this));
        this.registryName = registryName;
    }

    @Override
    public ResourceLocation getEntityTexture(PigBase<? extends PigEntity> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/pig/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/pig/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }

}
