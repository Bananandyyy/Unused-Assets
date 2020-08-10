package com.gizmo.unusedassets.inventory.container;

import java.util.Objects;

import com.gizmo.unusedassets.entity.tileentity.ElementTileEntity;
import com.gizmo.unusedassets.init.UnusedContainers;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class ElementContainer extends Container {

	public final ElementTileEntity tileEntity;
	private final IWorldPosCallable calling;
	private final Slot output;
	 
	private final IInventory outSlot = new Inventory(1); 
	
	public ElementContainer(final int id, final PlayerInventory inventory, final ElementTileEntity entity) {
		super(UnusedContainers.ELEMENT_CONSTRUCTOR, id);
		this.tileEntity = entity;
		this.calling = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		
		this.output = this.addSlot(new Slot(this.outSlot, 0, 211, 90));
		
		int invX = 84;
		int invY = 140;
		int nextSlot = 18;
		
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; column ++) {
				this.addSlot(new Slot(inventory, 9 + (row * 9) + column, invX + (column * nextSlot), invY + (row * nextSlot)));
			}
		}
		
		int hotbarY = 198;
		
		for (int column = 0; column < 9; column ++) {
			this.addSlot(new Slot(inventory, column, invX + (column * nextSlot), hotbarY));
		}
	}
	
	private static ElementTileEntity getTile(final PlayerInventory inventory, final PacketBuffer data) {
		Objects.requireNonNull(inventory, "null inventory");
		Objects.requireNonNull(data, "null data");
		final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof ElementTileEntity) {
			return (ElementTileEntity)tileAtPos;
		}
		throw new IllegalStateException("something went wrong... go check the ElementContainer class and troubleshoot");
	}
	
	public ElementContainer(final int window, final PlayerInventory inventory, final PacketBuffer data) {
		this(window, inventory, getTile(inventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(calling, playerIn, EducationBlocks.ELEMENT_CONSTRUCTOR);
	}
	
}
