package com.gizmo.unusedassets.util;

import com.gizmo.unusedassets.init.UnusedParticles;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import com.gizmo.unusedassets.particles.LightBlockParticle;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;


//TODO: Make this match every other registry in this mod. I'm too stupid rn to do that
@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleHandler {
	
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_0, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_0.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_1, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_1.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_2, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_2.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_3, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_3.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_4, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_4.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_5, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_5.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_6, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_6.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_7, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_7.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_8, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_8.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_9, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_9.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_10, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_10.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_11, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_11.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_12, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_12.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_13, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_13.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_14, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_14.asItem()));
		Minecraft.getInstance().particles.registerFactory(UnusedParticles.LIGHT_PARTICLE_15, new LightBlockParticle.Factory(BedrockBlocks.LIGHT_15.asItem()));
	}
}
