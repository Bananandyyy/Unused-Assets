package com.gizmo.unusedassets.entity.projectile;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class MelonSeedProjectileEntity extends ProjectileItemEntity {

	public MelonSeedProjectileEntity(EntityType<? extends MelonSeedProjectileEntity> type, World world) {
	      super(type, world);
	   }

    public MelonSeedProjectileEntity(World worldIn, LivingEntity throwerIn) {
        super(UnusedEntities.MELON_SEED_PROJECTILE, throwerIn, worldIn);
    }

    public MelonSeedProjectileEntity(World worldIn, double x, double y, double z) {
        super(UnusedEntities.MELON_SEED_PROJECTILE, x, y, z, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.MELON_SEEDS;
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
       if (id == 3) {
          double d0 = 0.08D;

          for(int i = 0; i < 8; ++i) {
             this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getPosX(), this.getPosY(), this.getPosZ(), ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D);
          }
       }

    }

    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 3F);
    }
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}