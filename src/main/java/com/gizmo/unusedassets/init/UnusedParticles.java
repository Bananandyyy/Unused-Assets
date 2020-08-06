package com.gizmo.unusedassets.init;

import java.util.ArrayList;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedParticles {

	private static final ArrayList<ParticleType<?>> PARTICLES = new ArrayList<>();
	
	public static final BasicParticleType LIGHT_PARTICLE_0 = register(new ResourceLocation("unusedassets", "light_block_0"), false);
	public static final BasicParticleType LIGHT_PARTICLE_1 = register(new ResourceLocation("unusedassets", "light_block_1"), false);
	public static final BasicParticleType LIGHT_PARTICLE_2 = register(new ResourceLocation("unusedassets", "light_block_2"), false);
	public static final BasicParticleType LIGHT_PARTICLE_3 = register(new ResourceLocation("unusedassets", "light_block_3"), false);
	public static final BasicParticleType LIGHT_PARTICLE_4 = register(new ResourceLocation("unusedassets", "light_block_4"), false);
	public static final BasicParticleType LIGHT_PARTICLE_5 = register(new ResourceLocation("unusedassets", "light_block_5"), false);
	public static final BasicParticleType LIGHT_PARTICLE_6 = register(new ResourceLocation("unusedassets", "light_block_6"), false);
	public static final BasicParticleType LIGHT_PARTICLE_7 = register(new ResourceLocation("unusedassets", "light_block_7"), false);
	public static final BasicParticleType LIGHT_PARTICLE_8 = register(new ResourceLocation("unusedassets", "light_block_8"), false);
	public static final BasicParticleType LIGHT_PARTICLE_9 = register(new ResourceLocation("unusedassets", "light_block_9"), false);
	public static final BasicParticleType LIGHT_PARTICLE_10 = register(new ResourceLocation("unusedassets", "light_block_10"), false);
	public static final BasicParticleType LIGHT_PARTICLE_11 = register(new ResourceLocation("unusedassets", "light_block_11"), false);
	public static final BasicParticleType LIGHT_PARTICLE_12 = register(new ResourceLocation("unusedassets", "light_block_12"), false);
	public static final BasicParticleType LIGHT_PARTICLE_13 = register(new ResourceLocation("unusedassets", "light_block_13"), false);
	public static final BasicParticleType LIGHT_PARTICLE_14 = register(new ResourceLocation("unusedassets", "light_block_14"), false);
	public static final BasicParticleType LIGHT_PARTICLE_15 = register(new ResourceLocation("unusedassets", "light_block_15"), false);
	
	private static BasicParticleType register(ResourceLocation key, boolean alwaysShow) {
	      return Registry.register(Registry.PARTICLE_TYPE, key, new BasicParticleType(alwaysShow));
	   }
	
	public static void registerTypes(RegistryEvent.Register<ParticleType<?>> event) {
		IForgeRegistry<ParticleType<?>> registry = event.getRegistry();
		PARTICLES.forEach(registry::register);
	}
}
