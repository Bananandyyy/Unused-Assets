package com.gizmo.unusedassets.init.blocks;

import java.util.ArrayList;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.blocks.education.ColoredTorchBlock;
import com.gizmo.unusedassets.blocks.education.CompoundBlock;
import com.gizmo.unusedassets.blocks.education.ConstructorBlock;
import com.gizmo.unusedassets.blocks.education.ReducerBlock;
import com.gizmo.unusedassets.blocks.education.TableBlock;
import com.gizmo.unusedassets.blocks.education.UnderwaterTNTBlock;
import com.gizmo.unusedassets.blocks.education.UnderwaterTorchBlock;
import com.google.common.base.Function;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EducationBlocks {

	private static final ArrayList<Block> BLOCKS = new ArrayList<>();

	private static final ArrayList<Item> ITEMS = new ArrayList<>();
	
	public static final Block ALLOW = register("allow", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block BORDER = register("border", new WallBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block COMPOUND_CREATOR = register("compound_creator", new CompoundBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block DENY = register("deny", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block ELEMENT_CONSTRUCTOR = register("element_constructor", new ConstructorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block HEAT_BLOCK = register("heat_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block LAB_TABLE = register("lab_table", new TableBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block MATERIAL_REDUCER = register("material_reducer", new ReducerBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final Block UNDERWATER_TNT = register("underwater_tnt", new UnderwaterTNTBlock(Block.Properties.from(Blocks.TNT)));
	public static final Block UNDERWATER_TORCH = register("underwater_torch", new UnderwaterTorchBlock(Block.Properties.from(Blocks.TORCH)));
	public static final Block RED_TORCH = register("red_torch", new ColoredTorchBlock(Block.Properties.from(Blocks.TORCH)));
	public static final Block GREEN_TORCH = register("green_torch", new ColoredTorchBlock(Block.Properties.from(Blocks.TORCH)));
	public static final Block BLUE_TORCH = register("blue_torch", new ColoredTorchBlock(Block.Properties.from(Blocks.TORCH)));
	public static final Block PURPLE_TORCH = register("purple_torch", new ColoredTorchBlock(Block.Properties.from(Blocks.TORCH)));

	//Elements
	public static final Block HYDROGEN = register("hydrogen", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block HELIUM = register("helium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LITHIUM = register("lithium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BERYLLIUM = register("beryllium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BORON = register("boron", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CARBON = register("carbon", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NITROGEN = register("nitrogen", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block OXYGEN = register("oxygen", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block FLUORINE = register("fluorine", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NEON = register("neon", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SODIUM = register("sodium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MAGNESIUM = register("magnesium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ALUMINUM = register("aluminum", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SILICON = register("silicon", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PHOSPHORUS = register("phosphorus", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SULFUR = register("sulfur", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CHLORINE = register("chlorine", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ARGON = register("argon", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block POTASSIUM = register("potassium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CALCIUM = register("calcium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SCANDIUM = register("scandium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TITANIUM = register("titanium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block VANADIUM = register("vanadium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CHROMIUM = register("chromium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MANGANESE = register("manganese", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block IRON = register("iron", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block COBALT = register("cobalt", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NICKEL = register("nickel", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block COPPER = register("copper", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ZINC = register("zinc", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block GALLIUM = register("gallium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block GERMANIUM = register("germanium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ARSENIC = register("arsenic", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SELENIUM = register("selenium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BROMINE = register("bromine", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block KRYPTON = register("krypton", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RUBIDIUM = register("rubidium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block STRONTIUM = register("strontium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block YTTRIUM = register("yttrium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ZIRCONIUM = register("zirconium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NIOBIUM = register("niobium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MOLYBDENUM = register("molybdenum", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TECHNETIUM = register("technetium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RUTHENIUM = register("ruthenium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RHODIUM = register("rhodium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PALLADIUM = register("palladium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SILVER = register("silver", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CADMIUM = register("cadmium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block INDIUM = register("indium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TIN = register("tin", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ANTIMONY  = register("antimony", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TELLURIUM = register("tellurium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block IODINE = register("iodine", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block XENON = register("xenon", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CESIUM = register("cesium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BARIUM = register("barium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LANTHANUM = register("lanthanum", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CERIUM = register("cerium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PRASEODYMIUM = register("praseodymium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NEODYMIUM = register("neodymium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PROMETHIUM = register("promethium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SAMARIUM = register("samarium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block EUROPIUM= register("europium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block GADOLINIUM = register("gadolinium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TERBIUM = register("terbium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block DYSPROSIUM = register("dysprosium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block HOLMIUM = register("holmium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ERBIUM = register("erbium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block THULIUM = register("thulium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block YTTERBIUM = register("ytterbium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LUTETIUM = register("lutetium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block HAFNIUM = register("hafnium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TANTALUM = register("tantalum", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TUNGSTEN = register("tungsten", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RHENIUM = register("rhenium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block OSMIUM = register("osmium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block IRIDIUM = register("iridium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PLATINUM = register("platinum", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block GOLD = register("gold", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MERCURY = register("mercury", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block THALLIUM = register("thallium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LEAD = register("lead", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BISMUTH = register("bismuth", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block POLONIUM = register("polonium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ASTATINE = register("astatine", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RADON = register("radon", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block FRANCIUM = register("francium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RADIUM = register("radium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ACTINIUM = register("actinium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block THORIUM = register("thorium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PROTACTINIUM = register("protactinium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block URANIUM = register("uranium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NEPTUNIUM = register("neptunium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block PLUTONIUM = register("plutonium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block AMERICIUM = register("americium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CURIUM = register("curium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BERKELIUM = register("berkelium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block CALIFORNIUM = register("californium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block EINSTEINIUM = register("einsteinium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block FERMIUM = register("fermium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MENDELEVIUM = register("mendelevium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NOBELIUM = register("nobelium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LAWRENCIUM = register("lawrencium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block RUTHERFORDIUM = register("rutherfordium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block DUBNIUM = register("dubnium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block SEABORGIUM = register("seaborgium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block BOHRIUM = register("bohrium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block HASSIUM = register("hassium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MEITNERIUM = register("meitnerium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block DARMSTADTIUM = register("darmstadtium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block ROENTGENIUM = register("roentgenium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block COPERNICIUM = register("copernicium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block NIHONIUM = register("nihonium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block FLEROVIUM = register("flerovium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MOSCOVIUM = register("moscovium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block LIVERMORIUM = register("livermorium", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block TENNESSINE = register("tennessine", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block OGANESSON = register("oganesson", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	public static final Block MYSTERY_ELEMENT = register("mystery_element", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F)));
	

	//Template
	//public static final Block = register("", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0F)));
	
	private static Block register(String name, Block block) {
		return register(name, block, (new Item.Properties()).group(UnusedAssets.education));
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
