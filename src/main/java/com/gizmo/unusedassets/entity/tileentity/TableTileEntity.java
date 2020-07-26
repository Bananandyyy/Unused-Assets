package com.gizmo.unusedassets.entity.tileentity;

import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.inventory.container.TableContainer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class TableTileEntity extends TileEntity implements INamedContainerProvider {

	public TableTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public TableTileEntity() {
		this(UnusedTileEntities.LAB_TABLE);
	}

	public Container createMenu(int id, PlayerInventory player, PlayerEntity entity) {
		return new TableContainer(id, player, this);
	}

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.lab_table");
	}

	
}
