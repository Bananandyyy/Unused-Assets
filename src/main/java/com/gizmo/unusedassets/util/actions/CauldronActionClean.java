package com.gizmo.unusedassets.util.actions;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BannerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronActionClean implements ICauldronAction{

    public ActionResultType onBlockActivated(CauldronTileEntity entity, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        if(entity.fluid != Fluids.WATER || !entity.takeBottle(true) || entity.dyed) return ActionResultType.PASS;
        if(itemStack.getItem() instanceof DyeableArmorItem){
            DyeableArmorItem dyeableItem = (DyeableArmorItem)itemStack.getItem();
            if(dyeableItem.hasColor(itemStack) && !world.isRemote){
                dyeableItem.removeColor(itemStack);
                player.addStat(Stats.CLEAN_ARMOR);
                entity.takeBottle(false);
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            return ActionResultType.SUCCESS;
        }
        if(itemStack.getItem() instanceof BannerItem){
            if(BannerTileEntity.getPatterns(itemStack) > 0 && !world.isRemote){
                ItemStack bannerCopy = itemStack.copy();
                bannerCopy.setCount(1);
                BannerTileEntity.func_230139_a_(bannerCopy);
                player.addStat(Stats.CLEAN_BANNER);
                if(!player.abilities.isCreativeMode){
                    itemStack.shrink(1);
                    entity.takeBottle(false);
                }
                if(itemStack.isEmpty()){
                    player.setHeldItem(hand, bannerCopy);
                }else if(!player.inventory.addItemStackToInventory(bannerCopy)){
                    player.dropItem(bannerCopy, false);
                }
            }
            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResultType.SUCCESS;
        }

        if(itemStack.getItem() instanceof BlockItem){
            Block block = ((BlockItem) itemStack.getItem()).getBlock();
            if(block instanceof ShulkerBoxBlock) {
                if(!world.isRemote) {
                    ItemStack shulkerCopy = new ItemStack(Items.SHULKER_BOX, 1);
                    if (itemStack.hasTag()) {
                        shulkerCopy.setTag(itemStack.getTag().copy());
                    }

                    player.setHeldItem(hand, shulkerCopy);
                    entity.takeBottle(false);
                    player.addStat(Stats.CLEAN_SHULKER_BOX);
                    world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}
