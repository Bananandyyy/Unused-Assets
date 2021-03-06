package com.gizmo.unusedassets.blocks;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.earth.MelonGolemEntity;
import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CarvedMelonBlock extends HorizontalBlock {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    @Nullable
    private BlockPattern snowmanBasePattern;
    @Nullable
    private BlockPattern snowmanPattern;
    private static final Predicate<BlockState> IS_MELON = (p_210301_0_) -> {
        return p_210301_0_ != null && (p_210301_0_.getBlock() == EarthBlocks.CARVED_MELON || p_210301_0_.getBlock() == EarthBlocks.MELON_LANTERN);
    };

    public CarvedMelonBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (oldState.getBlock() != state.getBlock()) {
            this.trySpawnGolem(worldIn, pos);
        }
    }

    public boolean canDispenserPlace(IWorldReader p_196354_1_, BlockPos p_196354_2_) {
        return this.getSnowmanBasePattern().match(p_196354_1_, p_196354_2_) != null;
    }

    private void trySpawnGolem(World world, BlockPos pos) {
        BlockPattern.PatternHelper blockpattern$patternhelper = this.getSnowmanPattern().match(world, pos);
        if (blockpattern$patternhelper != null) {
            for (int i = 0; i < this.getSnowmanPattern().getThumbLength(); ++i) {
                CachedBlockInfo cachedBlockInfo = blockpattern$patternhelper.translateOffset(0, i, 0);
                world.setBlockState(cachedBlockInfo.getPos(), Blocks.AIR.getDefaultState(), 2);
                world.playEvent(2001, cachedBlockInfo.getPos(), Block.getStateId(cachedBlockInfo.getBlockState()));
            }

            MelonGolemEntity melonGolemEntity = UnusedEntities.MELON_GOLEM.create(world);
            BlockPos blockPos = blockpattern$patternhelper.translateOffset(0, 2, 0).getPos();
            melonGolemEntity.setLocationAndAngles((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.05D, (double) blockPos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(melonGolemEntity);

            for (ServerPlayerEntity serverplayerentity : world.getEntitiesWithinAABB(ServerPlayerEntity.class, melonGolemEntity.getBoundingBox().grow(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity, melonGolemEntity);
            }

            for (int l = 0; l < this.getSnowmanPattern().getThumbLength(); ++l) {
                CachedBlockInfo cachedblockinfo3 = blockpattern$patternhelper.translateOffset(0, l, 0);
                world.func_230547_a_(cachedblockinfo3.getPos(), Blocks.AIR);
            }
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    private BlockPattern getSnowmanBasePattern() {
        if (this.snowmanBasePattern == null) {
            this.snowmanBasePattern = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SNOW_BLOCK))).build();
        }
        return this.snowmanBasePattern;
    }

    private BlockPattern getSnowmanPattern() {
        if (this.snowmanPattern == null) {
            this.snowmanPattern = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', CachedBlockInfo.hasState(IS_MELON)).where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SNOW_BLOCK))).build();
        }
        return this.snowmanPattern;
    }

    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
        return true;
    }
}