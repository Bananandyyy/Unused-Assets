package com.gizmo.unusedassets.init;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.items.AnkleMonitorItem;
import com.gizmo.unusedassets.items.DudPotionItem;
import com.gizmo.unusedassets.items.HeartArrowItem;
import com.gizmo.unusedassets.items.HeartBowItem;
import com.gizmo.unusedassets.items.ModDyeItem;
import com.gizmo.unusedassets.items.PurpleArrowItem;
import com.gizmo.unusedassets.items.RealityVisionItem;
import com.gizmo.unusedassets.items.SmarterWatchItem;
import com.gizmo.unusedassets.items.genericitems.AprilFools2019Item;
import com.gizmo.unusedassets.items.genericitems.AprilFools2020Item;
import com.gizmo.unusedassets.util.ModArmorMaterial;
import com.gizmo.unusedassets.util.ModDyeColor;
import java.util.ArrayList;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.SaddleItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedItems {
	private static final ArrayList<Item> ITEMS = new ArrayList<>();

	//April Fools!
	public static final Item THREE_DIMENSIONAL = register("3d", new AprilFools2019Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item RED_KEY = register("red_key", new AprilFools2019Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item YELLOW_KEY = register("yellow_key", new AprilFools2019Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item BLUE_KEY = register("blue_key", new AprilFools2019Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item FINE_ITEM = register("fine_item", new AprilFools2020Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item FOOTPRINT = register("footprint", new AprilFools2020Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item ANKLE_MONITOR = register("ankle_monitor", new AnkleMonitorItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item SMARTER_WATCH = register("smarter_watch", new SmarterWatchItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item REALITY_VISION = register("reality_vision", new RealityVisionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item BUCKET_OF_CHEESE = register("bucket_of_cheese", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item HEART_BOW = register("heart_bow", new HeartBowItem((new Item.Properties()).maxDamage(0).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item HEART_ARROW = register("heart_arrow", new HeartArrowItem((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item HEART_SWORD = register("heart_sword", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item OBSIDIAN_BOAT = register("obsidian_boat", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item HEART_BOAT = register("heart_boat", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	
	public static final Item COOKED_FISH = register("cooked_fish", new Item((new Item.Properties()).group(UnusedAssets.java).food((new Food.Builder()).hunger(5).saturation(0.6F).build())));
	public static final Item CLOTH = register("cloth", new Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item DRAGON_FIREBALL = register("dragon_fireball", new Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item FISH_BUCKET = register("fish_bucket", (Item) new FishBucketItem(UnusedEntities.FISH, (Fluid) Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item HORSE_SADDLE = register("horse_saddle", (Item) new SaddleItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item LEATHER_INFUSED_INGOT = register("leather_infused_ingot", new Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item PURPLE_ARROW = register("purple_arrow", (Item) new PurpleArrowItem((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item QUIVER = register("quiver", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item RAW_FISH = register("raw_fish", new Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item RUBY = register("ruby", new Item((new Item.Properties()).group(UnusedAssets.java)));
	public static final Item STUDDED_HELMET = register("studded_helmet",(Item) new ArmorItem((IArmorMaterial) ModArmorMaterial.STUDDED, EquipmentSlotType.HEAD, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item STUDDED_CHESTPLATE = register("studded_chestplate", (Item) new ArmorItem((IArmorMaterial) ModArmorMaterial.STUDDED, EquipmentSlotType.CHEST, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item STUDDED_LEGGINGS = register("studded_leggings", (Item) new ArmorItem((IArmorMaterial) ModArmorMaterial.STUDDED, EquipmentSlotType.LEGS,(new Item.Properties()).group(UnusedAssets.java)));
	public static final Item STUDDED_BOOTS = register("studded_boots", (Item) new ArmorItem((IArmorMaterial) ModArmorMaterial.STUDDED, EquipmentSlotType.FEET, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item FISH_SPAWN_EGG = register("fish_spawn_egg", (Item) new SpawnEggItem(UnusedEntities.FISH, 7053203, 11386587, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item STEVILLAGER_SPAWN_EGG = register("hybrid_spawn_egg", (Item) new SpawnEggItem(UnusedEntities.STEVE_VILLAGER_HYBRID, 5651507, 2263682, (new Item.Properties()).group(UnusedAssets.java)));
	
	public static final Item ULTRAMARINE_DYE = register("ultramarine_dye", (Item) new ModDyeItem(ModDyeColor.ULTRAMARINE, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item CHARTREUSE_DYE = register("chartreuse_dye", (Item) new ModDyeItem(ModDyeColor.CHARTREUSE, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item ROSE_DYE = register("rose_dye", (Item) new ModDyeItem(ModDyeColor.ROSE, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item CAPRI_DYE = register("capri_dye", (Item) new ModDyeItem(ModDyeColor.CAPRI, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item VIOLET_DYE = register("violet_dye", (Item) new ModDyeItem(ModDyeColor.VIOLET, (new Item.Properties()).group(UnusedAssets.java)));
	public static final Item SPRING_GREEN_DYE = register("spring_green_dye", (Item) new ModDyeItem(ModDyeColor.CAPRI, (new Item.Properties()).group(UnusedAssets.java)));

	public static final Item POTION1 = register("uninteresting_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION2 = register("bland_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION3 = register("clear_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION4 = register("milky_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION5 = register("diffuse_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION6 = register("artless_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION7 = register("thin_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION8 = register("flat_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION9 = register("bulky_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION10 = register("bungling_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION11 = register("buttered_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION12 = register("smooth_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION13 = register("suave_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION14 = register("debonair_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION15 = register("elegant_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION16 = register("fancy_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION17 = register("charming_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION18 = register("dashing_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION19 = register("refined_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION20 = register("cordial_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION21 = register("sparkling_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION22 = register("potent_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION23 = register("foul_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION24 = register("odorless_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION25 = register("rank_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION26 = register("harsh_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION27 = register("acrid_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION28 = register("gross_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION29 = register("stinky_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));
	public static final Item POTION30 = register("burpy_potion", (Item) new DudPotionItem((new Item.Properties()).maxStackSize(1).group(UnusedAssets.java)));

	//eyyyyyy bedrock time!
	public static final Item COD_EGGS = register("cod_eggs", new Item((new Item.Properties()).group(UnusedAssets.bedrock)));
	public static final Item PUFFERFISH_EGGS = register("pufferfish_eggs", new Item((new Item.Properties()).group(UnusedAssets.bedrock)));
	public static final Item SALMON_EGGS = register("salmon_eggs", new Item((new Item.Properties()).group(UnusedAssets.bedrock)));
	public static final Item TROPICAL_FISH_EGGS = register("tropical_fish_eggs", new Item((new Item.Properties()).group(UnusedAssets.bedrock)));
	public static final Item LIGHT_BLOCK_TWEAKER = register("light_block_tweaker", new Item((new Item.Properties()).group(UnusedAssets.bedrock)));
	
	//anddddd now education time!
	public static final Item AGENT_EGG = register("agent_egg", new SpawnEggItem(UnusedEntities.AGENT, 0000000, 0000000, (new Item.Properties().group(UnusedAssets.education))));
	public static final Item ANTIDOTE = register("antidote", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BOARD = register("board", new Item((new Item.Properties()).maxStackSize(16).group(UnusedAssets.education)));
	public static final Item BLEACH = register("bleach", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item ELIXIR = register("elixir", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item EYE_DROPS = register("eye_drops", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GARBAGE = register("garbage", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GLUE = register("glue", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item ICE_BOMB = register("ice_bomb", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item PORTFOLIO = register("portfolio", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item POSTER = register("poster", new Item((new Item.Properties()).maxStackSize(16).group(UnusedAssets.education)));
	public static final Item SALT = register("salt", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item SLATE = register("slate", new Item((new Item.Properties()).maxStackSize(16).group(UnusedAssets.education)));
	public static final Item SUPER_FERTILIZER = register("fertilizer", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item TONIC = register("tonic", new Item((new Item.Properties()).group(UnusedAssets.education)));
	
	//Many variants of items. Here we have balloons, beakers, flasks, glow sticks, jars, and sparklers! 
	public static final Item RED_BALLOON = register("red_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item ORANGE_BALLOON = register("orange_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item YELLOW_BALLOON = register("yellow_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GREEN_BALLOON = register("green_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item LIME_BALLOON = register("lime_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item CYAN_BALLOON = register("cyan_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLUE_BALLOON = register("blue_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item LIGHT_BLUE_BALLOON = register("light_blue_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item PURPLE_BALLOON = register("purple_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item MAGENTA_BALLOON = register("magenta_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item PINK_BALLOON = register("pink_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BROWN_BALLOON = register("brown_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item LIGHT_GRAY_BALLOON = register("light_gray_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GRAY_BALLOON = register("gray_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLACK_BALLOON = register("black_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item WHITE_BALLOON = register("white_balloon", new Item((new Item.Properties()).group(UnusedAssets.education)));
	
	public static final Item RED_BEAKER = register("red_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item ORANGE_BEAKER = register("orange_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item YELLOW_BEAKER = register("yellow_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GREEN_BEAKER = register("green_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLUE_BEAKER = register("blue_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item PURPLE_BEAKER = register("purple_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item INDIGO_BEAKER = register("indigo_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BROWN_BEAKER = register("brown_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item LIGHT_GRAY_BEAKER = register("light_gray_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GRAY_BEAKER = register("gray_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLACK_BEAKER = register("black_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item WHITE_BEAKER = register("white_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item CLEAR_BEAKER = register("clear_beaker", new Item((new Item.Properties()).group(UnusedAssets.education)));

	public static final Item RED_FLASK = register("red_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item ORANGE_FLASK = register("orange_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item YELLOW_FLASK = register("yellow_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GREEN_FLASK = register("green_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLUE_FLASK = register("blue_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item PURPLE_FLASK = register("purple_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item INDIGO_FLASK = register("indigo_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BROWN_FLASK = register("brown_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item LIGHT_GRAY_FLASK = register("light_gray_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GRAY_FLASK = register("gray_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLACK_FLASK = register("black_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item WHITE_FLASK = register("white_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item CLEAR_FLASK = register("clear_flask", new Item((new Item.Properties()).group(UnusedAssets.education)));

	public static final Item RED_GLOW_STICK = register("red_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item ORANGE_GLOW_STICK = register("orange_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item YELLOW_GLOW_STICK = register("yellow_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item GREEN_GLOW_STICK = register("green_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item LIME_GLOW_STICK = register("lime_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item CYAN_GLOW_STICK = register("cyan_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item BLUE_GLOW_STICK = register("blue_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item LIGHT_BLUE_GLOW_STICK = register("light_blue_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item PURPLE_GLOW_STICK = register("purple_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item MAGENTA_GLOW_STICK = register("magenta_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item PINK_GLOW_STICK = register("pink_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item BROWN_GLOW_STICK = register("brown_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item GRAY_GLOW_STICK = register("gray_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item WHITE_GLOW_STICK = register("white_glow_stick", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));

	public static final Item RED_JAR = register("red_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item ORANGE_JAR = register("orange_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item YELLOW_JAR = register("yellow_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GREEN_JAR = register("green_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLUE_JAR = register("blue_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item PURPLE_JAR = register("purple_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item INDIGO_JAR = register("indigo_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BROWN_JAR = register("brown_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item LIGHT_GRAY_JAR = register("light_gray_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item GRAY_JAR = register("gray_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item BLACK_JAR = register("black_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item WHITE_JAR = register("white_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));
	public static final Item CLEAR_JAR = register("clear_jar", new Item((new Item.Properties()).group(UnusedAssets.education)));

	public static final Item RED_SPARKLER = register("red_sparkler", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item ORANGE_SPARKLER = register("orange_sparkler", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item GREEN_SPARKLER = register("green_sparkler", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item BLUE_SPARKLER = register("blue_sparkler", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));
	public static final Item PURPLE_SPARKLER = register("purple_sparkler", new Item((new Item.Properties()).maxStackSize(1).group(UnusedAssets.education)));

	//Minecraft Earth stuff
	//public static final Item HORN = register("horn", new Item((new Item.Properties()).group(UnusedAssets.earth)));
	
	
	//Template
	//public static final Item  = register("", new Item((new Item.Properties()).group(UnusedAssets.education)));
	
	private static Item register(String name, Item item) {
		item.setRegistryName(name);
		ITEMS.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		ITEMS.forEach(item -> event.getRegistry().register((Item) item));
		ITEMS.clear();
	}
}