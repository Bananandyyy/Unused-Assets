package com.gizmo.unusedassets.blocks;

import com.gizmo.unusedassets.init.blocks.BedrockBlocks;

import net.minecraft.block.BarrierBlock;
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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LightBlock extends BarrierBlock {

	public static final IntegerProperty LIGHT = IntegerProperty.create("light", 0, 15);

	    public LightBlock(Properties properties, int deflight) {
	        super(properties);
	        this.setDefaultState(this.stateContainer.getBaseState().with(LIGHT, deflight));
	    }
	    
	    /*public VoxelShape getOutlineShape(BlockState state, IBlockReader view, BlockPos pos, ISelectionContext context) {
	        if (context.hasItem(BedrockBlocks.LIGHT_0.asItem()) || context.hasItem(BedrockBlocks.LIGHT_1.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_2.asItem()) || context.hasItem(BedrockBlocks.LIGHT_3.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_4.asItem()) || context.hasItem(BedrockBlocks.LIGHT_5.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_6.asItem()) || context.hasItem(BedrockBlocks.LIGHT_7.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_8.asItem()) || context.hasItem(BedrockBlocks.LIGHT_9.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_10.asItem()) || context.hasItem(BedrockBlocks.LIGHT_11.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_12.asItem()) || context.hasItem(BedrockBlocks.LIGHT_13.asItem()) ||
	            context.hasItem(BedrockBlocks.LIGHT_14.asItem()) || context.hasItem(BedrockBlocks.LIGHT_15.asItem())) {
	            return super.getShape(state, view, pos, context);
	        } else {
	            return VoxelShapes.empty();
	        }
	    }

		
		public ActionResultType onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
	        if (state.get(LIGHT) + 1 == 16) {
	            world.setBlockState(pos, state.with(LIGHT, 0));
	        } else {
	            world.setBlockState(pos, state.with(LIGHT, state.get(LIGHT) + 1));
	        }
	        return ActionResultType.SUCCESS;
	    }
		
	    public int getLuminance(BlockState state) {
	        return state.get(LIGHT);
	    }
		
		public void fillStateContainer(Builder<Block, BlockState> builder) {
			builder.add(LIGHT);
		}*/
}
