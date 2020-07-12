package com.gizmo.unusedassets.inventory.container;

import java.util.Objects;

import com.gizmo.unusedassets.entity.tileentity.CompoundTileEntity;
import com.gizmo.unusedassets.init.UnusedContainers;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class CompoundContainer extends Container {

	public final CompoundTileEntity tileEntity;
	private final IWorldPosCallable calling;
	private final CraftingInventory craftMatrix = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory craftResult = new CraftResultInventory();

	public CompoundContainer(final int id, final PlayerInventory inventory, final CompoundTileEntity entity) {
		super(UnusedContainers.COMPOUND_CREATOR, id);
		this.tileEntity = entity;
		this.calling = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		this.addSlot(new ResultSlot(inventory.player, this.craftResult, 0, 134, 46));
		
		// Container Itself
		int startx = 49;
		int starty = 28;
		int spacing = 18;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				this.addSlot(new Slot(this.craftMatrix, (row * 3) + column, startx + (column * spacing), starty + (row * spacing)));
			}
		}

		// Player Inventory
		int invx = 8;
		int invy = 96;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(inventory, 9 + (row * 9) + column, invx + (column * spacing), invy + (row * spacing)));
			}
		}

		// Hotbar
		int barx = 8;
		int bary = 154;
		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(inventory, column, barx + (column * spacing), bary));
		}
	}

	private static CompoundTileEntity getTile(final PlayerInventory inventory, final PacketBuffer data) {
		Objects.requireNonNull(inventory, "Hey, hey, hey, quit it. You can't have a null inventory! Check yourself fool!");
		Objects.requireNonNull(data, "Hey, hey, hey, quit it. You can't have null data! Check yourself fool!");
		final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof CompoundTileEntity) {
			return (CompoundTileEntity) tileAtPos;
		}
		throw new IllegalStateException("Well, you really fucked up this time. This error is coming from the CompoundContainer class if you want to troubleshoot it, but I doubt you will, dumbass.");
	}

	public CompoundContainer(final int window, final PlayerInventory inventory, final PacketBuffer data) {
		this(window, inventory, getTile(inventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(calling, playerIn, EducationBlocks.COMPOUND_CREATOR);
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
	         this.clearContainer(playerIn, p_217068_2_, this.craftMatrix);
	      });
	   }
	
	public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
	      return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
	   }
	
	 public int getOutputSlot() {
	      return 0;
	   }
	
}
