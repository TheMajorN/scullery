package com.themajorn.scullery.common.plants;

import com.themajorn.scullery.common.biomes.ModConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class OliveTree extends Tree {

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean b) {
        return ModConfiguredFeatures.OLIVE;
    }
}
