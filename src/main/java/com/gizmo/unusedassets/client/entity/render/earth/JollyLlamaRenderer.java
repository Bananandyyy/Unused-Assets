package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.JollyLlamaModel;
import com.gizmo.unusedassets.entity.earth.JollyLlamaEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JollyLlamaRenderer extends MobRenderer<JollyLlamaEntity, JollyLlamaModel> {

    public JollyLlamaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new JollyLlamaModel(0.0F), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(JollyLlamaEntity entity) {
        String resourceTexture = "unusedassets:textures/entity/earth/llama/jolly_llama/jolly_llama.png";
        String resourceTextureBlink = "unusedassets:textures/entity/earth/llama/jolly_llama/jolly_llama_blink.png";
        ResourceLocation texture = new ResourceLocation(resourceTexture);
        ResourceLocation textureBlink = new ResourceLocation(resourceTextureBlink);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }

}
