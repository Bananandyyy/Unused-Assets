package com.gizmo.unusedassets.items.genericitems;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class AprilFools2020Item extends Item{

	public AprilFools2020Item(Properties properties) {
		super(properties);
	}
	
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Item from the April Fools Update 20w14∞"));
	}

}
