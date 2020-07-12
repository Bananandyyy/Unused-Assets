package com.gizmo.unusedassets.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ResultInventory implements IInventory {

	private final NonNullList<ItemStack> stackResult = NonNullList.withSize(1, ItemStack.EMPTY);

	@Override
	public void clear() {
		this.stackResult.clear();
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stackResult) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.stackResult.get(0);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndRemove(this.stackResult, 0);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		 return ItemStackHelper.getAndRemove(this.stackResult, 0);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		 this.stackResult.set(0, stack);
	}

	@Override
	public void markDirty() {

	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		return true;
	}

}
