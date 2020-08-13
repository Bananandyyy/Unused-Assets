package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

public class WoolyCowEntity extends CowEntity implements IForgeShearable {

	private static final DataParameter<String> COW = EntityDataManager.createKey(WoolyCowEntity.class, DataSerializers.STRING);
	
	public WoolyCowEntity(EntityType<? extends WoolyCowEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	 protected void registerData() {
	      super.registerData();
	      this.dataManager.register(COW, WoolyCowEntity.Type.NORMAL.name);
	   }
	 
	 public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
			ItemStack itemstack = player.getHeldItem(hand);
			if (itemstack.getItem() == Items.SHEARS && !this.isChild() && this.getCowSheared() == WoolyCowEntity.Type.NORMAL) {
				this.setCowSheared(this.getCowSheared() == WoolyCowEntity.Type.NORMAL ? WoolyCowEntity.Type.SHEARED : WoolyCowEntity.Type.NORMAL);
				this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 2, 1);
				this.entityDropItem(Blocks.BROWN_WOOL, 2);
				this.entityDropItem(Blocks.BROWN_WOOL, 2);
				itemstack.damageItem(1, player, (p_213442_1_) -> {
		               player.sendBreakAnimation(hand);
		            });
				return ActionResultType.SUCCESS;
			}
			
			return super.func_230254_b_(player, hand);
			
		}
	 
	private void setCowSheared(WoolyCowEntity.Type typeIn) {
	      this.dataManager.set(COW, typeIn.name);
	   }
	
	public WoolyCowEntity.Type getCowSheared() {
	      return WoolyCowEntity.Type.getTypeByName(this.dataManager.get(COW));
	   }
	
	public void writeAdditional(CompoundNBT compound) {
	      super.writeAdditional(compound);
	      compound.putString("Type", this.getCowSheared().name);
	}
	
	public void readAdditional(CompoundNBT compound) {
	      super.readAdditional(compound);
	      this.setCowSheared(WoolyCowEntity.Type.getTypeByName(compound.getString("Type")));
	}
	
	 public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 10.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.2F);
	   }
	 
	 public static enum Type {
		 SHEARED("sheared"),
		 NORMAL("normal");

		 private final String name;
		 
		 private Type(String nameIn) {
	         this.name = nameIn;
	      }
		 
		 private static WoolyCowEntity.Type getTypeByName(String nameIn) {
	         for(WoolyCowEntity.Type woolycowentity$type : values()) {
	            if (woolycowentity$type.name.equals(nameIn)) {
	               return woolycowentity$type;
	            }
	         }

	         return NORMAL;
	      }
	 }
	 
	 @Override
		public CowEntity func_241840_a(ServerWorld worldIn, AgeableEntity entityIn) {
			return UnusedEntities.WOOLY_COW.create(worldIn);
		}

}
