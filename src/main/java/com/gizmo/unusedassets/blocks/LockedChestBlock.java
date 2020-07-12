package com.gizmo.unusedassets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LockedChestBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public LockedChestBlock(Block.Properties properties) {
		super(properties);
		setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return (BlockState) getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate((Direction) state.get(FACING)));
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
	
	@Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}