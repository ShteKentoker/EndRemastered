package com.ShteKen.endrem.blocks;


import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
public class DiaLight extends Block {


    public DiaLight() {
        super(Block.Properties.create(Material.ROCK)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(2)
        .sound(SoundType.ANVIL)
        );
    }
}


