package com.gizmo.unusedassets.entity;

import com.gizmo.unusedassets.entity.abstracts.AbstractModVillagerEntity;
import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class HoodVillagerEntity { //AbstractModVillagerEntity {
	/*	public HoodVillagerEntity(EntityType<HoodVillagerEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public AgeableEntity createChild(AgeableEntity ageable) {
		HoodVillagerEntity villagerentity = new HoodVillagerEntity(UnusedEntities.HOODED_VILLAGER, this.world);
		villagerentity.onInitialSpawn((IWorld) this.world,
				this.world.getDifficultyForLocation(new BlockPos((Entity) villagerentity)), SpawnReason.BREEDING, null,
				null);
		return (AgeableEntity) villagerentity;
	}*/
}