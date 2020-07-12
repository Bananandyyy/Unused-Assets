package com.gizmo.unusedassets.inventory.container;

import java.util.Objects;

import com.gizmo.unusedassets.entity.tileentity.ReducerTileEntity;
import com.gizmo.unusedassets.init.UnusedContainers;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;
import com.gizmo.unusedassets.inventory.IngredientInventory;
import com.gizmo.unusedassets.inventory.ResultInventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class ReducerContainer extends Container {

	public final ReducerTileEntity tileEntity;
	private final IWorldPosCallable calling;
	public final ResultInventory result = new ResultInventory();
	public final IngredientInventory in = new IngredientInventory();
	

	public ReducerContainer(final int id, final PlayerInventory inventory, final ReducerTileEntity entity) {
		super(UnusedContainers.MATERIAL_REDUCER, id);
		this.tileEntity = entity;
		this.calling = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		this.addSlot(new InputSlot(this.in, 0, 80, 20));
		
		this.addSlot(new ResultSlot(inventory.player, this.result, 1, 28, 55));
		this.addSlot(new ResultSlot(inventory.player, this.result, 2, 41, 80));
		this.addSlot(new ResultSlot(inventory.player, this.result, 3, 54, 55));
		this.addSlot(new ResultSlot(inventory.player, this.result, 4, 67, 80));
		this.addSlot(new ResultSlot(inventory.player, this.result, 5, 80, 55));
		this.addSlot(new ResultSlot(inventory.player, this.result, 6, 93, 80));
		this.addSlot(new ResultSlot(inventory.player, this.result, 7, 106, 55));
		this.addSlot(new ResultSlot(inventory.player, this.result, 8, 119, 80));
		this.addSlot(new ResultSlot(inventory.player, this.result, 9, 132, 55));
		
		
		// Player Inventory
		int invx = 8;
		int invy = 105;
		int spacing = 18;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(
						new Slot(inventory, 9 + (row * 9) + column, invx + (column * spacing), invy + (row * spacing)));
			}
		}

		// Hotbar
		int barx = 8;
		int bary = 163;
		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(inventory, column, barx + (column * spacing), bary));
		}
	}
	
	private static ReducerTileEntity getTile(final PlayerInventory inventory, final PacketBuffer data) {
		Objects.requireNonNull(inventory, "Hey, hey, hey, quit it. You can't have a null inventory! Check yourself fool!");
		Objects.requireNonNull(data, "Hey, hey, hey, quit it. You can't have null data! Check yourself fool!");
		final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof ReducerTileEntity) {
			return (ReducerTileEntity) tileAtPos;
		}
		throw new IllegalStateException("Well, you really fucked up this time. This error is coming from the ReducerContainer class if you want to troubleshoot it, but I doubt you will, dumbass.");
	}

	public ReducerContainer(final int window, final PlayerInventory inventory, final PacketBuffer data) {
		this(window, inventory, getTile(inventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(calling, playerIn, EducationBlocks.MATERIAL_REDUCER);
	}
	
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.inventorySlots.get(index);
	      if (slot != null && slot.getHasStack()) {
	         ItemStack itemstack1 = slot.getStack();
	         itemstack = itemstack1.copy();
	         if (index == 0) {
	            this.calling.consume((p_217067_2_, p_217067_3_) -> {
	               itemstack1.getItem().onCreated(itemstack1, p_217067_2_, playerIn);
	            });
	            if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
	               return ItemStack.EMPTY;
	            }

	            slot.onSlotChange(itemstack1, itemstack);
	         } else if (index >= 10 && index < 46) {
	            if (!this.mergeItemStack(itemstack1, 1, 10, false)) {
	               if (index < 37) {
	                  if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
	                     return ItemStack.EMPTY;
	                  }
	               } else if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
	                  return ItemStack.EMPTY;
	               }
	            }
	         } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
	         } else {
	            slot.onSlotChanged();
	         }

	         if (itemstack1.getCount() == itemstack.getCount()) {
	            return ItemStack.EMPTY;
	         }

	         ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
	         if (index == 0) {
	            playerIn.dropItem(itemstack2, false);
	         }
	      }

	      return itemstack;
	   }

	
	public void onContainerClosed(PlayerEntity playerIn) {
	      super.onContainerClosed(playerIn);
	      this.calling.consume((p_217068_2_, p_217068_3_) -> {
	         this.clearContainer(playerIn, p_217068_2_, this.in);
	      });
	   }
	
	public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
	      return slotIn.inventory != this.result && super.canMergeSlot(stack, slotIn);
	   }
	
	static class InputSlot extends Slot {

		public InputSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
		}
		
	}

}
