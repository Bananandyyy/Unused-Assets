package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.entity.earth.base.CowBase;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CowRenderBase extends MobRenderer<CowBase<? extends CowEntity>, CowModel<CowBase<? extends CowEntity>>> {

    private final String registryName;

    public CowRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new CowModel<>(), 0.7F);
        this.registryName = registryName;
    }

    @Override
    public ResourceLocation getEntityTexture(CowBase<? extends CowEntity> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/cow/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/cow/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}
