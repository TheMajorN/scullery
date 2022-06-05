package com.themajorn.scullery.common.biomes;

import com.themajorn.scullery.core.util.BiomeInit;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {

    public static void generateBiomes() {
        addBiome(BiomeInit.SALT_FLAT.get(), BiomeManager.BiomeType.DESERT, 20, BiomeDictionary.Type.DRY,
                BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPARSE);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }

}
