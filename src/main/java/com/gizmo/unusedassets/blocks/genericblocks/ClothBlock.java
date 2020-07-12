package com.gizmo.unusedassets.blocks.genericblocks;

import java.util.List;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.util.MinecraftColor;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

public class ClothBlock extends Block {

	public ClothBlock(Properties properties) {
		super(properties);
	}
	
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(MinecraftColor.GREEN.getChatColor() + "Block added back in the early stages of classic (2009) but were later renamed to wool and got texture changes (Beta 1.2)"));
	}
}
