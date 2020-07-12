package com.gizmo.unusedassets.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class IngredientInventory implements IInventory{

	private final NonNullList<ItemStack> stackList = NonNullList.withSize(1, ItemStack.EMPTY);

	   public int getSizeInventory() {
	      return this.stackList.size();
	   }

	   public boolean isEmpty() {
	      for(ItemStack itemstack : this.stackList) {
	         if (!itemstack.isEmpty()) {
	            return false;
	         }
	      }

	      return true;
	   }

	   public ItemStack getStackInSlot(int index) {
	      return index >= this.getSizeInventory() ? ItemStack.EMPTY : this.stackList.get(index);
	   }

	   public ItemStack removeStackFromSlot(int index) {
	      return ItemStackHelper.getAndRemove(this.stackList, index);
	   }

	   public ItemStack decrStackSize(int index, int count) {
	      ItemStack itemstack = ItemStackHelper.getAndSplit(this.stackList, index, count);

	      return itemstack;
	   }

	   public void setInventorySlotContents(int index, ItemStack stack) {
	      this.stackList.set(index, stack);
	   }

	   public void markDirty() {
	   }

	   public boolean isUsableByPlayer(PlayerEntity player) {
	      return true;
	   }

	   public void clear() {
	      this.stackList.clear();
	   }

}
