package com.ShteKen.endrem.items;

import com.ShteKen.endrem.EndRemastered;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.EyeOfEnderEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class EnderEyeR extends EnderEyeItem {
    public EnderEyeR() {
        super(new Item.Properties().group(EndRemastered.TAB));
    }
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.isIn(Blocks.AIR) && !blockstate.get(EndPortalFrameBlock.EYE)) {
            if (world.isRemote) {
                return ActionResultType.FAIL;
            } else {
                BlockState blockstate1 = blockstate.with(EndPortalFrameBlock.EYE, Boolean.valueOf(true));
                Block.nudgeEntitiesWithNewState(blockstate, blockstate1, world, blockpos);
                world.setBlockState(blockpos, blockstate1, 2);
                world.updateComparatorOutputLevel(blockpos, Blocks.AIR);
                context.getItem().shrink(1);
                world.playEvent(1503, blockpos, 0);
                BlockPattern.PatternHelper blockpattern$patternhelper = EndPortalFrameBlock.getOrCreatePortalShape().match(world, blockpos);
                if (blockpattern$patternhelper != null) {
                    BlockPos blockpos1 = blockpattern$patternhelper.getFrontTopLeft().add(-3, 0, -3);

                    for(int i = 0; i < 3; ++i) {
                        for(int j = 0; j < 3; ++j) {
                            world.setBlockState(blockpos1.add(i, 0, j), Blocks.END_PORTAL.getDefaultState(), 2);
                        }
                    }

                    world.playBroadcastSound(1038, blockpos1.add(1, 0, 1), 0);
                }

                return ActionResultType.FAIL;
            }
        } else {
            return ActionResultType.PASS;
        }
    }

}
