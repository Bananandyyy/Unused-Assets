package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.UnusedAssets;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

//@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedDimensions {

	public static final ResourceLocation DUNGEONS = new ResourceLocation("dungeons");
	
    public static final RegistryKey<DimensionType> DUNGONS = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(UnusedAssets.MOD_ID, "dungeons"));
    public static final RegistryKey<World> DUNGEONS_W = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(UnusedAssets.MOD_ID, "dungeons"));

}
