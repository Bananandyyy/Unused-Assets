package com.gizmo.unusedassets.state.properties;

import net.minecraft.util.IStringSerializable;

public enum Reactor implements IStringSerializable {
	NORMAL("normal"), ACTIVE("active"), DECAYED("decayed");

	private final String name;

	Reactor(String name) {
		this.name = name;
	}

	public String toString() {
		return func_176610_l();
	}

	@Override
	public String func_176610_l() {
		return this.name;
	}
}
