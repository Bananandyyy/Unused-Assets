package com.gizmo.unusedassets.init.blocks;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.blocks.AntBlock;
import com.gizmo.unusedassets.blocks.GearWireBlock;
import com.gizmo.unusedassets.blocks.LitFurnaceBlock;
import com.gizmo.unusedassets.blocks.LockedChestBlock;
import com.gizmo.unusedassets.blocks.ObeySignBlock;
import com.google.common.base.Function;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public final class UnusedBlocks {
	private static final ArrayList<Block> BLOCKS = new ArrayList<>();

	private static final ArrayList<Item> ITEMS = new ArrayList<>();

	//April Fools!
	public static final Block ANT = register("ant", (Block) new AntBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.0F, 6000F)));
	public static final Block CURSOR = register("cursor", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LOCKED_CHEST = register("locked_chest", new LockedChestBlock(Block.Properties.from(Blocks.CHEST)));
	public static final Block USB_CHARGER = register("usb_charger", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F)));
	public static final Block OBEY = register("trendy_sign", new ObeySignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodType.WARPED));

	//Everything else
	public static final Block GEAR = register("gear", (Block) new GearWireBlock(Block.Properties.from(Blocks.REDSTONE_WIRE).sound(SoundType.METAL).doesNotBlockMovement().hardnessAndResistance(0.0F)));
	public static final Block DEAD_CORAL = register("dead_coral_block", new Block(Block.Properties.from(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final Block WAX_BLOCK = register("wax_block", new Block(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.6F).sound(SoundType.CORAL)));
	public static final Block LIT_FURNACE = register("lit_furnace", (Block) new LitFurnaceBlock(Block.Properties.from(Blocks.FURNACE)));
	public static final Block PAEONIA = register("paeonia", (Block) new FlowerBlock(Effects.SLOW_FALLING, 5, Block.Properties.from(Blocks.DANDELION)));
	public static final Block ROSE = register("rose", (Block) new FlowerBlock(Effects.NIGHT_VISION, 5, Block.Properties.from(Blocks.DANDELION)));
	public static final Block RUBY_BLOCK = register("ruby_block", (Block) new Block(Block.Properties.from(Blocks.EMERALD_BLOCK)));
	public static final Block RUBY_ORE = register("ruby_ore", (Block) new Block(Block.Properties.from(Blocks.EMERALD_ORE)));
	public static final Block DEBUG = register("debug", (Block) new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.0F).sound(SoundType.CLOTH)));
	public static final Block DEBUG2 = register("debug2", (Block) new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.0F).sound(SoundType.CLOTH)));
	public static final Block FIREOLD = register("fireold", (Block) new Block(Block.Properties.from(Blocks.FIRE)));
	public static final Block INFINITE_LAVA = register("infinite_lava_source", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F)));
	public static final Block INFINITE_WATER = register("infinite_water_source", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F)));
	public static final Block MISSING_TEXTURE = register("missing_texture", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0F)));
		
	public static final Block WHITE_CLOTH = register("white_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block LIGHT_GRAY_CLOTH = register("light_gray_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block GRAY_CLOTH = register("gray_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block RED_CLOTH = register("red_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block ORANGE_CLOTH = register("orange_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block YELLOW_CLOTH = register("yellow_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block CHARTREUSE_CLOTH = register("chartreuse_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block GREEN_CLOTH = register("green_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block SPRING_GREEN_CLOTH = register("spring_green_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block CYAN_CLOTH = register("cyan_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block CAPRI_CLOTH = register("capri_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block ULTRAMARINE_CLOTH = register("ultramarine_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block VIOLET_CLOTH = register("violet_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block PURPLE_CLOTH = register("purple_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block MAGENTA_CLOTH = register("magenta_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block ROSE_CLOTH = register("rose_cloth", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));

	//Template
	//public static final Block = register("", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0F)));
	
	
	
	private static Block register(String name, Block block) {
		return register(name, block, (new Item.Properties()).group(UnusedAssets.java));
	}

	private static Block register(String name, Block block, Item.Properties properties) {
		return register(name, block, new BlockItem(block, properties));
	}

	private static Block register(String name, Block block, BlockItem item) {
		return register(name, block, block1 -> item);
	}

	private static Block register(String name, Block block, Function<Block, BlockItem> function) {
		block.setRegistryName(name);
		BLOCKS.add(block);
		if (block.getRegistryName() != null) {
			Item item = (Item) function.apply(block);
			item.setRegistryName(name);
			ITEMS.add(item);
		}
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		BLOCKS.forEach(block -> event.getRegistry().register(block));
		BLOCKS.clear();
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		ITEMS.forEach(item -> event.getRegistry().register(item));
		ITEMS.clear();
	}
}