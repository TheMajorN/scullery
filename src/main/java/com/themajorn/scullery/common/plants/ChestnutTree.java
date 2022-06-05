package com.themajorn.scullery.common.plants;

import com.themajorn.scullery.common.biomes.ModConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class ChestnutTree extends Tree {

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random p_225546_1_, boolean p_225546_2_) {
        return ModConfiguredFeatures.CHESTNUT;
    }
}
