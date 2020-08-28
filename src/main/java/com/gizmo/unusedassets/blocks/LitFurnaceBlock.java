package com.gizmo.unusedassets.blocks;

import java.util.Random;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LitFurnaceBlock extends AbstractFurnaceBlock {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public LitFurnaceBlock(Block.Properties properties) {
		super(properties);
		setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
	}

	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return (TileEntity) new FurnaceTileEntity();
	}

	protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof FurnaceTileEntity) {
			player.openContainer((INamedContainerProvider) tileentity);
			player.addStat(Stats.INTERACT_WITH_FURNACE);
		}
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = pos.getX() + 0.5D;
		double d1 = pos.getY();
		double d2 = pos.getZ() + 0.5D;
		if (rand.nextDouble() < 0.1D)
			worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F,
					false);
		Direction direction = (Direction) stateIn.get(FACING);
		Direction.Axis direction$axis = direction.getAxis();
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d5 = (direction$axis == Direction.Axis.X) ? (direction.getXOffset() * 0.52D) : d4;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;
		double d7 = (direction$axis == Direction.Axis.Z) ? (direction.getZOffset() * 0.52D) : d4;
		worldIn.addParticle((IParticleData) ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
		worldIn.addParticle((IParticleData) ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
	}
}
