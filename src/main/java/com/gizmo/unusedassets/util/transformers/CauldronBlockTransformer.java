package com.gizmo.unusedassets.util.transformers;

import java.util.ArrayList;
import java.util.List;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronBlockTransformer {
    private static final List<Entry> transformers = new ArrayList<>();

    public static void addTransformer(Entry entry){
        transformers.add(entry);
    }

    public static boolean onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CauldronTileEntity blockEntity){
        for(Entry entry : transformers){
            if(entry.onEntityCollision(state, world, pos, entity, blockEntity)) return true;
        }
        return false;
    }

    public interface Entry {
        /*  Hook for cauldron block entity collision
        *   return: whether execution should cease after hook-in calls
        * */
        default boolean onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CauldronTileEntity blockEntity){
            return false;
        }
    }
}