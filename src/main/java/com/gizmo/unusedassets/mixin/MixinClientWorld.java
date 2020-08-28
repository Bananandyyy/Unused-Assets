package com.gizmo.unusedassets.mixin;

import java.util.Random;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gizmo.unusedassets.blocks.LightBlock;
import com.gizmo.unusedassets.init.UnusedParticles;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

//@Mixin(ClientWorld.class)
public class MixinClientWorld { /*extends World {

	@Shadow
	@Final
	private final Minecraft mc = Minecraft.getInstance();

	 public MixinClientWorld(ClientPlayNetHandler p_i242067_1_, ClientWorld.ClientWorldInfo p_i242067_2_, RegistryKey<World> p_i242067_3_, DimensionType p_i242067_4_, int p_i242067_5_, Supplier<IProfiler> p_i242067_6_, WorldRenderer p_i242067_7_, boolean p_i242067_8_, long p_i242067_9_) {
	      super(p_i242067_2_, p_i242067_3_, p_i242067_4_, p_i242067_6_, true, p_i242067_8_, p_i242067_9_);
	 }
	 
	@Inject(method = "animateTick(Ljava/util/random;Lnet/minecraft/util/math/BlockPos/Mutable)", at = @At("RETURN"))
    private void animateTick(int x, int y, int z, int offset, Random random, boolean spawnBarrierParticles, BlockPos.Mutable pos, CallbackInfo ci) {
        int i = x + this.rand.nextInt(offset) - this.rand.nextInt(offset);
        int j = y + this.rand.nextInt(offset) - this.rand.nextInt(offset);
        int k = z + this.rand.nextInt(offset) - this.rand.nextInt(offset);
        pos.setPos(i, j, k);
        BlockState blockState = this.getBlockState(pos);
        assert this.mc.player != null;
        //TODO: what is this function?
        this.mc.player.func_230297_ef_().forEach(itemStack -> {
            if (itemStack.equals(BedrockBlocks.LIGHT_0.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_1.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_2.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_3.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_4.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_5.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_6.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_7.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_8.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_9.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_10.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_11.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_12.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_13.asItem()) ||
                itemStack.equals(BedrockBlocks.LIGHT_14.asItem()) || itemStack.equals(BedrockBlocks.LIGHT_15.asItem())) {
                if (blockState.getBlock() == BedrockBlocks.LIGHT_0 || blockState.getBlock() == BedrockBlocks.LIGHT_1 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_2 || blockState.getBlock() == BedrockBlocks.LIGHT_3 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_4 || blockState.getBlock() == BedrockBlocks.LIGHT_5 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_6 || blockState.getBlock() == BedrockBlocks.LIGHT_7 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_8 || blockState.getBlock() == BedrockBlocks.LIGHT_9 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_10 || blockState.getBlock() == BedrockBlocks.LIGHT_11 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_12 || blockState.getBlock() == BedrockBlocks.LIGHT_13 ||
                    blockState.getBlock() == BedrockBlocks.LIGHT_14 || blockState.getBlock() == BedrockBlocks.LIGHT_15) {
                    switch (blockState.get(LightBlock.LIGHT)) {
                        case 0:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_0, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 1:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_1, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 2:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_2, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 3:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_3, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 4:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_4, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 5:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_5, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 6:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_6, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 7:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_7, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 8:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_8, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 9:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_9, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 10:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_10, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 11:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_11, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 12:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_12, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 13:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_13, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 14:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_14, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 15:
                            this.addParticle(UnusedParticles.LIGHT_PARTICLE_15, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                    }
                }
            }
        });*/

}



