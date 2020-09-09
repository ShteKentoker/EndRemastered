package com.ShteKen.endrem.blocks;

import com.ShteKen.endrem.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import com.ShteKen.endrem.EndRemastered;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.lighting.WorldLightManager;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.Mod;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = EndRemastered.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class EndCreator extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 18, 1, 15, 19, 15), Block.makeCuboidShape(0, 0, 0, 16, 16, 16), Block.makeCuboidShape(1, 16, 1, 15, 17, 15), Block.makeCuboidShape(1, 20, 1, 15, 21, 15), Block.makeCuboidShape(7, 17, 7, 9, 25, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 18, 1, 15, 19, 15), Block.makeCuboidShape(0, 0, 0, 16, 16, 16), Block.makeCuboidShape(1, 16, 1, 15, 17, 15), Block.makeCuboidShape(1, 20, 1, 15, 21, 15), Block.makeCuboidShape(7, 17, 7, 9, 25, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 18, 1, 15, 19, 15), Block.makeCuboidShape(0, 0, 0, 16, 16, 16), Block.makeCuboidShape(1, 16, 1, 15, 17, 15), Block.makeCuboidShape(1, 20, 1, 15, 21, 15), Block.makeCuboidShape(7, 17, 7, 9, 25, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 18, 1, 15, 19, 15), Block.makeCuboidShape(0, 0, 0, 16, 16, 16), Block.makeCuboidShape(1, 16, 1, 15, 17, 15), Block.makeCuboidShape(1, 20, 1, 15, 21, 15), Block.makeCuboidShape(7, 17, 7, 9, 25, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private Object EndPortalBlock;


    public EndCreator() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(4f, 6f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)


        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }

    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }



    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (player.getHeldItemMainhand().getItem() == RegistryHandler.POWERED_CORE.get()) {
            if (!worldIn.isRemote) {

                    worldIn.setBlockState(pos.add(1, 0, 0), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(0, 0, 1), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(1, 0, 1), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(0, 0, -1), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(-1, 0, -1), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(1, 0, -1), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(-1, 0, 1), Blocks.END_PORTAL.getDefaultState());
                    worldIn.setBlockState(pos.add(0, 0, 0), Blocks.END_PORTAL.getDefaultState());

                    worldIn.setBlockState(pos.add(0, 0, 2), Blocks.BEDROCK.getDefaultState());
                    worldIn.setBlockState(pos.add(2, 0, 0), Blocks.BEDROCK.getDefaultState());
                    worldIn.setBlockState(pos.add(-2, 0, 0), Blocks.BEDROCK.getDefaultState());
                    worldIn.setBlockState(pos.add(0, 0, -2), Blocks.BEDROCK.getDefaultState());

                    worldIn.setBlockState(pos.add(1, 0, 2), RegistryHandler.OLD_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(2, 0, 1), RegistryHandler.ROGUE_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(-1, 0, 2), RegistryHandler.NETHER_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(-2, 0, 1), RegistryHandler.COLD_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(-1, 0, -2), RegistryHandler.CORRUPTED_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(-2, 0, -1), RegistryHandler.MAGICAL_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(2, 0, -1), RegistryHandler.BLACK_FRAME.get().getDefaultState());
                    worldIn.setBlockState(pos.add(1, 0, -2), RegistryHandler.LOST_FRAME.get().getDefaultState());


                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        return ActionResultType.CONSUME;

    }
}