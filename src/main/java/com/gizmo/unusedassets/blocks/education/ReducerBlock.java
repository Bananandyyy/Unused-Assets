package com.gizmo.unusedassets.blocks.education;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;

public class ReducerBlock extends Block{

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	public ReducerBlock(Properties properties) {
		super(properties);
		setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	    return getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	  }
	  
	  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	    builder.add(FACING);
	  }
	  
	  public BlockState rotate(BlockState state, Rotation rot) {
	    return state.with(FACING, rot.rotate((Direction)state.get(FACING)));
	  }

}
