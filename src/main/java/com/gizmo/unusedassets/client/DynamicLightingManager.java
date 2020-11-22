package com.gizmo.unusedassets.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DynamicLightingManager {
	private static final Minecraft MC = Minecraft.getInstance();
	public static final Map<BlockPos, LightData> SOURCES = new ConcurrentHashMap<>();

	public static void tick(LivingEntity entity)
	{
		if (entity != null && MC.player != null && MC.player.ticksExisted % 1.5 == 0)
		{
			if (shouldGlow(entity))
				SOURCES.put(entity.getPosition().up((int) entity.getEyeHeight()), new LightData());

			if (entity == MC.player)
			{
				SOURCES.forEach((blockPos, data) -> MC.world.getChunkProvider().getLightManager().checkBlock(blockPos));
				SOURCES.entrySet().removeIf(entry -> !entry.getValue().shouldStay);
				SOURCES.forEach((blockPos, data) -> data.shouldStay = false);
			}
		}
	}

	public static boolean shouldGlow(LivingEntity entity)
	{
		int maxDist = 128;
		int dist = (int) MC.player.getDistance(entity);
		boolean visible = false;
		if (!visible)
		{
			Vector3d playerPos = new Vector3d(MC.player.getPosX(), MC.player.getPosYEye(), MC.player.getPosZ());
			Vector3d entityPos = new Vector3d(entity.getPosX(), entity.getPosYEye(), entity.getPosZ());
			visible = MC.player.world.rayTraceBlocks(new RayTraceContext(playerPos, entityPos, RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getType() == RayTraceResult.Type.MISS;
		}
		return entity.getType() == UnusedEntities.GLOW_SQUID && (dist <= maxDist || maxDist == 0) && (visible || dist < 24);
	}

	public static void cleanUp()
	{
		if (SOURCES.size() > 0 && MC.world != null)
		{
			SOURCES.forEach((blockPos, data) ->
			{
				data.shouldStay = false;
				MC.world.getChunkProvider().getLightManager().checkBlock(blockPos);
			});
			SOURCES.clear();
		}
	}

	public static class LightData
	{
		public boolean shouldStay = true;
	}
}
