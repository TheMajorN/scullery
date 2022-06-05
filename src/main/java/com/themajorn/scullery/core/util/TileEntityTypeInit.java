package com.themajorn.scullery.core.util;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.tileentities.DesiccatorTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(
            ForgeRegistries.TILE_ENTITIES, Scullery.MOD_ID);

    public static final RegistryObject<TileEntityType<DesiccatorTileEntity>> DESICCATOR_TILE_ENTITY = TILE_ENTITIES
            .register("desiccator", () -> TileEntityType.Builder.of(
                    DesiccatorTileEntity::new, BlockInit.DESICCATOR.get()).build(null));

}
