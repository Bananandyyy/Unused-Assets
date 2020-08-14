package com.gizmo.unusedassets.state.properties;

import net.minecraft.util.IStringSerializable;

public enum Reactor implements IStringSerializable {
	NORMAL("normal"), ACTIVE("active"), DECAYED("decayed");

	private final String name;

	Reactor(String name) {
		this.name = name;
	}

	public String toString() {
		return getString();
	}

	@Override
	public String getString() {
		return this.name;
	}
}
