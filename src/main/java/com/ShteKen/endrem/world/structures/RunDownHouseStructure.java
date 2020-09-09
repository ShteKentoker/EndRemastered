package com.ShteKen.endrem.world.structures;

import com.ShteKen.endrem.EndRemastered;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;

import java.util.List;

public class RunDownHouseStructure extends Structure<NoFeatureConfig> {
    public RunDownHouseStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public String getStructureName() {
        return EndRemastered.MOD_ID + ":run_down_house";
    }
    @Override
    public Structure.IStartFactory getStartFactory() {
        return RunDownHouseStructure.Start::new;
    }

    public static class Start extends StructureStart {
        public Start(Structure<?> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int refecrenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, refecrenceIn, seedIn);
        }

        @Override
        public void func_230364_a_(ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, IFeatureConfig config) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            int surfaceY = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos blockpos = new BlockPos(x, surfaceY, z);

            RunDownHousePieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);

            this.recalculateStructureSize();

            EndRemastered.LOGGER.log(Level.DEBUG, "Runddown House at " + (blockpos.getX()) + " " + blockpos.getY() + " " + (blockpos.getZ()));

        }
    }


}