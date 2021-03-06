package com.gizmo.unusedassets.blocks;

import com.gizmo.unusedassets.init.UnusedFluids;
import com.gizmo.unusedassets.init.UnusedItems;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidAttributes;

public class MudFluid extends FlowingFluid {


    @Override
    public Fluid getFlowingFluid() {
        return UnusedFluids.MUD_FLUID_FLOWING;
    }

    @Override
    public Fluid getStillFluid() {
        return UnusedFluids.MUD_FLUID_STILL;
    }

    @Override
    protected boolean canSourcesMultiply() {
        return false;
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        ResourceLocation mudTag = new ResourceLocation("unusedassets", "mud");
        return fluidIn.isIn(FluidTags.getCollection().get(mudTag));
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
        TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn, pos, tileentity);
    }

    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return 1;
    }

    @Override
    public Item getFilledBucket() {
        return UnusedItems.MUD_BUCKET;
    }

    @Override
    protected boolean canDisplace(FluidState fluidStateIn, IBlockReader blockReader, BlockPos pos, Fluid fluidIn, Direction directionIn) {
        ResourceLocation mudTag = new ResourceLocation("unusedassets", "mud");
        return directionIn == Direction.DOWN && !fluidIn.isIn(FluidTags.getCollection().get(mudTag));
    }

    @Override
    public int getTickRate(IWorldReader p_205569_1_) {
        return 20;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState getBlockState(FluidState state) {
        return EarthBlocks.MUD_BLOCK.getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    @Override
    public boolean isSource(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState p_207192_1_) {
        return p_207192_1_.get(LEVEL_1_8);
    }

    private void triggerMixEffects(IWorld worldIn, BlockPos pos) {
        worldIn.playEvent(1501, pos, 0);
    }

    @Override
    protected void flowInto(IWorld worldIn, BlockPos pos, BlockState blockStateIn, Direction direction, FluidState fluidStateIn) {
        ResourceLocation mudTag = new ResourceLocation("unusedassets", "mud");
        if (this.getFluid().isIn(FluidTags.getCollection().get(mudTag))) {
            boolean flag = false;
            for (Direction dir : Direction.values()) {
                if (worldIn.getFluidState(pos.offset(dir)).isTagged(FluidTags.LAVA)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState(), Constants.BlockFlags.NOTIFY_NEIGHBORS | Constants.BlockFlags.BLOCK_UPDATE);
                this.triggerMixEffects(worldIn, pos);
                return;
            }
        }
        super.flowInto(worldIn, pos, blockStateIn, direction, fluidStateIn);
    }

    @Override
    protected FluidAttributes createAttributes() {
        return  FluidAttributes.builder(
                new ResourceLocation("unusedassets", "/fluids/mud_still"),
                new ResourceLocation("unusedassets", "/fluids/mud_flow"))
                .density(1600).viscosity(3400).build(this);
    }

    public static class Flowing extends MudFluid {

        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        public int getLevel(FluidState p_207192_1_) {
            return p_207192_1_.get(LEVEL_1_8);
        }

        public boolean isSource(FluidState state) {
            return false;
        }

    }

    public static class Source extends MudFluid {
        public int getLevel(FluidState p_207192_1_) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
    
}