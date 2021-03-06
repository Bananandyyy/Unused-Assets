package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.FurnaceGolemModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.FurnaceGolemFlamesLayer;
import com.gizmo.unusedassets.client.entity.render.earth.layers.FurnaceGolemTorchLayer;
import com.gizmo.unusedassets.entity.earth.FurnaceGolemEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FurnaceGolemRenderer extends MobRenderer<FurnaceGolemEntity, FurnaceGolemModel<FurnaceGolemEntity>> {

    public FurnaceGolemRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FurnaceGolemModel<>(), 0.7F);
        this.addLayer(new FurnaceGolemFlamesLayer(this));
        this.addLayer(new FurnaceGolemTorchLayer(this));
    }

    protected void applyRotations(FurnaceGolemEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        if (!((double) entityLiving.limbSwingAmount < 0.01D)) {
            float f = 13.0F;
            float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f2));
        }
    }

    public ResourceLocation getEntityTexture(FurnaceGolemEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/iron_golem/furnace_golem/furnace_golem.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/iron_golem/furnace_golem/furnace_golem_blink.png");
        ResourceLocation textureAngry = new ResourceLocation("unusedassets:textures/entity/earth/iron_golem/furnace_golem/furnace_golem_angry.png");
        return entity.isAngry() ? textureAngry : entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}
