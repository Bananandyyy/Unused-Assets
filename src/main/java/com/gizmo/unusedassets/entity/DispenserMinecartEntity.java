package com.gizmo.unusedassets.entity;

import com.gizmo.unusedassets.entity.abstracts.AbstractModcartEntity;
import com.gizmo.unusedassets.entity.abstracts.ContainerModcartEntity;
import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.DispenserContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class DispenserMinecartEntity extends ContainerModcartEntity {

	public DispenserMinecartEntity(EntityType<? extends DispenserMinecartEntity> type, World world) {
		super(type, world);
	}

	public DispenserMinecartEntity(World worldIn, double x, double y, double z) {
		super(UnusedEntities.DISPENSER_MINECART, x, y, z, worldIn);
	}

	public void killMinecart(DamageSource source) {
		super.killMinecart(source);
		if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
			this.entityDropItem(Blocks.DISPENSER);
		}

	}
	
	 public BlockState getDefaultDisplayTile() {
	      return Blocks.DISPENSER.getDefaultState().with(DispenserBlock.FACING, Direction.NORTH);
	   }

	@Override
	public int getSizeInventory() {
		return 9;
	}

	@Override
	protected Container createContainer(int id, PlayerInventory playerInventoryIn) {
		return new DispenserContainer(id, playerInventoryIn);
	}

	@Override
	public AbstractModcartEntity.Type getCartType() {
		return AbstractModcartEntity.Type.DISPENSER;
	}

	//TODO: can't use this, but its required for some reason
	@Override
	public AbstractMinecartEntity.Type getMinecartType() {
		// TODO Auto-generated method stub
		return null;
	}

}
