package com.gizmo.unusedassets.init;

import java.util.ArrayList;

import com.gizmo.unusedassets.blocks.MudFluid;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedFluids {

	private static final ArrayList<Fluid> FLUIDS = new ArrayList<>();
	
	public static final FlowingFluid MUD_FLUID_STILL = register(new ResourceLocation("unusedassets", "mud_fluid"), new MudFluid.Source());
    public static final FlowingFluid MUD_FLUID_FLOWING = register(new ResourceLocation("unusedassets", "mud_fluid_flowing"), new MudFluid.Flowing());

    private static <T extends Fluid> T register(ResourceLocation key, T p_215710_1_) {
        return Registry.register(Registry.FLUID, key, p_215710_1_);
     }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Fluid> event) {
    	FLUIDS.forEach(fluid -> event.getRegistry().register(fluid));
		FLUIDS.clear();
    }
}
