package com.themajorn.scullery.common.blocks;

import com.themajorn.scullery.common.tileentities.DesiccatorTileEntity;
import com.themajorn.scullery.core.util.TileEntityTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class DesiccatorBlock extends Block {
    public DesiccatorBlock() {
        super(AbstractBlock.Properties.of(Material.GLASS)
                .sound(SoundType.GLASS)
                .strength(0.2F));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypeInit.DESICCATOR_TILE_ENTITY.get().create();
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brtr) {
        if (!world.isClientSide) {
            TileEntity te = world.getBlockEntity(pos);
            if (te instanceof DesiccatorTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (DesiccatorTileEntity) te, pos);
            }
        }
        return super.use(state, world, pos, player, hand, brtr);
    }
}
