package com.gizmo.unusedassets.client.entity.render.earth;

import com.gizmo.unusedassets.client.entity.model.earth.CluckShroomModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.CluckshroomLayer;
import com.gizmo.unusedassets.entity.earth.CluckShroomEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CluckShroomRenderer extends MobRenderer<CluckShroomEntity, CluckShroomModel<CluckShroomEntity>> {

    public CluckShroomRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CluckShroomModel<>(), 0.3F);
        this.addLayer(new CluckshroomLayer<>(this));
    }

    protected float handleRotationFloat(CluckShroomEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    @Override
    public ResourceLocation getEntityTexture(CluckShroomEntity entity) {
        ResourceLocation texture = new ResourceLocation("unusedassets:textures/entity/earth/chicken/cluck_shroom/cluck_shroom.png");
        ResourceLocation textureBlink = new ResourceLocation("unusedassets:textures/entity/earth/chicken/cluck_shroom/cluck_shroom_blink.png");
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}
