package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.entity.earth.base.CatBase;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CatModel;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;

public class CatRenderBase extends MobRenderer<CatBase<? extends CatEntity>, CatModel<CatBase<? extends CatEntity>>> {
    private final String registryName;

    public CatRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new CatModel<>(0.3F), 0.3F);
        this.registryName = registryName;
    }

    public ResourceLocation getEntityTexture(CatBase<? extends CatEntity> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/cat/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/cat/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }


}
