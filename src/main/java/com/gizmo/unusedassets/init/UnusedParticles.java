package com.gizmo.unusedassets.init;

import java.util.ArrayList;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedParticles {

	private static final ArrayList<ParticleType<?>> PARTICLES = new ArrayList<>();
	
	public static final BasicParticleType LIGHT_PARTICLE_0 = register(new ResourceLocation("unusedassets", "light_block_0"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_1 = register(new ResourceLocation("unusedassets", "light_block_1"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_2 = register(new ResourceLocation("unusedassets", "light_block_2"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_3 = register(new ResourceLocation("unusedassets", "light_block_3"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_4 = register(new ResourceLocation("unusedassets", "light_block_4"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_5 = register(new ResourceLocation("unusedassets", "light_block_5"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_6 = register(new ResourceLocation("unusedassets", "light_block_6"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_7 = register(new ResourceLocation("unusedassets", "light_block_7"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_8 = register(new ResourceLocation("unusedassets", "light_block_8"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_9 = register(new ResourceLocation("unusedassets", "light_block_9"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_10 = register(new ResourceLocation("unusedassets", "light_block_10"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_11 = register(new ResourceLocation("unusedassets", "light_block_11"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_12 = register(new ResourceLocation("unusedassets", "light_block_12"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_13 = register(new ResourceLocation("unusedassets", "light_block_13"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_14 = register(new ResourceLocation("unusedassets", "light_block_14"), new BasicParticleType(false));
	public static final BasicParticleType LIGHT_PARTICLE_15 = register(new ResourceLocation("unusedassets", "light_block_15"), new BasicParticleType(false));
	
	private static BasicParticleType register(ResourceLocation name, BasicParticleType particle) {
		particle.setRegistryName(name);
		PARTICLES.add(particle);
		return particle;
	}
	
	public static void registerTypes(RegistryEvent.Register<ParticleType<?>> event) {
		IForgeRegistry<ParticleType<?>> registry = event.getRegistry();
		PARTICLES.forEach(registry::register);
	}
}
