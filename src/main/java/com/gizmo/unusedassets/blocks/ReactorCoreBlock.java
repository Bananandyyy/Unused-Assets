package com.gizmo.unusedassets.blocks;

import com.gizmo.unusedassets.state.properties.ModBlockStateProperties;
import com.gizmo.unusedassets.state.properties.Reactor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;

public class ReactorCoreBlock extends Block {
	public static final EnumProperty<Reactor> STATE = ModBlockStateProperties.STATE;

	public ReactorCoreBlock(Block.Properties properties) {
		super(properties);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STATE);
	}
}
