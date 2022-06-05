package com.themajorn.scullery.common.blocks;

import com.themajorn.scullery.core.util.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class CuttingBoardBlock extends Block {

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(1, 0, 2, 13, 1, 12),
            Block.box(14, 0, 2, 15, 1, 12),
            Block.box(13, 0, 2, 14, 1, 5),
            Block.box(13, 0, 9, 14, 1, 12)
            ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(4, 0, 1, 14, 1, 13),
            Block.box(4, 0, 14, 14, 1, 15),
            Block.box(11, 0, 13, 14, 1, 14),
            Block.box(4, 0, 13, 7, 1, 14)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(3, 0, 4, 15, 1, 14),
            Block.box(1, 0, 4, 2, 1, 14),
            Block.box(2, 0, 11, 3, 1, 14),
            Block.box(2, 0, 4, 3, 1, 7)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.box(2, 0, 3, 12, 1, 15),
            Block.box(2, 0, 1, 12, 1, 2),
            Block.box(2, 0, 2, 5, 1, 3),
            Block.box(9, 0, 2, 12, 1, 3)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();


    public CuttingBoardBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HorizontalBlock.FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos p_2pos0053_3_, ISelectionContext context) {
        switch (state.getValue(HorizontalBlock.FACING)) {
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

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(HorizontalBlock.FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(HorizontalBlock.FACING, rotation.rotate(state.getValue(HorizontalBlock.FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(HorizontalBlock.FACING)));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brtr) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() == Items.BEEF && !world.isClientSide) {
            cuttingBoardItemDrop(stack, ItemInit.SLICED_BEEF.get(), 1, brtr, player, world, pos);
        }
        else if (stack.getItem() == ItemInit.DOUGH.get() && !world.isClientSide) {
            cuttingBoardItemDrop(stack, ItemInit.DOUGH_BALLS.get(), 1, brtr, player, world, pos);
        }
        return ActionResultType.sidedSuccess(world.isClientSide);
    }

    public static void cuttingBoardItemDrop(ItemStack itemIn, IItemProvider itemOut, int amount, BlockRayTraceResult brtr, PlayerEntity player, World world, BlockPos pos) {
        itemIn.shrink(1);
        Direction direction = brtr.getDirection();
        Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;
        ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5D + (double)direction2.getStepX() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction2.getStepZ() * 0.65D, new ItemStack(itemOut, amount));
        itemEntity.setDeltaMovement(0.05D * (double)direction2.getStepX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction2.getStepZ() + world.random.nextDouble() * 0.02D);
        world.playSound((PlayerEntity)null, pos, SoundEvents.FUNGUS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.addFreshEntity(itemEntity);
    }
}
