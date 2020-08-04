package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class FleckedSheepEntity extends SingleColoredSheepEntity {

	public static Block getWoolColor = Blocks.BROWN_WOOL;

	public FleckedSheepEntity(EntityType<? extends FleckedSheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public FleckedSheepEntity createChild(AgeableEntity ageable) {
		return UnusedEntities.FLECKED_SHEEP.create(this.world);
	}

	
}
