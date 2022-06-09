package com.themajorn.scullery.client.tileentityrender;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.themajorn.scullery.common.tileentities.DesiccatorTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class DesiccatorTileEntityRenderer extends TileEntityRenderer<DesiccatorTileEntity> {

    private Minecraft mc = Minecraft.getInstance();

    public DesiccatorTileEntityRenderer(TileEntityRendererDispatcher terd) {
        super(terd);
    }

    @Override
    public void render(DesiccatorTileEntity dte, float p_225616_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int p_225616_5_, int p_225616_6_) {
        if (dte.getItem().equals(ItemStack.EMPTY)) { return; }

        ClientPlayerEntity player = mc.player;
        int lightLevel = getLightLevel(dte.getLevel(), dte.getBlockPos().above());
        renderItem(dte.getItem(), new double[] {0.5D, 1D, 0.5D}, Vector3f.YP.rotationDegrees(180F - player.yRot), matrixStack, buffer, p_225616_2_, p_225616_5_, lightLevel, 0.8F);
    }

    private void renderItem(ItemStack stack, double[] translation, Quaternion rotation, MatrixStack matrixStack,
                            IRenderTypeBuffer buffer, float partialTicks, int combinedOverlay, int lightLevel, float scale) {
        matrixStack.pushPose();
        matrixStack.translate(translation[0], translation[1], translation[2]);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale, scale, scale);

        IBakedModel model = mc.getItemRenderer().getModel(stack, null, null);
        mc.getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, lightLevel, combinedOverlay, model);
        matrixStack.popPose();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getBrightness(LightType.BLOCK, pos);
        int sLight = world.getBrightness(LightType.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
