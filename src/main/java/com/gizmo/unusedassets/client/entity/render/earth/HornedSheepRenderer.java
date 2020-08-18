package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.HornedSheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.HornedSheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.HornedSheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HornedSheepRenderer extends MobRenderer<HornedSheepEntity, HornedSheepModel<HornedSheepEntity>> {

    public HornedSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HornedSheepModel<>(), 0.7F);
        this.addLayer(new HornedSheepWoolLayer(this));
    }

    public ResourceLocation getEntityTexture(HornedSheepEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/sheep/horned_sheep/horned_sheep.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/sheep/horned_sheep/horned_sheep_blink.png");
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}