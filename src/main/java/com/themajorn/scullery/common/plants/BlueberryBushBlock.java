package com.themajorn.scullery.common.plants;

import com.themajorn.scullery.core.util.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlueberryBushBlock extends BushBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public BlueberryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext selectionContext) {
        if (state.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, blockReader, pos, selectionContext);
        }
    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader reader, BlockPos pos, BlockState state) {
        return new ItemStack(ItemInit.BLUEBERRY.get());
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld serverWorld, BlockPos pos, Random random) {
        int i = state.getValue(AGE);
        if (i < 3 && serverWorld.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverWorld, pos, state,random.nextInt(5) == 0)) {
            serverWorld.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverWorld, pos, state);
        }
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brtr) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            popResource(world, pos, new ItemStack(ItemInit.BLUEBERRY.get(), j + (flag ? 1 : 0)));
            world.playSound((PlayerEntity)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlock(pos, state.setValue(AGE, 1), 2);
            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, pos, player, hand, brtr);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> state) {
        state.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return blockState.getValue(AGE) < 3;
    }

    @Override
    public boolean isBonemealSuccess(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {
        int i = Math.min(3, blockState.getValue(AGE) + 1);
        serverWorld.setBlock(blockPos, blockState.setValue(AGE, i), 2);
    }
}
