package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class RockySheepEntity extends SingleColoredSheepEntity{

	public RockySheepEntity(EntityType<? extends RockySheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return UnusedEntities.ROCKY_SHEEP.create(this.world);
	}

}
