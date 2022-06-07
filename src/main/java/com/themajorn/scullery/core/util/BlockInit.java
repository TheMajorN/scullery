package com.themajorn.scullery.core.util;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.blocks.CuttingBoardBlock;
import com.themajorn.scullery.common.blocks.DesiccatorBlock;
import com.themajorn.scullery.common.blocks.GrainMillBlock;
import com.themajorn.scullery.common.plants.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Scullery.MOD_ID);

    // === BLOCKS === //

    public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)
            .strength(1.0F).requiresCorrectToolForDrops()));


    // === PLANTS === //

    public static final RegistryObject<Block> BLUEBERRY = BLOCKS.register("blueberry_crop",
            () -> new BlueberryBushBlock(AbstractBlock.Properties.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final RegistryObject<Block> ROSEMARY = BLOCKS.register("rosemary_crop",
            () -> new RosemaryBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING)));

    public static final RegistryObject<Block> THYME = BLOCKS.register("thyme_crop",
            () -> new ThymeBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING)));

    public static final RegistryObject<Block> PEPPER = BLOCKS.register("pepper_crop",
            () -> new PepperBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING)));

    public static final RegistryObject<Block> BASIL = BLOCKS.register("basil_crop",
            () -> new BasilBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING)));

    public static final RegistryObject<Block> MINT = BLOCKS.register("mint_crop",
            () -> new MintBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING)));

    public static final RegistryObject<Block> OREGANO = BLOCKS.register("oregano_crop",
            () -> new OreganoBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING)));

    // === TREES === //

    public static final RegistryObject<Block> OLIVE_LOG = BLOCKS.register("olive_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> OLIVE_WOOD = BLOCKS.register("olive_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = BLOCKS.register("stripped_olive_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = BLOCKS.register("stripped_olive_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> OLIVE_PLANK = BLOCKS.register("olive_plank",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> OLIVE_LEAVES = BLOCKS.register("olive_leaves",
            () -> new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> OLIVE_SAPLING = BLOCKS.register("olive_sapling",
            () -> new SaplingBlock(new OliveTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CHESTNUT_LOG = BLOCKS.register("chestnut_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CHESTNUT_WOOD = BLOCKS.register("chestnut_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_CHESTNUT_LOG = BLOCKS.register("stripped_chestnut_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_CHESTNUT_WOOD = BLOCKS.register("stripped_chestnut_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> CHESTNUT_PLANK = BLOCKS.register("chestnut_plank",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CHESTNUT_LEAVES = BLOCKS.register("chestnut_leaves",
            () -> new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> CHESTNUT_SAPLING = BLOCKS.register("chestnut_sapling",
            () -> new SaplingBlock(new ChestnutTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> ALMOND_LOG = BLOCKS.register("almond_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> ALMOND_WOOD = BLOCKS.register("almond_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_ALMOND_LOG = BLOCKS.register("stripped_almond_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_ALMOND_WOOD = BLOCKS.register("stripped_almond_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> ALMOND_PLANK = BLOCKS.register("almond_plank",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> ALMOND_LEAVES = BLOCKS.register("almond_leaves",
            () -> new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> ALMOND_SAPLING = BLOCKS.register("almond_sapling",
            () -> new SaplingBlock(new AlmondTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));



    // === APPLIANCES === //

    public static final RegistryObject<Block> CUTTING_BOARD = BLOCKS.register("cutting_board",
            () -> new CuttingBoardBlock(AbstractBlock.Properties.of(Material.WOOD).instabreak()));

    public static final RegistryObject<Block> GRAIN_MILL = BLOCKS.register("grain_mill",
            () -> new GrainMillBlock(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> DESICCATOR = BLOCKS.register("desiccator",
            () -> new DesiccatorBlock(AbstractBlock.Properties.of(Material.GLASS)));

}
