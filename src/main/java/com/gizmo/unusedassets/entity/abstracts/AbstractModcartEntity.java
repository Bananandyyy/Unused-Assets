package com.gizmo.unusedassets.entity.abstracts;

import com.gizmo.unusedassets.entity.DispenserMinecartEntity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.world.World;

public abstract class AbstractModcartEntity extends AbstractMinecartEntity {

	protected AbstractModcartEntity(EntityType<?> type, World worldIn) {
		super(type, worldIn);
	}

	public static AbstractModcartEntity create(World worldIn, double x, double y, double z, AbstractModcartEntity.Type typeIn) {
		return new DispenserMinecartEntity(worldIn, x, y, z);

	}

	public abstract AbstractModcartEntity.Type getCartType();

	public static enum Type {
		DISPENSER
	}

}
