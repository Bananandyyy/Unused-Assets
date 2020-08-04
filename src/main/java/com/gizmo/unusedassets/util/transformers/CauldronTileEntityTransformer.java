package com.gizmo.unusedassets.util.transformers;

import java.util.ArrayList;
import java.util.List;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronTileEntityTransformer {
    private static final List<Entry> transformers = new ArrayList<>();

    public static void addTransformer(Entry entry){
        transformers.add(entry);
    }

    public static void onTick(CauldronTileEntity blockEntity, World world, BlockPos pos){
        for(Entry entry : transformers){
            if(entry.onTick(blockEntity, world, pos)) return;
        }
    }

    public interface Entry {
        /*  Hook for CauldronBlockEntity tick()
        *   return: whether execution should stop
        * */
        default boolean onTick(CauldronTileEntity blockEntity, World world, BlockPos pos){
            return false;
        }
    }
}
