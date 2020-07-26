package com.gizmo.unusedassets.blocks.education;

import com.gizmo.unusedassets.entity.tileentity.TableTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TableBlock extends ContainerBlock{

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	public TableBlock(Properties properties) {
		super(properties);
		setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new TableTileEntity();
	}
	
	@Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult p_225533_6_) {
		if (!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof TableTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (TableTileEntity) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
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
