package com.gizmo.unusedassets.mixin;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import com.gizmo.unusedassets.blocks.LightBlock;
import com.gizmo.unusedassets.init.UnusedParticles;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.AbstractChunkProvider;

//@Mixin(ClientWorld.class)
/*public abstract class MixinClientWorld extends World {

	@Shadow
	@Final
	private List<AbstractClientPlayerEntity> players;

	@Shadow
	@Final
	private Minecraft client;

	protected MixinClientWorld(WorldInfo info, DimensionType dimType,
			BiFunction<World, Dimension, AbstractChunkProvider> provider, IProfiler profilerIn, boolean remote) {
		super(info, dimType, provider, profilerIn, remote);
	}
	
	@Inject(method = "animateTick", at = @At("RETURN"))
    public void animateTick(int x, int y, int z, int offset, Random random, boolean holdingLightBlock, BlockPos.Mutable pos) {
        int i = x + this.rand.nextInt(offset) - this.rand.nextInt(offset);
        int j = y + this.rand.nextInt(offset) - this.rand.nextInt(offset);
        int k = z + this.rand.nextInt(offset) - this.rand.nextInt(offset);
        pos.setPos(i, j, k);
        BlockState blockstate = this.getBlockState(pos);
        blockstate.getBlock().animateTick(blockstate, this, pos, random);
        ItemStack Held = client.player.getHeldItemMainhand();

        if(holdingLightBlock) {
		
			if (blockstate.getBlock() == BedrockBlocks.LIGHT_0 || blockstate.getBlock() == BedrockBlocks.LIGHT_1
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_2 || blockstate.getBlock() == BedrockBlocks.LIGHT_3
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_4 || blockstate.getBlock() == BedrockBlocks.LIGHT_5
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_6 || blockstate.getBlock() == BedrockBlocks.LIGHT_7
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_8 || blockstate.getBlock() == BedrockBlocks.LIGHT_9
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_10 || blockstate.getBlock() == BedrockBlocks.LIGHT_11
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_12 || blockstate.getBlock() == BedrockBlocks.LIGHT_13
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_14
					|| blockstate.getBlock() == BedrockBlocks.LIGHT_15) {
				switch (blockstate.get(LightBlock.LIGHT)) {
				case 0:
					this.addParticle(UnusedParticles.lightParticle_0, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 1:
					this.addParticle(UnusedParticles.lightParticle_1, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 2:
					this.addParticle(UnusedParticles.lightParticle_2, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 3:
					this.addParticle(UnusedParticles.lightParticle_3, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 4:
					this.addParticle(UnusedParticles.lightParticle_4, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 5:
					this.addParticle(UnusedParticles.lightParticle_5, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 6:
					this.addParticle(UnusedParticles.lightParticle_6, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 7:
					this.addParticle(UnusedParticles.lightParticle_7, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 8:
					this.addParticle(UnusedParticles.lightParticle_8, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 9:
					this.addParticle(UnusedParticles.lightParticle_9, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 10:
					this.addParticle(UnusedParticles.lightParticle_10, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 11:
					this.addParticle(UnusedParticles.lightParticle_11, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 12:
					this.addParticle(UnusedParticles.lightParticle_12, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 13:
					this.addParticle(UnusedParticles.lightParticle_13, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 14:
					this.addParticle(UnusedParticles.lightParticle_14, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				case 15:
					this.addParticle(UnusedParticles.lightParticle_15, (double) i + 0.5D, (double) j + 0.5D,
							(double) k + 0.5D, 0.0D, 0.0D, 0.0D);
					break;
				}
			}
		}
	}
	
}*/

