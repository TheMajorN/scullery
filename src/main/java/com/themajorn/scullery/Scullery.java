package com.themajorn.scullery;

import com.google.common.collect.ImmutableMap;
import com.themajorn.scullery.client.gui.DesiccatorScreen;
import com.themajorn.scullery.client.tileentityrender.DesiccatorTileEntityRenderer;
import com.themajorn.scullery.common.biomes.ModBiomeGeneration;
import com.themajorn.scullery.core.util.*;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Scullery.MOD_ID)
public class Scullery {
    public static final String MOD_ID = "scullery";
    public static final Logger LOGGER = LogManager.getLogger();

    public Scullery() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ContainerTypeInit.CONTAINER_TYPE.register(bus);
        TileEntityTypeInit.TILE_ENTITIES.register(bus);
        BiomeInit.BIOMES.register(bus);
        StructureInit.STRUCTURES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModBiomeGeneration.generateBiomes();
        StructureInit.setupStructures();
        event.enqueueWork(() -> {
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
            .put(BlockInit.OLIVE_LOG.get(), BlockInit.STRIPPED_OLIVE_LOG.get())
            .put(BlockInit.OLIVE_WOOD.get(), BlockInit.STRIPPED_OLIVE_WOOD.get()).build();
        });
        event.enqueueWork(() -> {
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(BlockInit.CHESTNUT_LOG.get(), BlockInit.STRIPPED_CHESTNUT_LOG.get())
                    .put(BlockInit.CHESTNUT_WOOD.get(), BlockInit.STRIPPED_CHESTNUT_WOOD.get()).build();
        });

        LOGGER.info("HEY, MINECRAFT IS WORKING! GOING UP^^^^");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.ROSEMARY.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.THYME.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.PEPPER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.BASIL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.MINT.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.OREGANO.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.BLUEBERRY.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlockInit.OLIVE_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.OLIVE_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.CHESTNUT_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.CHESTNUT_SAPLING.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlockInit.DESICCATOR.get(), RenderType.translucent());

        ScreenManager.register(ContainerTypeInit.DESICCATOR_CONTAINER.get(), DesiccatorScreen::new);

        ClientRegistry.bindTileEntityRenderer(TileEntityTypeInit.DESICCATOR_TILE_ENTITY.get(), DesiccatorTileEntityRenderer::new);
    }
}

/*
TO-DO LIST:

PHASE I
========
Desiccator
========
 */