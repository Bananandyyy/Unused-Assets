package com.gizmo.unusedassets.util.villagers;

import java.util.Optional;

import com.gizmo.unusedassets.entity.SteveVillagerEntity;
import com.mojang.serialization.Codec;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class ExtraMemoryModule<U> extends MemoryModuleType<U> {

	public ExtraMemoryModule(Optional<Codec<U>> p_i50306_1_) {
		super(p_i50306_1_);
	}
	
public static final MemoryModuleType<LivingEntity> STRANGE_PANIC = register("strange_panic");
	
	public static <U> MemoryModuleType<U> register(String p_223541_0_) {
	      return Registry.register(Registry.MEMORY_MODULE_TYPE, new ResourceLocation(p_223541_0_), new MemoryModuleType<>(Optional.empty()));
	   }

}
