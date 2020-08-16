package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.entity.earth.base.ChickenBase;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChickenRenderBase extends MobRenderer<ChickenBase<? extends ChickenEntity>, ChickenModel<ChickenBase<? extends ChickenEntity>>> {
    private final String registryName;

    public ChickenRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new ChickenModel<>(), 0.3F);
        this.registryName = registryName;
    }

    protected float handleRotationFloat(ChickenBase<? extends ChickenEntity> livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    public ResourceLocation getEntityTexture(ChickenBase<? extends ChickenEntity> entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/chicken/{0}/{0}.png", this.registryName);
        String resourceTextureBlink = MessageFormat.format("unusedassets:textures/entity/earth/chicken/{0}/{0}_blink.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }


}