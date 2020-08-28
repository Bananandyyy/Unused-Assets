package com.gizmo.unusedassets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LightBlock extends Block {

	public static final IntegerProperty LIGHT = IntegerProperty.create("light", 0, 15);

	    public LightBlock(Properties properties, int deflight) {
	        super(properties);
	        this.setDefaultState(this.stateContainer.getBaseState().with(LIGHT, deflight));
	    }
	    
	    public VoxelShape getOutlineShape(BlockState state, IBlockReader view, BlockPos pos, ISelectionContext context) {
	            return super.getShape(state, view, pos, context);
	    }

		
		public ActionResultType onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
	        if (state.get(LIGHT) + 1 == 16) {
	            world.setBlockState(pos, state.with(LIGHT, 0));
	        } else {
	            world.setBlockState(pos, state.with(LIGHT, state.get(LIGHT) + 1));
	        }
	        return ActionResultType.SUCCESS;
	    }
		

	    public int getLightValue(BlockState state) {
	        return state.get(LIGHT);
	    }
		
		public void fillStateContainer(Builder<Block, BlockState> builder) {
			builder.add(LIGHT);
		}
}
