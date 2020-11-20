package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.UnusedAssets;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;

public class UnusedTags {
	public static class Fluids {

        public static final ITag.INamedTag<Fluid> MUD = tag("mud");

        private static ITag.INamedTag<Fluid> tag(String name) {
            return FluidTags.makeWrapperTag(UnusedAssets.MOD_ID + ":" + name);
        }
    }
}
