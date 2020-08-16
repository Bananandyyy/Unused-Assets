package com.gizmo.unusedassets.client.entity.render.earth.base;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.text.MessageFormat;

@OnlyIn(Dist.CLIENT)
public class WolfRenderBase extends WolfRenderer {
    private final String registryName;

    public WolfRenderBase(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn);
        this.registryName = registryName;
    }

    @Override
    public ResourceLocation getEntityTexture(WolfEntity entity) {
        String resourceTexture = MessageFormat.format("unusedassets:textures/entity/earth/wolf/{0}/{0}.png", this.registryName);
        String resourceTextureAngry = MessageFormat.format("unusedassets:textures/entity/earth/wolf/{0}/{0}_angry.png", this.registryName);
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureAngry = new ResourceLocation(resourceTextureAngry);
        return entity.func_233684_eK_() ? textureAngry : texture;
    }

}
