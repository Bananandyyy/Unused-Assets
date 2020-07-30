package com.gizmo.unusedassets.init.blocks;

import java.util.ArrayList;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.blocks.LightBlock;
import com.gizmo.unusedassets.blocks.OldCutterBlock;
import com.gizmo.unusedassets.blocks.ReactorCoreBlock;
import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BedrockBlocks {

	private static final ArrayList<Block> BLOCKS = new ArrayList<>();

	private static final ArrayList<Item> ITEMS = new ArrayList<>();

	public static final Block GLOWING_OBSIDIAN = register("glowing_obsidian", new Block(Block.Properties.from(Blocks.OBSIDIAN).hardnessAndResistance(50.0F, 1200.0F).func_235838_a_((p_235470_0_) -> {
	      return 5;
	   })));
	public static final Block UPDATE1 = register("update1", new Block(Block.Properties.from(Blocks.DIRT).sound(SoundType.GROUND).hardnessAndResistance(0.5F)));
	public static final Block UPDATE2 = register("update2", new Block(Block.Properties.from(Blocks.DIRT).sound(SoundType.GROUND).hardnessAndResistance(0.5F)));
	public static final Block STONECUTTER = register("stonecutter", new OldCutterBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F)));
	public static final Block NETHER_CORE = register("nrc", new ReactorCoreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(50.0F, 1200.0F)));
	public static final Block CYAN_FLOWER = register("cyanflower", new FlowerBlock(Effects.LUCK, 10, Block.Properties.from(Blocks.DANDELION)));
	
	public static final Block LIGHT_0 = register("light_block_0", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 0;}), 0));
	public static final Block LIGHT_1 = register("light_block_1", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 1;}), 1));
	public static final Block LIGHT_2 = register("light_block_2", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 2;}), 2));
	public static final Block LIGHT_3 = register("light_block_3", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 3;}), 3));
	public static final Block LIGHT_4 = register("light_block_4", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 4;}), 4));
	public static final Block LIGHT_5 = register("light_block_5", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 5;}), 5));
	public static final Block LIGHT_6 = register("light_block_6", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 6;}), 6));
	public static final Block LIGHT_7 = register("light_block_7", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 7;}), 7));
	public static final Block LIGHT_8 = register("light_block_8", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 8;}), 8));
	public static final Block LIGHT_9 = register("light_block_9", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 9;}), 9));
	public static final Block LIGHT_10 = register("light_block_10", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 10;}), 10));
	public static final Block LIGHT_11 = register("light_block_11", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 11;}), 11));
	public static final Block LIGHT_12 = register("light_block_12", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 12;}), 12));
	public static final Block LIGHT_13 = register("light_block_13", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 13;}), 13));
	public static final Block LIGHT_14 = register("light_block_14", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 14;}), 14));
	public static final Block LIGHT_15 = register("light_block_15", new LightBlock(Block.Properties.from(Blocks.BARRIER).doesNotBlockMovement().func_235838_a_((p_235418_0_) -> {return 15;}), 15));
	
	private static Block register(String name, Block block) {
		return register(name, block, (new Item.Properties()).group(UnusedAssets.bedrock));
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
