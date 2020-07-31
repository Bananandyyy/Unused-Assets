package com.gizmo.unusedassets.entity.earth;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.IForgeShearable;

public class WoolyCowEntity extends CowEntity implements IForgeShearable{

	public WoolyCowEntity(EntityType<? extends WoolyCowEntity> type, World worldIn) {
		super(type, worldIn);
	}

}
