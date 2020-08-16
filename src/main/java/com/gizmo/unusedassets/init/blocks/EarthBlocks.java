package com.gizmo.unusedassets.init.blocks;

import java.util.ArrayList;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.blocks.CarvedMelonBlock;
import com.gizmo.unusedassets.blocks.MudBlock;
import com.gizmo.unusedassets.init.UnusedFluids;
import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EarthBlocks {
	
	private static final ArrayList<Block> BLOCKS = new ArrayList<>();

	private static final ArrayList<Item> ITEMS = new ArrayList<>();
	
	public static final Block BUTTERCUP = register("buttercup", new FlowerBlock(Effects.JUMP_BOOST, 5, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
	public static final Block MUD_BLOCK = register("mud_fluid", new MudBlock(UnusedFluids.MUD_FLUID_STILL, Block.Properties.create(Material.WATER, MaterialColor.BROWN).doesNotBlockMovement().hardnessAndResistance(100.0F).speedFactor(0.75F) .noDrops()));
	public static final Block RAINBOW_WOOL = register("rainbow_wool", new Block(Block.Properties.from(Blocks.WHITE_WOOL)));
	public static final Block CARVED_MELON = register("carved_melon", new CarvedMelonBlock(Block.Properties.from(Blocks.MELON)));
	public static final Block MELON_GOLEM_HEAD_SHOOT = register("melon_head_shoot", new CarvedMelonBlock(Block.Properties.from(Blocks.MELON)));
	public static final Block MELON_GOLEM_HEAD_BLINK = register("melon_head_blink", new CarvedMelonBlock(Block.Properties.from(Blocks.MELON)));
	public static final Block MELON_LANTERN = register("melon_lantern", new CarvedMelonBlock(Block.Properties.from(Blocks.MELON)));

	private static Block register(String name, Block block) {
		return register(name, block, (new Item.Properties()).group(UnusedAssets.earth));
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
