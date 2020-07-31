package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.entity.AgentEntity;
import com.gizmo.unusedassets.entity.FishEntity;
import com.gizmo.unusedassets.entity.HappyCreeperEntity;
import com.gizmo.unusedassets.entity.HeartArrowEntity;
import com.gizmo.unusedassets.entity.LoveGolemEntity;
import com.gizmo.unusedassets.entity.PurpleArrowEntity;
import com.gizmo.unusedassets.entity.SteveVillagerEntity;
import com.gizmo.unusedassets.entity.dungeons.NamelessEntity;

import java.util.ArrayList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedEntities {
	private static final ArrayList<EntityType<?>> ENTITY_TYPES = new ArrayList<>();

	public static final EntityType<FishEntity> FISH = register(new ResourceLocation("unusedassets", "fish"), EntityType.Builder.create(FishEntity::new, EntityClassification.WATER_CREATURE).size(0.5F, 0.3F));
	public static final EntityType<PurpleArrowEntity> PURPLE_ARROW = register(new ResourceLocation("unusedassets", "purple_arrow"), EntityType.Builder.<PurpleArrowEntity>create(PurpleArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
	public static final EntityType<HeartArrowEntity> HEART_ARROW = register(new ResourceLocation("unusedassets", "heart_arrow"), EntityType.Builder.<HeartArrowEntity>create(HeartArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
//	public static final EntityType<HoodVillagerEntity> HOODED_VILLAGER = register(new ResourceLocation("unusedassets", "hooded_villager"), EntityType.Builder.create(HoodVillagerEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F));
	public static final EntityType<SteveVillagerEntity> STEVE_VILLAGER_HYBRID = register(new ResourceLocation("unusedassets", "villager_hybrid"), EntityType.Builder.create(SteveVillagerEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F));
	public static final EntityType<AgentEntity> AGENT = register(new ResourceLocation("unusedassets", "agent"), EntityType.Builder.create(AgentEntity::new, EntityClassification.CREATURE).size(0.6F, 1.0F));
	public static final EntityType<LoveGolemEntity> LOVE_GOLEM = register(new ResourceLocation("unusedassets", "love_golem"), EntityType.Builder.create(LoveGolemEntity::new, EntityClassification.CREATURE).size(1.4F, 2.7F));
	public static final EntityType<HappyCreeperEntity> HAPPY_CREEPER = register(new ResourceLocation("unusedassets", "happy_creeper"), EntityType.Builder.create(HappyCreeperEntity::new, EntityClassification.CREATURE).size(0.6F, 1.7F));
	
//	public static final EntityType<NamelessEntity> NAMELESS_ONE = register(new ResourceLocation("unusedassets", "nameless_one"), EntityType.Builder.create(NamelessEntity::new, EntityClassification.MONSTER).size(0.6F, 2.0F));
	
	private static <T extends net.minecraft.entity.Entity> EntityType<T> register(ResourceLocation id, EntityType.Builder<T> builder) {
		return (EntityType<T>) Registry.register(Registry.ENTITY_TYPE, id, builder.build(id.toString()));
	}

	@SubscribeEvent
	public static void registerTypes(RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> registry = event.getRegistry();
		ENTITY_TYPES.forEach(registry::register);
	}
}
