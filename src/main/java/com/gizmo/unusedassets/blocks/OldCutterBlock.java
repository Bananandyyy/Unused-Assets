package com.gizmo.unusedassets.blocks;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.StonecutterContainer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class OldCutterBlock extends Block {
  private static final TranslationTextComponent CONTAINER_NAME = new TranslationTextComponent("container.oldcutter", new Object[0]);
  
  public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
  
  public OldCutterBlock(Block.Properties propertiesIn) {
    super(propertiesIn);
    setDefaultState((this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
  }
  
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
    if (worldIn.isRemote)
      return ActionResultType.SUCCESS; 
    player.openContainer(state.getContainer(worldIn, pos));
    return ActionResultType.SUCCESS;
  }
  
  @Nullable
  public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
    return (INamedContainerProvider)new SimpleNamedContainerProvider((p_220283_2_, p_220283_3_, p_220283_4_) -> new StonecutterContainer(p_220283_2_, p_220283_3_, IWorldPosCallable.of(worldIn, pos)), 
        
        (ITextComponent)CONTAINER_NAME);
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
  
  public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
    return false;
  }
}
