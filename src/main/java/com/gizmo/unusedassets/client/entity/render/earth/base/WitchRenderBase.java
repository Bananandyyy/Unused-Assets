package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.client.entity.model.earth.VilerWitchModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.VilerWitchItemLayer;
import com.gizmo.unusedassets.entity.earth.base.WitchBase;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.util.ResourceLocation;

public class WitchRenderBase extends MobRenderer<WitchBase<? extends WitchEntity>, VilerWitchModel<WitchBase<? extends WitchEntity>>> {
    private final String registryName;

    public WitchRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new VilerWitchModel<>(), 0.3F);
        this.addLayer(new VilerWitchItemLayer<>(this));
        this.registryName = registryName;
    }

    public ResourceLocation getEntityTexture(WitchBase<?> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/witch/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/witch/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }


}
