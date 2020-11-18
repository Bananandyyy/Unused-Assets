package com.gizmo.unusedassets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class AntBlock extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public AntBlock(Block.Properties properties) {
		super(properties);
		setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		BlockState blockState = world.getBlockState(pos.down());
		if (blockState.getBlock() == Blocks.WHITE_CONCRETE) {
			this.move(state, world, pos, AntBlock.Clockwiseness.CW);
		} else if (blockState.getBlock() == Blocks.BLACK_CONCRETE) {
			this.move(state, world, pos, AntBlock.Clockwiseness.CCW);
		}

	}

	private void move(BlockState state, ServerWorld world, BlockPos pos, AntBlock.Clockwiseness clockwiseness) {
		Direction direction = state.get(FACING);
		Direction direction2 = clockwiseness == AntBlock.Clockwiseness.CW ? direction.rotateY()
				: direction.rotateYCCW();
		BlockPos blockPos = pos.offset(direction2);
		if (world.isBlockLoaded(blockPos)) {
			switch (clockwiseness) {
			case CW:
				world.setBlockState(pos.down(), Blocks.BLACK_CONCRETE.getDefaultState(), 19);
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(blockPos, (BlockState) state.with(FACING, direction2), 3);
				break;
			case CCW:
				world.setBlockState(pos.down(), Blocks.WHITE_CONCRETE.getDefaultState(), 19);
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(blockPos, (BlockState) state.with(FACING, direction2), 3);
			}
		}

	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState newState, IWorld world, BlockPos pos, BlockPos posFrom) {
		return super.updatePostPlacement(state, direction, newState, world, pos, posFrom);
	}

	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		world.getPendingBlockTicks().scheduleTick(pos, this, 1);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	static enum Clockwiseness {
		CW, CCW;
	}
}