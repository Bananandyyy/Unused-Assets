package com.gizmo.unusedassets.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.tileentity.GearTileEntity;
import com.gizmo.unusedassets.state.properties.ModBlockStateProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GearWireBlock extends ContainerBlock {
	
	public static final IntegerProperty GEARPOWER = ModBlockStateProperties.GEARPOWER;
	  
	//public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	  
	public static enum GearStates implements IStringSerializable {
		NONE, GEAR;

		public boolean exists() {
			return this != NONE;
		}

		@Override
		public String func_176610_l() {
			return this.toString().toLowerCase();
		}
	}

	public static enum EnumFaces {

		NORTH(Direction.NORTH, "north", Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D)),
		SOUTH(Direction.SOUTH, "south", Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D)),
		EAST(Direction.EAST, "east", Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)),
		WEST(Direction.WEST, "west", Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D)),
		UP(Direction.UP, "up", Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D)),
		DOWN(Direction.DOWN, "down", Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D));

		public final Direction direction;
		public final EnumProperty<GearStates> face;
		public final VoxelShape shape;

		EnumFaces(Direction direction, String face, VoxelShape shape) {
			this.direction = direction;
			this.face = EnumProperty.create(face + "_gear", GearStates.class);
			this.shape = shape;
		}

		public static EnumFaces get(Direction direction) {
			for (EnumFaces enumFace : EnumFaces.values())
				if (direction == enumFace.direction)
					return enumFace;
			return null;
		}
	}

	public GearWireBlock(Properties properties) {
		super(properties);

		BlockState defaultState = this.getDefaultState();
		for (EnumFaces enumFace : EnumFaces.values())
			defaultState = defaultState.with(enumFace.face, GearStates.NONE);
		this.setDefaultState(defaultState);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		for (EnumFaces enumFace : EnumFaces.values())
			if (state.get(enumFace.face).exists() && !isSolid(worldIn, pos, enumFace.direction.getOpposite()))
				return false;

		return true;
	}

	public static boolean isSolid(IWorldReader world, BlockPos pos, Direction direction) {
		BlockPos offsetPos = pos.offset(direction.getOpposite());
		return world.getBlockState(offsetPos).isSolidSide(world, offsetPos, direction);
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, 0);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {

		for (EnumFaces enumFace : EnumFaces.values()) {
			BlockState updatedState = worldIn.getBlockState(pos);
			if (updatedState.getBlock() != this)
				return;
			if (updatedState.get(enumFace.face).exists() && !isSolid(worldIn, pos, enumFace.direction.getOpposite())) {
				spawnDrops(this.getDefaultState().with(enumFace.face, GearStates.GEAR), worldIn, pos);
				worldIn.setBlockState(pos, removeGear(updatedState, enumFace));
			}
		}

	}

	public BlockState removeGear(BlockState state, EnumFaces enumFaceIn) {
		state = state.with(enumFaceIn.face, GearStates.NONE);
		boolean hasAFace = false;
		for (EnumFaces enumFace : EnumFaces.values())
			if (state.get(enumFace.face).exists())
				hasAFace = true;

		return hasAFace ? state : Blocks.AIR.getDefaultState();
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState oldState = context.getWorld().getBlockState(context.getPos());
		if (oldState.getBlock() == this)
			return oldState.with(EnumFaces.get(context.getFace().getOpposite()).face, GearStates.GEAR);
		else if (this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()))
			return this.getDefaultState().with(EnumFaces.get(context.getFace().getOpposite()).face, GearStates.GEAR);
		else
			return null;
	}

	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		if (useContext.getItem().getItem() == this.asItem()
				&& !state.get(EnumFaces.get(useContext.getFace().getOpposite()).face).exists())
			if (useContext.replacingClickedOnBlock())
				return true;
			else
				return true;
		else
			return false;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		VoxelShape shape = VoxelShapes.empty();

		for (EnumFaces enumFace : EnumFaces.values())
			if (state.get(enumFace.face).exists())
				shape = VoxelShapes.or(shape, enumFace.shape);

		return shape;
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return true;
	}

	@Override
	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		for (EnumFaces enumFace : EnumFaces.values())
			builder.add(enumFace.face);
		builder.add(GEARPOWER);

	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new GearTileEntity();
	}
}