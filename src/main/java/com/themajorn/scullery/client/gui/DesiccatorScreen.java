package com.themajorn.scullery.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.containers.DesiccatorContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class DesiccatorScreen extends ContainerScreen<DesiccatorContainer> {

    private static final ResourceLocation DESICCATOR_GUI = new ResourceLocation(Scullery.MOD_ID,
            "textures/gui/desiccator.png");

    public DesiccatorScreen(DesiccatorContainer desiccatorContainer, PlayerInventory playerInv, ITextComponent iTextComponent) {
        super(desiccatorContainer, playerInv, iTextComponent);
    }

    @Override
    public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, x, y, partialTicks);
        this.renderTooltip(matrixStack, x, y);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float p_230450_2_, int mouseX, int mouseY) {
        RenderSystem.color4f(1F, 1F, 1F, 1F);
        this.minecraft.getTextureManager().bind(DESICCATOR_GUI);
        int i = this.leftPos;
        int j = this.topPos + 2;
        this.blit(matrixStack, i, j, 0, 0, this.width, this.height);
    }
}
