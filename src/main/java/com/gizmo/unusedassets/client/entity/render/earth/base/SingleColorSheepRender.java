package com.gizmo.unusedassets.client.entity.render.earth.base;

import java.text.MessageFormat;

import com.gizmo.unusedassets.client.entity.model.earth.SingleColorSheepModel;
import com.gizmo.unusedassets.client.entity.render.earth.layers.SingleColorSheepWoolLayer;
import com.gizmo.unusedassets.entity.earth.SingleColoredSheepEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SingleColorSheepRender<T extends SingleColoredSheepEntity<T>> extends MobRenderer<T, SingleColorSheepModel<T>> {

    private final String registryName;

    public SingleColorSheepRender(EntityRendererManager renderManagerIn, String registryName) {
        super(renderManagerIn, new SingleColorSheepModel<>(), 0.7F);
        this.registryName = registryName;
        String woolTexture = MessageFormat.format("unusedassets:textures/entity/earth/sheep/{0}/{0}_fur.png", this.registryName, this.registryName);
        this.addLayer(new SingleColorSheepWoolLayer<>(this, woolTexture));
    }

    public ResourceLocation getEntityTexture(T entity) {
        String textureString = MessageFormat.format("unusedassets:textures/entity/earth/sheep/{0}/{0}.png", this.registryName, this.registryName);
        String textureBlinkString = MessageFormat.format("unusedassets:textures/entity/earth/sheep/{0}/{0}_blink.png", this.registryName, this.registryName);
        ResourceLocation texture = new ResourceLocation(textureString);
        ResourceLocation textureBlink = new ResourceLocation(textureBlinkString);
        return entity.getBlinkRemainingTicks() > 0 ? textureBlink : texture;
    }
}