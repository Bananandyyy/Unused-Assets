package com.gizmo.unusedassets.entity.earth.base;

import java.util.Random;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class SheepBase<T extends SheepEntity> extends SheepEntity {

	private int lastBlink = 0;
	private int nextBlinkInterval = new Random().nextInt(760) + 60;
	private int remainingTick = 0;
	private int internalBlinkTick = 0;

	public SheepBase(EntityType<T> type, World worldIn) {
		super(type, worldIn);
		experienceValue = 3;
		setNoAI(false);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.23F).createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
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

	public SheepEntity createChild(ServerWorld worldIn, AgeableEntity entity) {
		return null;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
