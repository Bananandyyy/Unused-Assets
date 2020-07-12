package com.gizmo.unusedassets.entity.tileentity;

import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.inventory.container.ElementContainer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ElementTileEntity extends TileEntity implements INamedContainerProvider {

	public ElementTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}
	
	public ElementTileEntity() {
		this(UnusedTileEntities.ELEMENT_CONSTRUCTOR);
	}

	public Container createMenu(int id, PlayerInventory player, PlayerEntity entity) {
		return new ElementContainer(id, player, this);
	}

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.element_constructor");
	}

}
