package com.gizmo.unusedassets.entity.earth;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.ai.goal.JollyLlamaEatFernGoal;
import com.gizmo.unusedassets.entity.earth.base.LlamaBase;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LlamaFollowCaravanGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RunAroundLikeCrazyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class JollyLlamaEntity extends LlamaBase<JollyLlamaEntity> {

	private int llamaTimer;
	private JollyLlamaEatFernGoal eatFernGoal;

	public JollyLlamaEntity(EntityType<JollyLlamaEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public boolean func_230277_fr_() {
		return false;
	}

	@Override
	public boolean isArmor(ItemStack stack) {
		return false;
	}

	@Override
	protected void registerGoals() {
		this.eatFernGoal = new JollyLlamaEatFernGoal(this);
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
		this.goalSelector.addGoal(1, new RunAroundLikeCrazyGoal(this, 1.2D));
		this.goalSelector.addGoal(2, new LlamaFollowCaravanGoal(this, (double) 2.1F));
		this.goalSelector.addGoal(3, this.eatFernGoal);
		this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.7D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return func_234234_eJ_().createMutableAttribute(Attributes.FOLLOW_RANGE, 40.0D);
	}

	protected void updateAITasks() {
		this.llamaTimer = this.eatFernGoal.getEatingFernTimer();
		super.updateAITasks();
	}

	public void livingTick() {
		if (this.world.isRemote) {
			this.llamaTimer = Math.max(0, this.llamaTimer - 1);
		}
		super.livingTick();
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.llamaTimer = 40;
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationPointY(float p_70894_1_) {
		if (this.llamaTimer <= 0) {
			return 0.0F;
		} else if (this.llamaTimer >= 4 && this.llamaTimer <= 36) {
			return 1.0F;
		} else {
			return this.llamaTimer < 4 ? ((float) this.llamaTimer - p_70894_1_) / 4.0F
					: -((float) (this.llamaTimer - 40) - p_70894_1_) / 4.0F;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationAngleX(float p_70890_1_) {
		if (this.llamaTimer > 4 && this.llamaTimer <= 36) {
			float f = ((float) (this.llamaTimer - 4) - p_70890_1_) / 32.0F;
			return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
		} else {
			return this.llamaTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
		}
	}

	public void eatGrassBonus() {
		if (this.isChild()) {
			this.addGrowth(60);
		}
	}

	@Override
	@Nullable
	public DyeColor getColor() {
		return null;
	}

}
