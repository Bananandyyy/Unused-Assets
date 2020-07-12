package com.gizmo.unusedassets.state.properties;

import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;

public class ModBlockStateProperties {
	public static final EnumProperty<Reactor> STATE = EnumProperty.create("state", Reactor.class);

	public static final IntegerProperty GEARPOWER = IntegerProperty.create("gearpower", 0, 1);
	public static final IntegerProperty LAVA_LEVEL = IntegerProperty.create("lava_level", 0, 1);
	public static final IntegerProperty WATER_LEVEL = IntegerProperty.create("water_level", 0, 3);
	public static final IntegerProperty POTION_LEVEL = IntegerProperty.create("potion_level", 0, 1);
	public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light", 0, 15);

}
