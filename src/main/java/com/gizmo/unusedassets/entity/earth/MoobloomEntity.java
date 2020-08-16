package com.gizmo.unusedassets.entity.earth;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.ai.goal.MoobloomPlaceBlockGoal;
import com.gizmo.unusedassets.entity.earth.base.CowBase;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.fml.network.NetworkHooks;

public class MoobloomEntity extends CowBase<MoobloomEntity> implements IForgeShearable {

	public MoobloomEntity(EntityType<MoobloomEntity> type, World world) {
		super(type, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(8, new MoobloomPlaceBlockGoal(this));
	}

	public boolean isShearable(@Nonnull ItemStack item, World world, BlockPos pos) {
		return this.isAlive() && !this.isChild();
	}

	@Nonnull
	public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @Nonnull ItemStack item,
			World world, BlockPos pos, int fortune) {
		world.playMovingSound(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR,
				player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
		if (!this.world.isRemote) {
			((ServerWorld) this.world).spawnParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosYHeight(0.5D),
					this.getPosZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
			this.remove();
			CowEntity cowentity = EntityType.COW.create(this.world);
			cowentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw,
					this.rotationPitch);
			cowentity.setHealth(this.getHealth());
			cowentity.renderYawOffset = this.renderYawOffset;
			if (this.hasCustomName()) {
				cowentity.setCustomName(this.getCustomName());
				cowentity.setCustomNameVisible(this.isCustomNameVisible());
			}
			if (this.isNoDespawnRequired()) {
				cowentity.enablePersistence();
			}
			cowentity.setInvulnerable(this.isInvulnerable());
			this.world.addEntity(cowentity);
			java.util.List<ItemStack> ret = new java.util.ArrayList<>();
			for (int i = 0; i < 5; ++i) {
				ret.add(new ItemStack(EarthBlocks.BUTTERCUP));
			}
		}
		return java.util.Collections.emptyList();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}