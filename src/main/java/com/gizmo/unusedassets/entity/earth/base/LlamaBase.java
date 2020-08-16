package com.gizmo.unusedassets.entity.earth.base;

import java.util.Random;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class LlamaBase <T extends LlamaEntity> extends LlamaEntity {

    private int lastBlink = 0;
    private int nextBlinkInterval = new Random().nextInt(760) + 60;
    private int remainingTick = 0;
    private int internalBlinkTick = 0;

    public LlamaBase(EntityType<T> type, World worldIn) {
        super(type, worldIn);
        experienceValue = 3;
        setNoAI(false);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return func_234234_eJ_().createMutableAttribute(Attributes.FOLLOW_RANGE, 40.0D);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.remainingTick > 0) {
            --this.remainingTick;
        }
        if (this.internalBlinkTick == (this.lastBlink + this.nextBlinkInterval)) {
            this.lastBlink = this.internalBlinkTick;
            this.nextBlinkInterval = new Random().nextInt(740) + 60;
            this.remainingTick = 4;
        }
        ++this.internalBlinkTick;
    }

    public int getBlinkRemainingTicks() {
        return this.remainingTick;
    }

    public LlamaEntity createChild(ServerWorld worldIn, AgeableEntity entity) {
		return null;
	}

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}