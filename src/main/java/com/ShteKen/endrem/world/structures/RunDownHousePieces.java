package com.ShteKen.endrem.world.structures;

import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.STFeatures;
import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RunDownHousePieces {
    private static final ResourceLocation LEFT_SIDE = new ResourceLocation(EndRemastered.MOD_ID + ":rund_down_house_left_side");
    private static final ResourceLocation RIGHT_SIDE = new ResourceLocation(EndRemastered.MOD_ID + ":rund_down_house_right_side");
    private static final ResourceLocation RIGHT_MIDDLE = new ResourceLocation(EndRemastered.MOD_ID + ":rund_down_house_right_middle");
    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(LEFT_SIDE, new BlockPos(0, 1, 0), RIGHT_SIDE, new BlockPos(0, 1, 0));


    public static void start( TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new RunDownHousePieces.Piece(templateManager, LEFT_SIDE, blockPos, rotation));

        rotationOffSet = new BlockPos(-10, 0, 0).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new RunDownHousePieces.Piece(templateManager, RIGHT_SIDE, blockPos, rotation));

        rotationOffSet = new BlockPos(-10, 0, 0).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new RunDownHousePieces.Piece(templateManager, RIGHT_MIDDLE, blockPos, rotation));
    }

    public static class Piece extends TemplateStructurePiece {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerin, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
            super(STFeatures.RDHP, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockPos = RunDownHousePieces.OFFSET.get(resourceLocation);
            this.templatePosition = pos.add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerin);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(STFeatures.RDHP, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private  void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementSettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementSettings);
        }

        @Override
        protected  void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {

        }
    }
}
