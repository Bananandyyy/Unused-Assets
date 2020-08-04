package com.gizmo.unusedassets.util.actions;

import java.util.stream.Collectors;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;
import com.gizmo.unusedassets.util.transformers.BucketActionTransformer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CauldronActionBucket implements ICauldronAction{

    public ActionResultType onBlockActivated(CauldronTileEntity entity, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItemMainhand();
        if(itemStack.getItem() instanceof BucketItem){
            BucketItem bucket = (BucketItem) itemStack.getItem();

            Fluid fluid = Fluids.EMPTY;
            for(Fluid checkFluid : Registry.FLUID.stream().collect(Collectors.toSet())){
                if(checkFluid.isSource(checkFluid.getDefaultState()) && checkFluid.getFilledBucket() == bucket){
                    fluid = checkFluid;
                    break;
                }
            }
            fluid = BucketActionTransformer.onBucketEmpty(itemStack, fluid);

            if(bucket == Items.BUCKET){
                if(entity.drain(1, 1, true)){
                    if(!world.isRemote) {
                        if (!player.abilities.isCreativeMode) {
                            itemStack.shrink(1);
                            ItemStack fluidBucket = new ItemStack(entity.fluid.getFilledBucket());
                            fluidBucket = BucketActionTransformer.onBucketFill(fluidBucket, entity.fluid);
                            if (itemStack.isEmpty()) {
                                player.setHeldItem(hand, fluidBucket);
                            } else if (!player.inventory.addItemStackToInventory(fluidBucket)) {
                                player.dropItem(fluidBucket, false);
                            }
                        }
                        player.addStat(Stats.USE_CAULDRON);
                        entity.drain(1, 1, false);
                        world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }
                    entity.markDirty();
                    return ActionResultType.SUCCESS;
                }
            }else if(fluid != Fluids.EMPTY && entity.level_numerator < entity.level_denominator) {
                if (entity.fill(entity.level_denominator - entity.level_numerator, entity.level_denominator, fluid, false)) {
                    if (!world.isRemote) {
                        if (!player.abilities.isCreativeMode) {
                            player.setHeldItem(hand, new ItemStack(Items.BUCKET));
                        }
                        player.addStat(Stats.FILL_CAULDRON);
                        world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }
                    entity.markDirty();
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return ActionResultType.PASS;
    }
}