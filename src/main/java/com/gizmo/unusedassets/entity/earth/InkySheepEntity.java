package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class InkySheepEntity extends SingleColoredSheepEntity{

	public InkySheepEntity(EntityType<? extends InkySheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return UnusedEntities.INKY_SHEEP.create(this.world);
	}

}
