package com.themajorn.scullery.common.plants;

import com.themajorn.scullery.common.biomes.ModConfiguredFeatures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

public class ModFlowerGeneration {

    public static void generateFlowers(final BiomeLoadingEvent event) {

        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(event.getName()));
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if (types.contains(BiomeDictionary.Type.PLAINS) || types.contains(BiomeDictionary.Type.FOREST)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.TOP_LAYER_MODIFICATION);
            base.add(() -> ModConfiguredFeatures.BLUEBERRY_CONFIG);
        }

    }

}
