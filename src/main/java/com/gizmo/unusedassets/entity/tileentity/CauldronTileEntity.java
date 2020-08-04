package com.gizmo.unusedassets.entity.tileentity;

import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.util.actions.CauldronActions;
import com.gizmo.unusedassets.util.actions.ICauldronAction;
import com.gizmo.unusedassets.util.fabric.FluidBlockRendererRegistry;
import com.gizmo.unusedassets.util.transformers.CauldronTileEntityTransformer;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CauldronTileEntity extends TileEntity implements ITickableTileEntity {

	public Fluid fluid;
	public int level_numerator;
	public int level_denominator;

	public boolean dyed;
	public int dyeColor;

	public ItemStack ingredient;
	public int timeLeft;
	public int brewTimeLeft;

	public CauldronTileEntity() {
		super(UnusedTileEntities.CAULDRON);
		this.fluid = Fluids.EMPTY;
		this.level_numerator = 0;
		this.dyed = false;
//		this.dyeColor = FluidBlockRendererRegistry.INSTANCE.get(Fluids.WATER).getFluidColor(null, null, Fluids.WATER.getDefaultState());
		this.level_denominator = 1;
		this.ingredient = ItemStack.EMPTY;
		this.timeLeft = 0;
		this.brewTimeLeft = 0;
	}

	public void fromClientTag(CompoundNBT compoundnbt) {
		this.level_numerator = compoundnbt.getInt("numerator");
		this.level_denominator = compoundnbt.getInt("denominator");

		if (this.level_numerator > this.level_denominator)
			this.level_numerator = this.level_denominator;
//TODO fix this to include all liquids? Idk
		this.fluid = Fluids.WATER;

		this.dyed = compoundnbt.getBoolean("dyed");
		this.dyeColor = compoundnbt.getInt("dyeColor");

		this.ingredient = ItemStack.read(compoundnbt.getCompound("ingredient"));
		this.timeLeft = compoundnbt.getInt("timeLeft");
		this.brewTimeLeft = compoundnbt.getInt("brewTimeLeft");
	}

	public void fromTag(BlockState state, CompoundNBT compoundnbt) {
		super.handleUpdateTag(state, compoundnbt);
		this.level_numerator = compoundnbt.getInt("numerator");
		this.level_denominator = compoundnbt.getInt("denominator");

		if (this.level_numerator > this.level_denominator)
			this.level_numerator = this.level_denominator;
//TODO same as above
		this.fluid = Fluids.WATER;

		this.dyed = compoundnbt.getBoolean("dyed");
		this.dyeColor = compoundnbt.getInt("dyeColor");

		this.ingredient = ItemStack.read(compoundnbt.getCompound("ingredient"));
		this.timeLeft = compoundnbt.getInt("timeLeft");
		this.brewTimeLeft = compoundnbt.getInt("brewTimeLeft");
	}

	public CompoundNBT toClientTag(CompoundNBT compoundnbt) {
		compoundnbt.putInt("numerator", this.level_numerator);
		compoundnbt.putInt("denominator", this.level_denominator);
		compoundnbt.putLong("fluid", Registry.FLUID.getId(this.fluid));
		compoundnbt.putBoolean("dyed", this.dyed);
		compoundnbt.putInt("dyeColor", this.dyeColor);

		CompoundNBT ingredientTag = new CompoundNBT();
		this.ingredient.setTag(ingredientTag);
		compoundnbt.put("ingredient", ingredientTag);
		compoundnbt.putInt("timeLeft", this.timeLeft);
		compoundnbt.putInt("brewTimeLeft", this.brewTimeLeft);
		return compoundnbt;
	}

	public CompoundNBT toTag(CompoundNBT compoundnbt) {
		super.getUpdateTag();
		compoundnbt.putInt("numerator", this.level_numerator);
		compoundnbt.putInt("denominator", this.level_denominator);
		compoundnbt.putLong("fluid", Registry.FLUID.getId(this.fluid));
		compoundnbt.putBoolean("dyed", this.dyed);
		compoundnbt.putInt("dyeColor", this.dyeColor);

		CompoundNBT ingredientTag = new CompoundNBT();
		this.ingredient.setTag(ingredientTag);
		compoundnbt.put("ingredient", ingredientTag);
		compoundnbt.putInt("timeLeft", this.timeLeft);
		compoundnbt.putInt("brewTimeLeft", this.brewTimeLeft);
		return compoundnbt;
	}

	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player,
			Hand hand, BlockRayTraceResult hit, ItemStack itemStack) {
		for (ICauldronAction action : CauldronActions.getCauldronActions()) {
			ActionResultType result = action.onBlockActivated(this, world, pos, player, hand);
			if (!result.equals(ActionResultType.PASS)) {
				if (!world.isRemote)
					this.validate();
				return result;
			}
		}
		return ActionResultType.PASS;
	}

	public void setLevel(int level) {
		this.level_numerator = level;
		if (this.level_numerator == 0) {
			this.fluid = Fluids.EMPTY;
		}
	}

	private void findNearestCommon(int denom) {
		int newdenom = 0;
		if (level_denominator % denom == 0) {
			newdenom = level_denominator;
		} else if (denom % level_denominator == 0) {
			newdenom = denom;
		} else {
			newdenom = level_denominator * denom;
		}

		int mult = newdenom / level_denominator;
		this.level_numerator *= mult;
		this.level_denominator = newdenom;
	}

	public boolean drain(int numerator, int denominator, boolean simulate) {
		findNearestCommon(denominator);
		if (denominator != this.level_denominator) {
			numerator *= ((double) this.level_denominator / denominator);
		}
		if (this.level_numerator < numerator)
			return false;
		if (!simulate) {
			this.level_numerator -= numerator;
			if (this.level_numerator == 0) {
				this.fluid = Fluids.EMPTY;
				this.dyed = false;
				this.dyeColor = FluidBlockRendererRegistry.INSTANCE.get(Fluids.WATER).getFluidColor(this.getWorld(),
						this.getPos(), Fluids.WATER.getDefaultState());
			}
		}
		return true;
	}

	public boolean fill(int numerator, int denominator, Fluid fluid, boolean simulate) {
		findNearestCommon(denominator);
		if (denominator != this.level_denominator) {
			numerator *= ((double) this.level_denominator / denominator);
		}
		if (this.fluid != fluid && this.fluid != Fluids.EMPTY)
			return false;
		if (this.level_denominator < this.level_numerator + numerator)
			return false;
		if (!simulate) {
			this.level_numerator += numerator;
			this.fluid = fluid;
		}
		return true;
	}

	public boolean takeBottle(boolean simulate) {
		return this.drain(1, 3, simulate);
	}

	public boolean insertBottle(Fluid fluid, boolean simulate) {
		return this.fill(1, 3, fluid, simulate);
	}

	@Override
	public void tick() {
		CauldronTileEntityTransformer.onTick(this, this.world, this.pos);
	}

}
