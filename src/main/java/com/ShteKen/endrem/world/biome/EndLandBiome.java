package com.ShteKen.endrem.world.biome;

import com.ShteKen.endrem.events.RegisterEventHandler;
import com.ShteKen.endrem.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class EndLandBiome extends Biome {
    public EndLandBiome() {
        super(new Biome.Builder()
                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.END_STONE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
                .precipitation(RainType.NONE)
                .category(Category.PLAINS)
                .downfall(0.0f)
                .depth(0.7f)
                .temperature(0.5f)
                .scale(0.5f)
                .downfall(0.6f)
                .func_235097_a_((new BiomeAmbience.Builder())
                        .setWaterColor(7209119)
                        .setWaterFogColor(7209119)
                        .setFogColor(12638463)
                        .setMoodSound(MoodSoundAmbience.field_235027_b_)
                        .build())
                .parent(null));

                this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BLAZE, 100, 3, 8));

                this.setRegistryName(RegisterEventHandler.location("end_land"));
    }
}
