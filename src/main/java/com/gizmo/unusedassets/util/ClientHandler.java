package com.gizmo.unusedassets.util;

import com.gizmo.unusedassets.client.entity.render.*;
import com.gizmo.unusedassets.client.entity.render.FishRenderer;
import com.gizmo.unusedassets.client.entity.render.earth.*;
import com.gizmo.unusedassets.client.gui.*;
import com.gizmo.unusedassets.init.UnusedContainers;
import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
@OnlyIn(Dist.CLIENT)
public class ClientHandler {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		ScreenManager.registerFactory(UnusedContainers.ELEMENT_CONSTRUCTOR, ElementScreen::new);
		ScreenManager.registerFactory(UnusedContainers.COMPOUND_CREATOR, CompoundScreen::new);
		ScreenManager.registerFactory(UnusedContainers.MATERIAL_REDUCER, ReducerScreen::new);
		ScreenManager.registerFactory(UnusedContainers.LAB_TABLE, TableScreen::new);
		
		
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.FISH, FishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.PURPLE_ARROW, PurpleArrowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HEART_ARROW, HeartArrowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.STEVE_VILLAGER_HYBRID, SteveVillagerRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.AGENT, AgentRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.LOVE_GOLEM, LoveGolemRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HAPPY_CREEPER, HappyCreeperRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.NAMELESS_ONE, NamelessRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.ALBINO_COW, CowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.AMBER_CHICKEN, ChickenRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.ASHEN_COW, CowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.BONE_SPIDER, BoneSpiderRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.CLUCK_SHROOM, CluckShroomRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.FLECKED_SHEEP, FleckedSheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.FURNACE_GOLEM, FurnaceGolemRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.GLOW_SQUID, GlowSquidRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HARELEQUIN_RABBIT, RabbitRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HORNED_SHEEP, HornedSheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.INKY_SHEEP, InkySheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.JOLLY_LLAMA, JollyLlamaRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.JUMBO_RABBIT, JumboRabbitRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.MELON_GOLEM, MelonGolemRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.MOOBLOOM, MoobloomRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.MUDDY_FOOT_RABBIT, RabbitRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.MUDDY_PIG, MuddyPigRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.PALE_PIG, PigRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.PIEBALD_PIG, PigRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.PINK_PIG, PigRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.ROCKY_SHEEP, RockySheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.SKELE_WOLF, SkeletonWolfRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.SPOTTED_PIG, PigRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.STORMY_CHICKEN, ChickenRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.SUNSET_COW, CowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.TROPICAL_SLIME, TropicalSlimeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.VESTED_RABBIT, RabbitRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.WOOLY_COW, WoolyCowRenderer::new);
		

		
		ClientRegistry.bindTileEntityRenderer(UnusedTileEntities.GEAR, GearRenderer::new);

		
		RenderTypeLookup.setRenderLayer(BedrockBlocks.CYAN_FLOWER, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UnusedBlocks.GEAR, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UnusedBlocks.ROSE, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UnusedBlocks.PAEONIA, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.RED_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.GREEN_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.BLUE_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.PURPLE_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.UNDERWATER_TORCH, RenderType.getCutout());
		
		
	}
	
}