package com.gizmo.unusedassets.blocks;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import com.gizmo.unusedassets.util.MinecraftColor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AntBlock extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public AntBlock(Block.Properties properties) {
		super(properties);
		setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
	}

	enum Step {
		CW, CCW;
	}

	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		BlockState blockState = worldIn.getBlockState(pos.down());
		if (blockState.getBlock() == Blocks.WHITE_CONCRETE) {
			move(state, worldIn, pos, Step.CW);
		} else if (blockState.getBlock() == Blocks.BLACK_CONCRETE) {
			move(state, worldIn, pos, Step.CCW);
		}
	}

	private void move(BlockState state, World worldIn, BlockPos pos, Step step) {
		Direction direction1 = state.get(FACING);
		Direction direction2 = (step == Step.CW) ? direction1.rotateY() : direction1.rotateYCCW();
		BlockPos pos1 = pos.offset(direction2);
		if (worldIn.isBlockLoaded(pos1))
			switch (step) {
			case CW:
				worldIn.setBlockState(pos.down(), Blocks.BLACK_CONCRETE.getDefaultState(), 19);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				worldIn.setBlockState(pos1, state.with(FACING, direction2), 3);
				break;
			case CCW:
				worldIn.setBlockState(pos.down(), Blocks.WHITE_CONCRETE.getDefaultState(), 19);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				worldIn.setBlockState(pos1, state.with(FACING, direction2), 3);
				break;
			}
	}

//	  public BlockState updateShape(BlockState state, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos pos1, BlockPos pos2) {
//	    return super.updateShape(state, direction, blockState1, levelAccessor, pos1, pos2);
//	  }

	public void onPlace(BlockState state, World level, BlockPos blockPos, BlockState blockState1, boolean bool) {
		level.getPendingBlockTicks().scheduleTick(blockPos, this, 1);
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate((Direction) state.get(FACING)));
	}

	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(MinecraftColor.GREEN.getChatColor() + "Block from the April Fools Update 20w14∞"));
	}

}
