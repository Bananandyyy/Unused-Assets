package com.gizmo.unusedassets.entity.earth.base;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class CatBase<T extends CatEntity> extends CatEntity {
	private int lastBlink = 0;
	private int nextBlinkInterval = new Random().nextInt(760) + 60;
	private int remainingTick = 0;
	private int internalBlinkTick = 0;

	public CatBase(EntityType<T> type, World worldIn) {
		super(type, worldIn);
		experienceValue = 3;
		setNoAI(false);
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

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
