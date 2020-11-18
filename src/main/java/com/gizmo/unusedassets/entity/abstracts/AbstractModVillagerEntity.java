package com.gizmo.unusedassets.entity.abstracts;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class AbstractModVillagerEntity extends AgeableEntity {
	public AbstractModVillagerEntity(EntityType<? extends AgeableEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	 protected void registerGoals() {
//		 this.goalSelector.addGoal(0, new AvoidEntityGoal(this, ZombieEntity.class, 6.0D, 1.0D, 1.2D));
	 }
}
