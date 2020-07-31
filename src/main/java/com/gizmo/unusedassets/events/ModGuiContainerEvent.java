package com.gizmo.unusedassets.events;

import com.gizmo.unusedassets.client.gui.ModScreen;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraftforge.eventbus.api.Event;

//Forge copy but modified slightly
public class ModGuiContainerEvent extends Event {

	private final ModScreen<?> guiContainer;

    public ModGuiContainerEvent(ModScreen<?> guiContainer)
    {
        this.guiContainer = guiContainer;
    }

    public ModScreen<?> getGuiContainer()
    {
        return guiContainer;
    }

    public static class DrawForeground extends ModGuiContainerEvent
    {
        private final MatrixStack mStack;
        private final int mouseX;
        private final int mouseY;

        public DrawForeground(ModScreen<?> guiContainer, MatrixStack mStack, int mouseX, int mouseY)
        {
            super(guiContainer);
            this.mStack = mStack;
            this.mouseX = mouseX;
            this.mouseY = mouseY;
        }

        public MatrixStack getMatrixStack()
        {
            return mStack;
        }

        public int getMouseX()
        {
            return mouseX;
        }

        public int getMouseY()
        {
            return mouseY;
        }
    }
    
    public static class DrawBackground extends ModGuiContainerEvent
    {
        private final MatrixStack mStack;
        private final int mouseX;
        private final int mouseY;

        public DrawBackground(ModScreen<?> guiContainer, MatrixStack mStack, int mouseX, int mouseY)
        {
            super(guiContainer);
            this.mStack = mStack;
            this.mouseX = mouseX;
            this.mouseY = mouseY;
        }

        public MatrixStack getMatrixStack()
        {
            return mStack;
        }

        public int getMouseX()
        {
            return mouseX;
        }

        public int getMouseY()
        {
            return mouseY;
        }
    }
}