package com.gizmo.unusedassets.init.blocks;

import java.util.ArrayList;

import com.gizmo.unusedassets.blocks.BetterCauldronBlock;
import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "minecraft", bus = Mod.EventBusSubscriber.Bus.MOD)
public class OverwrittenBlocks {

	private static final ArrayList<Block> BLOCKS = new ArrayList<>();

	private static final ArrayList<Item> ITEMS = new ArrayList<>();
	
	public static final Block CAULDRON = register("cauldron", (Block) new BetterCauldronBlock(Block.Properties.from(Blocks.CAULDRON)));
	
	private static Block register(String name, Block block) {
		return register(name, block, (new Item.Properties()).group(ItemGroup.BREWING));
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
