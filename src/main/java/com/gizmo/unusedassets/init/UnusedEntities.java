package com.gizmo.unusedassets.init;

import java.util.ArrayList;
import com.gizmo.unusedassets.entity.AgentEntity;
import com.gizmo.unusedassets.entity.DispenserMinecartEntity;
import com.gizmo.unusedassets.entity.FishEntity;
import com.gizmo.unusedassets.entity.HappyCreeperEntity;
import com.gizmo.unusedassets.entity.HoodVillagerEntity;
import com.gizmo.unusedassets.entity.LoveGolemEntity;
import com.gizmo.unusedassets.entity.SteveVillagerEntity;
import com.gizmo.unusedassets.entity.earth.*;
import com.gizmo.unusedassets.entity.earth.base.SheepBase;
import com.gizmo.unusedassets.entity.projectile.BoneShardProjectileEntity;
import com.gizmo.unusedassets.entity.projectile.HeartArrowEntity;
import com.gizmo.unusedassets.entity.projectile.MelonSeedProjectileEntity;
import com.gizmo.unusedassets.entity.projectile.PurpleArrowEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
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
	public static final EntityType<HoodVillagerEntity> HOODED_VILLAGER = register(new ResourceLocation("unusedassets", "hooded_villager"), EntityType.Builder.create(HoodVillagerEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F));
	public static final EntityType<SteveVillagerEntity> STEVE_VILLAGER_HYBRID = register(new ResourceLocation("unusedassets", "villager_hybrid"), EntityType.Builder.create(SteveVillagerEntity::new, EntityClassification.CREATURE).size(0.6F, 1.95F));
	public static final EntityType<AgentEntity> AGENT = register(new ResourceLocation("unusedassets", "agent"), EntityType.Builder.create(AgentEntity::new, EntityClassification.CREATURE).size(0.6F, 1.0F));
	public static final EntityType<LoveGolemEntity> LOVE_GOLEM = register(new ResourceLocation("unusedassets", "love_golem"), EntityType.Builder.create(LoveGolemEntity::new, EntityClassification.CREATURE).size(1.4F, 2.7F));
	public static final EntityType<HappyCreeperEntity> HAPPY_CREEPER = register(new ResourceLocation("unusedassets", "happy_creeper"), EntityType.Builder.create(HappyCreeperEntity::new, EntityClassification.CREATURE).size(0.6F, 1.7F));
	public static final EntityType<DispenserMinecartEntity> DISPENSER_MINECART = register(new ResourceLocation("unusedassets", "dispenser_minecart"), EntityType.Builder.<DispenserMinecartEntity>create(DispenserMinecartEntity::new, EntityClassification.MISC).size(0.98F, 0.7F).trackingRange((8)));
	
//	public static final EntityType<NamelessEntity> NAMELESS_ONE = register(new ResourceLocation("unusedassets", "nameless_one"), EntityType.Builder.create(NamelessEntity::new, EntityClassification.MONSTER).size(0.6F, 2.0F));
	
	public static final EntityType<AlbinoCowEntity> ALBINO_COW = register(new ResourceLocation("unusedassets", "albino_cow"), EntityType.Builder.create(AlbinoCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<AmberChickenEntity> AMBER_CHICKEN = register(new ResourceLocation("unusedassets", "amber_chicken"), EntityType.Builder.create(AmberChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<AshenCowEntity> ASHEN_COW = register(new ResourceLocation("unusedassets", "ashen_cow"), EntityType.Builder.create(AshenCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<BoldStripedRabbitEntity> BOLD_STRIPED_RABBIT = register(new ResourceLocation("unusedassets", "bold_striped_rabbit"), EntityType.Builder.create(BoldStripedRabbitEntity::new, EntityClassification.CREATURE).size(EntityType.RABBIT.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<BoneSpiderEntity> BONE_SPIDER = register(new ResourceLocation("unusedassets", "bone_spider"), EntityType.Builder.create(BoneSpiderEntity::new, EntityClassification.CREATURE).size(EntityType.SPIDER.getWidth(), EntityType.SPIDER.getHeight()));
	public static final EntityType<BronzedChickenEntity> BRONZED_CHICKEN = register(new ResourceLocation("unusedassets", "bronzed_chicken"), EntityType.Builder.create(BronzedChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<BruleCowEntity> BRULE_COW = register(new ResourceLocation("unusedassets", "brule_cow"), EntityType.Builder.create(BruleCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<CluckShroomEntity> CLUCK_SHROOM = register(new ResourceLocation("unusedassets", "cluck_shroom"), EntityType.Builder.create(CluckShroomEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<CookieCowEntity> COOKIE_COW = register(new ResourceLocation("unusedassets", "cookie_cow"), EntityType.Builder.create(CookieCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<DairyCowEntity> DAIRY_COW = register(new ResourceLocation("unusedassets", "dairy_cow"), EntityType.Builder.create(DairyCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<DyedCatEntity> DYED_CAT = register(new ResourceLocation("unusedassets", "dyed_cat"), EntityType.Builder.create(DyedCatEntity::new, EntityClassification.CREATURE).size(EntityType.CAT.getWidth(), EntityType.CAT.getHeight()));
	public static final EntityType<FancyChickenEntity> FANCY_CHICKEN = register(new ResourceLocation("unusedassets", "fancy_chicken"), EntityType.Builder.create(FancyChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<FleckedSheepEntity> FLECKED_SHEEP = register(new ResourceLocation("unusedassets", "flecked_sheep"), EntityType.Builder.create(FleckedSheepEntity::new, EntityClassification.CREATURE).size(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight()));
	public static final EntityType<FurnaceGolemEntity> FURNACE_GOLEM = register(new ResourceLocation("unusedassets", "furnace_golem"), EntityType.Builder.create(FurnaceGolemEntity::new, EntityClassification.CREATURE).size(EntityType.IRON_GOLEM.getWidth(), EntityType.IRON_GOLEM.getHeight()));
	public static final EntityType<GlowSquidEntity> GLOW_SQUID = register(new ResourceLocation("unusedassets", "glow_squid"), EntityType.Builder.create(GlowSquidEntity::new, EntityClassification.CREATURE).size(EntityType.SQUID.getWidth(), EntityType.SQUID.getHeight()));
	public static final EntityType<GoldCrestedChickenEntity> GOLD_CRESTED_CHICKEN = register(new ResourceLocation("unusedassets", "gold_crested__chicken"), EntityType.Builder.create(GoldCrestedChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<HarelequinRabbitEntity> HARELEQUIN_RABBIT = register(new ResourceLocation("unusedassets", "harelequin_rabbit"), EntityType.Builder.create(HarelequinRabbitEntity::new, EntityClassification.CREATURE).size(EntityType.RABBIT.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<HornedSheepEntity> HORNED_SHEEP = register(new ResourceLocation("unusedassets", "horned_sheep"), EntityType.Builder.create(HornedSheepEntity::new, EntityClassification.CREATURE).size(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight()));
	public static final EntityType<InkySheepEntity> INKY_SHEEP = register(new ResourceLocation("unusedassets", "inky_sheep"), EntityType.Builder.create(InkySheepEntity::new, EntityClassification.CREATURE).size(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight()));
	public static final EntityType<JollyLlamaEntity> JOLLY_LLAMA = register(new ResourceLocation("unusedassets", "jolly_llama"), EntityType.Builder.create(JollyLlamaEntity::new, EntityClassification.CREATURE).size(EntityType.LLAMA.getWidth(), EntityType.LLAMA.getHeight()));
	public static final EntityType<JumboRabbitEntity> JUMBO_RABBIT = register(new ResourceLocation("unusedassets", "jumbo_rabbit"), EntityType.Builder.create(JumboRabbitEntity::new, EntityClassification.CREATURE).size(0.8F, 1.0F));
	public static final EntityType<MelonGolemEntity> MELON_GOLEM = register(new ResourceLocation("unusedassets", "melon_golem"), EntityType.Builder.create(MelonGolemEntity::new, EntityClassification.CREATURE).size(EntityType.SNOW_GOLEM.getWidth(), EntityType.SNOW_GOLEM.getHeight()));
	public static final EntityType<MidnightChickenEntity> MIDNIGHT_CHICKEN = register(new ResourceLocation("unusedassets", "midnight_chicken"), EntityType.Builder.create(MidnightChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<MoobloomEntity> MOOBLOOM = register(new ResourceLocation("unusedassets", "moobloom"), EntityType.Builder.create(MoobloomEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<MoolipEntity> MOOLIP = register(new ResourceLocation("unusedassets", "moolip"), EntityType.Builder.create(MoolipEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<MottledPigEntity> MOTTLED_PIG = register(new ResourceLocation("unusedassets", "mottled_pig"), EntityType.Builder.create(MottledPigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<MuddyFootRabbitEntity> MUDDY_FOOT_RABBIT = register(new ResourceLocation("unusedassets", "muddy_foot_rabbit"), EntityType.Builder.create(MuddyFootRabbitEntity::new, EntityClassification.CREATURE).size(EntityType.RABBIT.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<MuddyPigEntity> MUDDY_PIG = register(new ResourceLocation("unusedassets", "muddy_pig"), EntityType.Builder.create(MuddyPigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<PalePigEntity> PALE_PIG = register(new ResourceLocation("unusedassets", "pale_pig"), EntityType.Builder.create(PalePigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<PatchedSheepEntity> PATCHED_SHEEP = register(new ResourceLocation("unusedassets", "patched_sheep"), EntityType.Builder.create(PatchedSheepEntity::new, EntityClassification.CREATURE).size(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight()));
	public static final EntityType<PiebaldPigEntity> PIEBALD_PIG = register(new ResourceLocation("unusedassets", "piebald_pig"), EntityType.Builder.create(PiebaldPigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<PinkFootedPigEntity> PINK_PIG = register(new ResourceLocation("unusedassets", "pink_footed_pig"), EntityType.Builder.create(PinkFootedPigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<PintoCowEntity> PINTO_COW = register(new ResourceLocation("unusedassets", "pinto_cow"), EntityType.Builder.create(PintoCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<RainbowSheepEntity> RAINBOW_SHEEP = register(new ResourceLocation("unusedassets", "rainbow_sheep"), EntityType.Builder.create(RainbowSheepEntity::new, EntityClassification.CREATURE).size(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight()));
	public static final EntityType<RockySheepEntity> ROCKY_SHEEP = register(new ResourceLocation("unusedassets", "rocky_sheep"), EntityType.Builder.create(RockySheepEntity::new, EntityClassification.CREATURE).size(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight()));
	public static final EntityType<SkeletonWolfEntity> SKELE_WOLF = register(new ResourceLocation("unusedassets", "skeleton_wolf"), EntityType.Builder.create(SkeletonWolfEntity::new, EntityClassification.CREATURE).size(EntityType.WOLF.getWidth(), EntityType.WOLF.getHeight()));
	public static final EntityType<SkewbaldChickenEntity> SKEWBALD_CHICKEN = register(new ResourceLocation("unusedassets", "skewbald_chicken"), EntityType.Builder.create(SkewbaldChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<SootyPigEntity> SOOTY_PIG = register(new ResourceLocation("unusedassets", "sooty_pig"), EntityType.Builder.create(SootyPigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<SpottedPigEntity> SPOTTED_PIG = register(new ResourceLocation("unusedassets", "spotted_pig"), EntityType.Builder.create(SpottedPigEntity::new, EntityClassification.CREATURE).size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<StormyChickenEntity> STORMY_CHICKEN = register(new ResourceLocation("unusedassets", "stormy_chicken"), EntityType.Builder.create(StormyChickenEntity::new, EntityClassification.CREATURE).size(EntityType.CHICKEN.getWidth(), EntityType.CHICKEN.getHeight()));
	public static final EntityType<SunsetCowEntity> SUNSET_COW = register(new ResourceLocation("unusedassets", "sunset_cow"), EntityType.Builder.create(SunsetCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<TropicalSlimeEntity> TROPICAL_SLIME = register(new ResourceLocation("unusedassets", "tropical_slime"), EntityType.Builder.create(TropicalSlimeEntity::new, EntityClassification.CREATURE) .size(2.04F, 2.04F).immuneToFire());
	public static final EntityType<VestedRabbitEntity> VESTED_RABBIT = register(new ResourceLocation("unusedassets", "vested_rabbit"), EntityType.Builder.create(VestedRabbitEntity::new, EntityClassification.CREATURE).size(EntityType.RABBIT.getWidth(), EntityType.PIG.getHeight()));
	public static final EntityType<VilerWitchEntity> VILER_WITCH = register(new ResourceLocation("unusedassets", "viler_witch"), EntityType.Builder.create(VilerWitchEntity::new, EntityClassification.MONSTER).size(EntityType.WITCH.getWidth(), EntityType.WITCH.getHeight()));
	public static final EntityType<WoolyCowEntity> WOOLY_COW = register(new ResourceLocation("unusedassets", "wooly_cow"), EntityType.Builder.create(WoolyCowEntity::new, EntityClassification.CREATURE).size(EntityType.COW.getWidth(), EntityType.COW.getHeight()));
	public static final EntityType<BoulderingZombieEntity> BOULDERING_ZOMBIE = register(new ResourceLocation("unusedassets", "bouldering_zombie"), EntityType.Builder.create(BoulderingZombieEntity::new, EntityClassification.CREATURE).size(EntityType.ZOMBIE.getWidth(), EntityType.ZOMBIE.getHeight()));
	public static final EntityType<LobberZombieEntity> LOBBER_ZOMBIE = register(new ResourceLocation("unusedassets", "lobber_zombie"), EntityType.Builder.create(LobberZombieEntity::new, EntityClassification.CREATURE).size(EntityType.ZOMBIE.getWidth(), EntityType.ZOMBIE.getHeight()));
	
	public static final EntityType<BoneShardProjectileEntity> BONE_SHARD = register(new ResourceLocation("unusedassets", "bone_shard"), EntityType.Builder.<BoneShardProjectileEntity>create(BoneShardProjectileEntity::new, EntityClassification.MISC).size(0.25F, 0.25F));
	public static final EntityType<MelonSeedProjectileEntity> MELON_SEED_PROJECTILE = register(new ResourceLocation("unusedassets", "melon_seed_projectile"), EntityType.Builder.<MelonSeedProjectileEntity>create(MelonSeedProjectileEntity::new, EntityClassification.MISC).size(0.25F, 0.25F));

	
	public static void entityAttributes() {
		GlobalEntityTypeAttributes.put(AGENT, AgentEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ALBINO_COW, AlbinoCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(AMBER_CHICKEN, AmberChickenEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ASHEN_COW, AshenCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(BOLD_STRIPED_RABBIT, BoldStripedRabbitEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(BONE_SPIDER, BoneSpiderEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(BRONZED_CHICKEN, BronzedChickenEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(BRULE_COW, BruleCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(CLUCK_SHROOM, CluckShroomEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(COOKIE_COW, CookieCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(DAIRY_COW, DairyCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(DYED_CAT, DyedCatEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(FANCY_CHICKEN, FancyChickenEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(FISH, FishEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(FLECKED_SHEEP, SheepBase.registerAttributes().create());
		GlobalEntityTypeAttributes.put(FURNACE_GOLEM, FurnaceGolemEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(GLOW_SQUID, GlowSquidEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(GOLD_CRESTED_CHICKEN, GoldCrestedChickenEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(HAPPY_CREEPER, HappyCreeperEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(HARELEQUIN_RABBIT, HarelequinRabbitEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(HOODED_VILLAGER, HoodVillagerEntity.attributes().create());
		GlobalEntityTypeAttributes.put(HORNED_SHEEP, HornedSheepEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(INKY_SHEEP, InkySheepEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(JOLLY_LLAMA, JollyLlamaEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(JUMBO_RABBIT, JumboRabbitEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(LOVE_GOLEM, LoveGolemEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(MELON_GOLEM, MelonGolemEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(MIDNIGHT_CHICKEN, MidnightChickenEntity.attributes().create());
		GlobalEntityTypeAttributes.put(MOOBLOOM, MoobloomEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(MOOLIP, MoolipEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(MOTTLED_PIG, MottledPigEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(MUDDY_FOOT_RABBIT, MuddyFootRabbitEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(MUDDY_PIG, MuddyPigEntity.registerAttributes().create());
//		GlobalEntityTypeAttributes.put(NAMELESS_ONE, NamelessEntity.attributes().create());
		GlobalEntityTypeAttributes.put(PALE_PIG, PalePigEntity.attributes().create());
		GlobalEntityTypeAttributes.put(PATCHED_SHEEP, PatchedSheepEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(PIEBALD_PIG, PiebaldPigEntity.attributes().create());
		GlobalEntityTypeAttributes.put(PINK_PIG, PinkFootedPigEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(PINTO_COW, PintoCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(RAINBOW_SHEEP, RainbowSheepEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(ROCKY_SHEEP, RockySheepEntity.attributes().create());
		GlobalEntityTypeAttributes.put(SKELE_WOLF, SkeletonWolfEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(SKEWBALD_CHICKEN, SkewbaldChickenEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(SOOTY_PIG, SootyPigEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(SPOTTED_PIG, SpottedPigEntity.attributes().create());
		GlobalEntityTypeAttributes.put(STORMY_CHICKEN, StormyChickenEntity.attributes().create());
		GlobalEntityTypeAttributes.put(SUNSET_COW, SunsetCowEntity.attributes().create());
		GlobalEntityTypeAttributes.put(TROPICAL_SLIME, TropicalSlimeEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(VESTED_RABBIT, VestedRabbitEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(VILER_WITCH, VilerWitchEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(WOOLY_COW, WoolyCowEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(BOULDERING_ZOMBIE, BoulderingZombieEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(LOBBER_ZOMBIE, LobberZombieEntity.registerAttributes().create());
		GlobalEntityTypeAttributes.put(STEVE_VILLAGER_HYBRID, SteveVillagerEntity.registerAttributes().create());
	}
	
	private static <T extends Entity> EntityType<T> register(ResourceLocation id, EntityType.Builder<T> builder)
    {
        EntityType<T> type = builder.build(id.toString());
        type.setRegistryName(id);
        ENTITY_TYPES.add(type);
        return type;
    }

	@SubscribeEvent
	public static void registerTypes(RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> registry = event.getRegistry();
		ENTITY_TYPES.forEach(registry::register);
	}
}
