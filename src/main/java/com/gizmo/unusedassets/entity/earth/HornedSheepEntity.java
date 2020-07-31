package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class HornedSheepEntity extends SingleColoredSheepEntity{

	public HornedSheepEntity(EntityType<? extends HornedSheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return UnusedEntities.HORNED_SHEEP.create(this.world);
	}

}
