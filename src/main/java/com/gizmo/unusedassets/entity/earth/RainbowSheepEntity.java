package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RainbowSheepEntity extends SingleColoredSheepEntity<RainbowSheepEntity> {
    public RainbowSheepEntity(EntityType<RainbowSheepEntity> type, World world) {
        super(type, world, new ItemStack(EarthBlocks.RAINBOW_WOOL));
    }

	@Override
	public AgeableEntity func_241840_a(ServerWorld worldIn, AgeableEntity ageable) {
		return UnusedEntities.RAINBOW_SHEEP.create(worldIn);
	}
}
