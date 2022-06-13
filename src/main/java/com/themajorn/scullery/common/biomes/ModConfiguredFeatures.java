package com.themajorn.scullery.common.biomes;

import com.themajorn.scullery.core.util.BlockInit;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> BLUEBERRY_CONFIG = Feature.RANDOM_PATCH.configured((
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.BLUEBERRY.get().defaultBlockState()),
                    SimpleBlockPlacer.INSTANCE).tries(12).build())).decorated(Features.Placements.HEIGHTMAP).count(1);

    // === TREES === //

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OLIVE =
            register("olive", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockInit.OLIVE_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BlockInit.OLIVE_LEAVES.get().defaultBlockState()),
                    new DarkOakFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
                    new DarkOakTrunkPlacer(4, 3, 2),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHESTNUT =
            register("chestnut", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(BlockInit.CHESTNUT_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(BlockInit.CHESTNUT_LEAVES.get().defaultBlockState()),
                            new BlobFoliagePlacer(FeatureSpread.fixed(5), FeatureSpread.fixed(5), 3),
                            new FancyTrunkPlacer(5, 3, 2),
                            new ThreeLayerFeature(3, 1, 0, 1, 1, OptionalInt.empty()))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALMOND =
            register("almond", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(BlockInit.ALMOND_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(BlockInit.ALMOND_LEAVES.get().defaultBlockState()),
                            new MegaPineFoliagePlacer(FeatureSpread.fixed(1), FeatureSpread.fixed(2), FeatureSpread.fixed(3)),
                            new ForkyTrunkPlacer(4, 3, 1),
                            new ThreeLayerFeature(3, 1, 0, 1, 1, OptionalInt.empty()))).ignoreVines().build()));

    // === REGISTER METHOD === //

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> cf) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, cf);
    }
}
