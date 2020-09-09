package com.ShteKen.endrem.lists;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeList {

    public static Biome end_land;

    public static void registerBiomes() {
        registerBiome(end_land, Type.PLAINS, Type.PLATEAU);
    }

    public static void registerBiome(Biome biome, Type... type) {

        BiomeDictionary.addTypes(biome, type);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
    }
}
