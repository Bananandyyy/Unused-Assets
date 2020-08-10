package com.gizmo.unusedassets.inventory.container;

import java.util.Objects;

import com.gizmo.unusedassets.entity.tileentity.TableTileEntity;
import com.gizmo.unusedassets.init.UnusedContainers;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class TableContainer extends Container {

	public final TableTileEntity tileEntity;
	private final IWorldPosCallable calling;
	public final CraftingInventory in = new CraftingInventory(this, 9, 1);

	public TableContainer(final int id, final PlayerInventory inventory, final TableTileEntity entity) {
		super(UnusedContainers.LAB_TABLE, id);
		this.tileEntity = entity;
		this.calling = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Input Slots
		int startx = 8;
		int starty = 71;
		int spacing = 18;
		for (int column = 0; column < 9; column++) {
			this.addSlot(new InputSlot(this.in, column, startx + (column * spacing), starty));
		}

		// Player Inventory
		int invx = 8;
		int invy = 115;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(
						new Slot(inventory, 9 + (row * 9) + column, invx + (column * spacing), invy + (row * spacing)));
			}
		}

		// Hotbar
		int barx = 8;
		int bary = 173;
		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(inventory, column, barx + (column * spacing), bary));
		}
	}

	private static TableTileEntity getTile(final PlayerInventory inventory, final PacketBuffer data) {
		Objects.requireNonNull(inventory, "null inventory");
		Objects.requireNonNull(data, "null data");
		final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof TableTileEntity) {
			return (TableTileEntity) tileAtPos;
		}
		throw new IllegalStateException("something went wrong... go check the TableContainer class and troubleshoot");
	}

	public TableContainer(final int window, final PlayerInventory inventory, final PacketBuffer data) {
		this(window, inventory, getTile(inventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(calling, playerIn, EducationBlocks.LAB_TABLE);
	}

	
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		this.calling.consume((p_217068_2_, p_217068_3_) -> {
			this.clearContainer(playerIn, p_217068_2_, this.in);
		});
	}

	static class InputSlot extends Slot {

		public InputSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
		}

	}
}
