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

public class WaxBlock extends Block {

	public WaxBlock(Properties properties) {
		super(properties);
	}
	
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(MinecraftColor.GREEN.getChatColor() + "Block texture added in 19w34a as a mistake and was later removed in 19w42a"));
	}

}
