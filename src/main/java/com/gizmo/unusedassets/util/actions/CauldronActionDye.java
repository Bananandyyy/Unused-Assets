package com.gizmo.unusedassets.util.actions;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.DyeItem;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronActionDye implements ICauldronAction{

    public ActionResultType onBlockActivated(CauldronTileEntity entity, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        if(entity.fluid == Fluids.WATER){
            ItemStack heldItemStack = player.getHeldItem(hand);
            Item heldItem = heldItemStack.getItem();

            if(heldItem instanceof DyeItem){
                if(!world.isRemote) {
                    int[] is = new int[3];
                    int i = 0;
                    int j = 1;
                    int o;
                    float r;
                    int n;

                    if (entity.dyed) {
                        o = entity.dyeColor;
                        float f = (float) (o >> 16 & 255) / 255.0F;
                        float g = (float) (o >> 8 & 255) / 255.0F;
                        r = (float) (o & 255) / 255.0F;
                        i = (int) ((float) i + Math.max(f, Math.max(g, r)) * 255.0F);
                        is[0] = (int) ((float) is[0] + f * 255.0F);
                        is[1] = (int) ((float) is[1] + g * 255.0F);
                        is[2] = (int) ((float) is[2] + r * 255.0F);
                        ++j;
                    }

                    DyeItem dyeItem = (DyeItem) heldItem;
                    float[] fs = dyeItem.getDyeColor().getColorComponentValues();
                    int l = (int) (fs[0] * 255.0F);
                    int m = (int) (fs[1] * 255.0F);
                    n = (int) (fs[2] * 255.0F);
                    i += Math.max(l, Math.max(m, n));
                    is[0] += l;
                    is[1] += m;
                    is[2] += n;

                    o = is[0] / j;
                    int p = is[1] / j;
                    int q = is[2] / j;
                    r = (float) i / (float) j;
                    float s = (float) Math.max(o, Math.max(p, q));
                    o = (int) ((float) o * r / s);
                    p = (int) ((float) p * r / s);
                    q = (int) ((float) q * r / s);
                    n = (o << 8) + p;
                    n = (n << 8) + q;
                    entity.dyeColor = n;
                    entity.dyed = true;

                    if (!player.abilities.isCreativeMode) {
                        heldItemStack.shrink(1);
                    }
                }
                return ActionResultType.SUCCESS;
            }
            if(heldItem instanceof DyeableArmorItem && entity.dyed && entity.takeBottle(true)){
                DyeableArmorItem dyeableItem = (DyeableArmorItem)heldItem;
                dyeableItem.setColor(heldItemStack, entity.dyeColor);
                player.addStat(Stats.USE_CAULDRON);
                entity.takeBottle(false);
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}