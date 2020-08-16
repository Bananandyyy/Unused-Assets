package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.SkeletonWolfModel;
import com.gizmo.unusedassets.entity.earth.SkeletonWolfEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkeletonWolfRenderer extends MobRenderer<SkeletonWolfEntity, SkeletonWolfModel<SkeletonWolfEntity>> {

    public SkeletonWolfRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SkeletonWolfModel<>(), 0.5F);
    }

    protected float handleRotationFloat(SkeletonWolfEntity livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    public ResourceLocation getEntityTexture(SkeletonWolfEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/wolf/skeleton_wolf/skeleton_wolf.png");
        ResourceLocation textureAngry = new ResourceLocation("unusedassets:textures/entity/earth/wolf/skeleton_wolf/skeleton_wolf_angry.png");
        return entity.isAngry() ? textureAngry : texture;
    }

}
