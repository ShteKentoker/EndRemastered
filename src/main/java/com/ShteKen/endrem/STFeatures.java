package com.ShteKen.endrem;



import com.ShteKen.endrem.world.structures.RunDownHousePieces;
import com.ShteKen.endrem.world.structures.RunDownHouseStructure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.event.RegistryEvent;


import java.util.Locale;

public class STFeatures {

    public static Structure<NoFeatureConfig> RUN_DOWN_HOUSE = new RunDownHouseStructure(NoFeatureConfig.field_236558_a_);
    public static IStructurePieceType RDHP = RunDownHousePieces.Piece::new;

    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        registerStructure(
                new ResourceLocation(EndRemastered.MOD_ID, "run_down_house"),
                RUN_DOWN_HOUSE,
                GenerationStage.Decoration.SURFACE_STRUCTURES,
                new StructureSeparationSettings(10, 5, 23489323), true);
        STFeatures.registerAllPieces();
    }

    public static <F extends Structure<NoFeatureConfig>> void registerStructure(
            ResourceLocation resourceLocation,
            F structure,
            GenerationStage.Decoration stage,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand) {



        structure.setRegistryName(resourceLocation);
        addToStructureInfoMaps(resourceLocation.toString(), structure, stage);

        if (transformSurroundingLand) {
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.field_236384_t_)
                            .add(structure)
                            .build();
        }
        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();

        DimensionSettings.Preset.OVERWORLD.getSettings().getStructures().func_236195_a_().put(structure, structureSeparationSettings);
        DimensionSettings.Preset.FLOATING_ISLANDS.getSettings().getStructures().func_236195_a_().put(structure, structureSeparationSettings);
        DimensionSettings.Preset.AMPLIFIED.getSettings().getStructures().func_236195_a_().put(structure, structureSeparationSettings);
        DimensionSettings.Preset.CAVES.getSettings().getStructures().func_236195_a_().put(structure, structureSeparationSettings);
    }

    private static <F extends Structure<?>> F addToStructureInfoMaps(String name, F structure, GenerationStage.Decoration generationStage) {
        Structure.field_236365_a_.put(name.toLowerCase(Locale.ROOT), structure);
        Structure.field_236385_u_.put(structure, generationStage);
        return Registry.register(Registry.STRUCTURE_FEATURE, name.toLowerCase(Locale.ROOT), structure);

    }
    public static void registerAllPieces() {
        registerStructurePiece(RDHP, "RDHP");
    }
    static IStructurePieceType registerStructurePiece(IStructurePieceType structurePiece, String key) {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
    }
}
