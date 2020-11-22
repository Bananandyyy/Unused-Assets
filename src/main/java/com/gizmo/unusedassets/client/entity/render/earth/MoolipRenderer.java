package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.render.earth.layers.MoolipLayer;
import com.gizmo.unusedassets.entity.earth.MoolipEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoolipRenderer extends MobRenderer<MoolipEntity, CowModel<MoolipEntity>> {

    public MoolipRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CowModel<>(), 0.7F);
        this.addLayer(new MoolipLayer<>(this));
    }

    public ResourceLocation getEntityTexture(MoolipEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/cow/moolip/moolip.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/cow/moolip/moolip_blink.png");
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}