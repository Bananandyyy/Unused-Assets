package com.gizmo.unusedassets.entity.earth;

import javax.annotation.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IForgeShearable;

public abstract class SingleColoredSheepEntity extends AnimalEntity implements IForgeShearable {

	private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(SheepEntity.class,
			DataSerializers.BYTE);

	private EatGrassGoal eatGrassGoal;
	private int sheepTimer;

	protected SingleColoredSheepEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void updateAITasks() {
		this.sheepTimer = this.eatGrassGoal.getEatingGrassTimer();
		super.updateAITasks();
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(DYE_COLOR, (byte) 0);
	}

	public void livingTick() {
		if (this.world.isRemote) {
			this.sheepTimer = Math.max(0, this.sheepTimer - 1);
		}

		super.livingTick();
	}
	
	@OnlyIn(Dist.CLIENT)
	   public float getHeadRotationPointY(float p_70894_1_) {
	      if (this.sheepTimer <= 0) {
	         return 0.0F;
	      } else if (this.sheepTimer >= 4 && this.sheepTimer <= 36) {
	         return 1.0F;
	      } else {
	         return this.sheepTimer < 4 ? ((float)this.sheepTimer - p_70894_1_) / 4.0F : -((float)(this.sheepTimer - 40) - p_70894_1_) / 4.0F;
	      }
	   }

	   @OnlyIn(Dist.CLIENT)
	   public float getHeadRotationAngleX(float p_70890_1_) {
	      if (this.sheepTimer > 4 && this.sheepTimer <= 36) {
	         float f = ((float)(this.sheepTimer - 4) - p_70890_1_) / 32.0F;
	         return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
	      } else {
	         return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
	      }
	   }

	protected void registerGoals() {
		this.eatGrassGoal = new EatGrassGoal(this);
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, this.eatGrassGoal);
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F);
	   }

	@SuppressWarnings("unused")
	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
		if (false && itemstack.getItem() == Items.SHEARS) {
			if (!this.world.isRemote && this.func_230262_K__()) {
				this.func_230263_a_(SoundCategory.PLAYERS);
				itemstack.damageItem(1, p_230254_1_, (p_213613_1_) -> {
					p_213613_1_.sendBreakAnimation(p_230254_2_);
				});
				return ActionResultType.SUCCESS;
			} else {
				return ActionResultType.CONSUME;
			}
		} else {
			return super.func_230254_b_(p_230254_1_, p_230254_2_);
		}
	}

	public void func_230263_a_(SoundCategory p_230263_1_) {
		this.world.playMovingSound((PlayerEntity) null, this, SoundEvents.ENTITY_SHEEP_SHEAR, p_230263_1_, 1.0F, 1.0F);
		this.setSheared(true);
		int i = 1 + this.rand.nextInt(3);

		for (int j = 0; j < i; ++j) {
			ItemEntity itementity = this.entityDropItem(Blocks.WHITE_WOOL, 1);
			if (itementity != null) {
				itementity.setMotion(
						itementity.getMotion().add((double) ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F),
								(double) (this.rand.nextFloat() * 0.05F),
								(double) ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F)));
			}
		}

	}

	public boolean func_230262_K__() {
		return this.isAlive() && !this.getSheared() && !this.isChild();
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Sheared", this.getSheared());
	}

	public void eatGrassBonus() {
		this.setSheared(false);
		if (this.isChild()) {
			this.addGrowth(60);
		}

	}

	public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
		return func_230262_K__();
	}

	@javax.annotation.Nonnull
	public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item,
			World world, BlockPos pos, int fortune) {
		world.playMovingSound(null, this, SoundEvents.ENTITY_SHEEP_SHEAR,
				player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
		if (!world.isRemote) {
			this.setSheared(true);
			int i = 1 + this.rand.nextInt(3);

			java.util.List<ItemStack> items = new java.util.ArrayList<>();
			for (int j = 0; j < i; ++j) {
				items.add(new ItemStack(Blocks.WHITE_WOOL));
			}
			return items;
		}
		return java.util.Collections.emptyList();
	}

	public boolean getSheared() {
		return (this.dataManager.get(DYE_COLOR) & 16) != 0;
	}

	public void setSheared(boolean sheared) {
		byte b0 = this.dataManager.get(DYE_COLOR);
		if (sheared) {
			this.dataManager.set(DYE_COLOR, (byte) (b0 | 16));
		} else {
			this.dataManager.set(DYE_COLOR, (byte) (b0 & -17));
		}

	}

}
