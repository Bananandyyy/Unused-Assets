package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.entity.*;
import com.gizmo.unusedassets.entity.earth.*;

import java.util.ArrayList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
	
	public static final EntityType<AlbinoCowEntity> ALBINO_COW = register(new ResourceLocation("unusedassets", "albino_cow"), EntityType.Builder.create(AlbinoCowEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<AmberChickenEntity> AMBER_CHICKEN = register(new ResourceLocation("unusedassets", "amber_chicken"), EntityType.Builder.create(AmberChickenEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<AshenCowEntity> ASHEN_COW = register(new ResourceLocation("unusedassets", "ashen_cow"), EntityType.Builder.create(AshenCowEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<CluckShroomEntity> CLUCK_SHROOM = register(new ResourceLocation("unusedassets", "cluck_shroom"), EntityType.Builder.create(CluckShroomEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<FleckedSheepEntity> FLECKED_SHEEP = register(new ResourceLocation("unusedassets", "flecked_sheep"), EntityType.Builder.create(FleckedSheepEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<HornedSheepEntity> HORNED_SHEEP = register(new ResourceLocation("unusedassets", "horned_sheep"), EntityType.Builder.create(HornedSheepEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<InkySheepEntity> INKY_SHEEP = register(new ResourceLocation("unusedassets", "inky_sheep"), EntityType.Builder.create(InkySheepEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<MidnightChickenEntity> MIDNIGHT_CHICKEN = register(new ResourceLocation("unusedassets", "midnight_chicken"), EntityType.Builder.create(MidnightChickenEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<RockySheepEntity> ROCKY_SHEEP = register(new ResourceLocation("unusedassets", "rocky_sheep"), EntityType.Builder.create(RockySheepEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<StormyChickenEntity> STORMY_CHICKEN = register(new ResourceLocation("unusedassets", "stormy_chicken"), EntityType.Builder.create(StormyChickenEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));
	public static final EntityType<SunsetCowEntity> SUNSET_COW = register(new ResourceLocation("unusedassets", "sunset_cow"), EntityType.Builder.create(SunsetCowEntity::new, EntityClassification.CREATURE).size(0.9F, 1.3F));

	
	public static void entityAttributes() {
		GlobalEntityTypeAttributes.put(ALBINO_COW, AlbinoCowEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(AMBER_CHICKEN, AmberChickenEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(ASHEN_COW, AshenCowEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(CLUCK_SHROOM, CluckShroomEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(FLECKED_SHEEP, FleckedSheepEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(HORNED_SHEEP, HornedSheepEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(INKY_SHEEP, InkySheepEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(MIDNIGHT_CHICKEN, MidnightChickenEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(ROCKY_SHEEP, RockySheepEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(STORMY_CHICKEN, StormyChickenEntity.attributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(SUNSET_COW, SunsetCowEntity.attributes().func_233813_a_());


	}
	
	private static <T extends net.minecraft.entity.Entity> EntityType<T> register(ResourceLocation id, EntityType.Builder<T> builder) {
		return (EntityType<T>) Registry.register(Registry.ENTITY_TYPE, id, builder.build(id.toString()));
	}

	@SubscribeEvent
	public static void registerTypes(RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> registry = event.getRegistry();
		ENTITY_TYPES.forEach(registry::register);
	}
}
