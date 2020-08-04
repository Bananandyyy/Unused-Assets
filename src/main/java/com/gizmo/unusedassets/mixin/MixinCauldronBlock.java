package com.gizmo.unusedassets.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;
import com.gizmo.unusedassets.util.transformers.CauldronBlockTransformer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@Mixin(CauldronBlock.class)
public abstract class MixinCauldronBlock extends Block implements ITileEntityProvider {

	public MixinCauldronBlock(Properties properties) {
        super(properties);
    }

    @Inject(method = "onBlockActivated(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/util/math/BlockRayTraceResult;)Lnet/minecraft/util/ActionResultType;",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"),
            locals = LocalCapture.CAPTURE_FAILHARD,
            cancellable = true)
    public void onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit,
                      CallbackInfoReturnable<ActionResultType> ci, ItemStack itemStack, int i, Item item) {
        TileEntity entity = world.getTileEntity(pos);
        if(entity instanceof CauldronTileEntity){
            ci.setReturnValue(((CauldronTileEntity) entity).onBlockActivated(state, world, pos, player, hand, hit, itemStack));
            return;
        }
        ci.setReturnValue(ActionResultType.PASS);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(!(world.getTileEntity(pos) instanceof CauldronTileEntity))
            return;
        CauldronTileEntity blockEntity = (CauldronTileEntity)world.getTileEntity(pos);
        if(blockEntity.fluid == Fluids.EMPTY)
            return;
        float fluidHeight = pos.getY() + (0.25f) + ((0.7f) * ((float)blockEntity.level_numerator / (float)blockEntity.level_denominator));
        if (!world.isRemote && entity.getPosY() <= (double)fluidHeight) {
            if(CauldronBlockTransformer.onEntityCollision(state, world, pos, entity, blockEntity)) return;
            blockEntity.fluid.getDefaultState().getBlockState().onEntityCollision(world, pos, entity);
            if(blockEntity.fluid == Fluids.WATER && entity.isBurning()){
                entity.extinguish();
            }
        }
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new CauldronTileEntity();
	}

    @OnlyIn(Dist.CLIENT)
    public void randomDisplayTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if(!(world.getTileEntity(pos) instanceof CauldronTileEntity)) return;
        CauldronTileEntity entity = (CauldronTileEntity) world.getTileEntity(pos);
        if(entity.timeLeft > 0){
            float x = pos.getX() + 0.1f + (random.nextFloat() * 0.8f);
            float y = pos.getY() + 1.f + (random.nextFloat() * 0.1f);
            float z = pos.getZ() + 0.1f + (random.nextFloat() * 0.8f);

            world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
        }
    }

    public void rainTick(World world, BlockPos pos) {
        if (world.rand.nextInt(20) == 1) {
            TileEntity blockEntity = world.getTileEntity(pos);
            if(!(blockEntity instanceof CauldronTileEntity)) return;
            CauldronTileEntity cauldronBlockEntity = (CauldronTileEntity)blockEntity;
            float f = world.getBiome(pos).getTemperature(pos);
            if (f >= 0.15F) {
                cauldronBlockEntity.insertBottle(Fluids.WATER, false);
            }
        }
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ((CauldronTileEntity)world.getTileEntity(pos)).level_numerator;
    }
}