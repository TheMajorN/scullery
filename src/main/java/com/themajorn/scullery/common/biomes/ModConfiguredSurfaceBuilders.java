package com.themajorn.scullery.common.biomes;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.core.util.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> SALT_FLATS = register("salt_flats",
            SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                    BlockInit.SALT_BLOCK.get().defaultBlockState(),
                    Blocks.STONE.defaultBlockState(),
                    Blocks.STONE.defaultBlockState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(Scullery.MOD_ID, name), csb);
    }

}
