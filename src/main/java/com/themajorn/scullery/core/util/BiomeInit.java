package com.themajorn.scullery.core.util;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.biomes.ModConfiguredSurfaceBuilders;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Scullery.MOD_ID);


    // === BIOMES === //

    public static final RegistryObject<Biome> SALT_FLAT = BIOMES.register("salt_flat",
            () -> makeSaltFlatBiome(() -> ModConfiguredSurfaceBuilders.SALT_FLATS, 0.01F, 0.02F));


    // === BIOME MAKERS === //
    private static Biome makeSaltFlatBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();

        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);

        DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);

        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.MESA).depth(depth).scale(scale)
                .temperature(0.8F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).waterColor(11184810).waterFogColor(16777215)
                .fogColor(16777215).skyColor(9093117).build()).mobSpawnSettings(mobspawninfo$builder.build())
                .generationSettings(biomegenerationsettings$builder.build()).build();
    }
}
