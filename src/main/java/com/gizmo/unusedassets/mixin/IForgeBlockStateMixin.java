package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.gizmo.unusedassets.UnusedAssets;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.extensions.IForgeBlockState;

@Mixin(IForgeBlockState.class)
public interface IForgeBlockStateMixin {

    @Overwrite(
            remap = false
    )
    default boolean isStickyBlock() {
        return UnusedAssets.STICKY_BLOCKS.func_230235_a_(((BlockState) this).getBlock());
    }
}