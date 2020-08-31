package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.MelonGolemModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.MelonGolemHeadLayer;
import com.gizmo.unusedassets.entity.earth.MelonGolemEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MelonGolemRenderer extends MobRenderer<MelonGolemEntity, MelonGolemModel<MelonGolemEntity>> {

    public MelonGolemRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MelonGolemModel<>(), 0.5F);
        this.addLayer(new MelonGolemHeadLayer(this));
    }

    public ResourceLocation getEntityTexture(MelonGolemEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/snow_golem/melon_golem/melon_golem.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/snow_golem/melon_golem/melon_golem_blink.png");
        ResourceLocation textureShoot = new ResourceLocation("unusedassets:textures/entity/earth/snow_golem/melon_golem/melon_golem_shoot.png");
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}