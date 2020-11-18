package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.UnusedAssets;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnusedAssets.MOD_ID)
public class UnusedSounds {

	public static final SoundEvent GULP = createEvent("item.gulp");
	public static final SoundEvent DRIP = createEvent("item.drip");
	
	
	private static SoundEvent createEvent(String sound) {
		ResourceLocation name = UnusedSounds.registry(sound);
		return new SoundEvent(name).setRegistryName(name);
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(
			GULP,
			DRIP
			);
	};
	
	private UnusedSounds() {}
	
	public static ResourceLocation registry(String name) {
		return new ResourceLocation(UnusedAssets.MOD_ID, name);
	}
}
