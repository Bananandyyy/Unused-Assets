package com.gizmo.unusedassets.util;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.SoundEvents;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.IItemProvider;

public enum ModArmorMaterial implements IArmorMaterial {
	STUDDED("unusedassets:studded", 10, new int[] { 2, 5, 6, 2 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F,
			() -> Ingredient.fromItems(new IItemProvider[] { (IItemProvider) Items.IRON_INGOT })),
	GOGGLES("unusedassets:goggles", 10, new int[] { 1, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F,
			() -> Ingredient.fromItems(new IItemProvider[] { (IItemProvider) Blocks.AIR })),
	MONITOR("unusedassets:goggles", 10, new int[] { 0, 0, 0, 1 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F,
			() -> Ingredient.fromItems(new IItemProvider[] { (IItemProvider) Blocks.AIR }));

	private static final int[] MAX_DAMAGE_ARRAY;
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;

	static {
		MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	}

	ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn,
			SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionArray = damageReductionAmountIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<Ingredient>(repairMaterialIn);
	}

	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionArray[slotIn.getIndex()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	public Ingredient getRepairMaterial() {
		return (Ingredient) this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}

}
