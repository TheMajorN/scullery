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

    public DesiccatorScreen(DesiccatorContainer p_i51105_1_, PlayerInventory p_i51105_2_, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, p_i51105_2_, p_i51105_3_);

        this.leftPos = 0;
        this.topPos = 0;
        this.width = 175;
        this.height = 201;
    }

    @Override
    public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, x, y, partialTicks);
        this.renderTooltip(matrixStack, x, y);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int x, int y) {
        this.font.draw(matrixStack, this.inventory.getName(), (float) this.inventoryLabelX,
                (float) this.inventoryLabelY, 4210752);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float p_230450_2_, int mouseX, int mouseY) {
        RenderSystem.color4f(1F, 1F, 1F, 1F);
        this.minecraft.textureManager.bind(DESICCATOR_GUI);
        int x = (this.inventoryLabelX - this.width) / 2;
        int y = (this.inventoryLabelY - this.height) / 2;
        this.blit(matrixStack, x, y, 0, 0, this.width, this.height);
    }
}
