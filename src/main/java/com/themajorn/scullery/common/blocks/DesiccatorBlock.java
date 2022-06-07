package com.themajorn.scullery.common.blocks;

import com.themajorn.scullery.common.containers.DesiccatorContainer;
import com.themajorn.scullery.common.tileentities.DesiccatorTileEntity;
import com.themajorn.scullery.core.util.TileEntityTypeInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class DesiccatorBlock extends Block {

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(3, 0, 13, 13, 10, 14),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(3, 10, 3, 13, 11, 13),
            Block.box(6, 11, 6, 10, 12, 10),
            Block.box(2, 0, 3, 3, 10, 13),
            Block.box(13, 0, 3, 14, 10, 13),
            Block.box(3, 0, 2, 13, 10, 3)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(2, 0, 3, 3, 10, 13),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(3, 10, 3, 13, 11, 13),
            Block.box(6, 11, 6, 10, 12, 10),
            Block.box(3, 0, 2, 13, 10, 3),
            Block.box(3, 0, 13, 13, 10, 14),
            Block.box(13, 0, 3, 14, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(3, 0, 2, 13, 10, 3),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(3, 10, 3, 13, 11, 13),
            Block.box(6, 11, 6, 10, 12, 10),
            Block.box(13, 0, 3, 14, 10, 13),
            Block.box(2, 0, 3, 3, 10, 13),
            Block.box(3, 0, 13, 13, 10, 14)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.box(13, 0, 3, 14, 10, 13),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(3, 10, 3, 13, 11, 13),
            Block.box(6, 11, 6, 10, 12, 10),
            Block.box(3, 0, 13, 13, 10, 14),
            Block.box(3, 0, 2, 13, 10, 3),
            Block.box(2, 0, 3, 3, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public DesiccatorBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(HorizontalBlock.FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(HorizontalBlock.FACING, rotation.rotate(state.getValue(HorizontalBlock.FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(HorizontalBlock.FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HorizontalBlock.FACING);
    }


    @SuppressWarnings("deprecation")
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

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isClientSide()) {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);

                if(tileEntity instanceof DesiccatorTileEntity) {
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                    NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getBlockPos());
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("Desiccator");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new DesiccatorContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypeInit.DESICCATOR_TILE_ENTITY.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
