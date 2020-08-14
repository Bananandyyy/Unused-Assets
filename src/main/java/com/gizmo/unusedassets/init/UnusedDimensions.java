package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.UnusedAssets;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

//@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedDimensions {

	public static DimensionType dungeons_dimType;
    public static final RegistryKey<DimensionType> dungeons = RegistryKey.func_240903_a_(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(UnusedAssets.MOD_ID, "dungeons"));
    public static final RegistryKey<World> dungeons_w = RegistryKey.func_240903_a_(Registry.WORLD_KEY, new ResourceLocation(UnusedAssets.MOD_ID, "dungeons"));

}
