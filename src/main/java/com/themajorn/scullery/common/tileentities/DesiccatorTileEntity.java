package com.themajorn.scullery.common.tileentities;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.containers.DesiccatorContainer;
import com.themajorn.scullery.core.util.TileEntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DesiccatorTileEntity extends LockableLootTileEntity {

    public static int slots = 5;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    protected DesiccatorTileEntity(TileEntityType<?> type) {
        super(type);
    }

    public DesiccatorTileEntity() {
        this(TileEntityTypeInit.DESICCATOR_TILE_ENTITY.get());
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + Scullery.MOD_ID + ".desiccator");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new DesiccatorContainer(id, player, this);
    }

    @Override
    public int getContainerSize() {
        return slots;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        return null;
    }

    @Override
    public void setItem(int p_70299_1_, ItemStack p_70299_2_) {

    }

    @Override
    public boolean stillValid(PlayerEntity p_70300_1_) {
        return false;
    }

    @Override
    public void clearContent() {

    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemIn) {
        this.items = itemIn;
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        if (this.trySaveLootTable(compound)) {
            ItemStackHelper.saveAllItems(compound, this.items);
        }
        return compound;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
    }
}
