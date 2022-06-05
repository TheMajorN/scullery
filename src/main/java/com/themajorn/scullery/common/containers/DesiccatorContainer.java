package com.themajorn.scullery.common.containers;

import com.themajorn.scullery.common.tileentities.DesiccatorTileEntity;
import com.themajorn.scullery.core.util.BlockInit;
import com.themajorn.scullery.core.util.ContainerTypeInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class DesiccatorContainer extends Container {

    public final DesiccatorTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;

    public DesiccatorContainer(final int windowId, final PlayerInventory playerInv, final DesiccatorTileEntity te) {
        super(ContainerTypeInit.DESICCATOR_CONTAINER.get(), windowId);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.create(te.getLevel(), te.getBlockPos());

        // Tile Entity
        this.addSlot(new Slot((IInventory) te, 0, 80, 35));

        // Main Player Inventory
        for (int row = 0 ; row < 3 ; row++) {
            for (int col = 0 ; col < 9 ; col++) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }

        // Player Hotbar
        for (int col = 0 ; col < 9 ; col++) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }

    }

    public DesiccatorContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
        this(windowId, playerInv, getTileEntity(playerInv, data));
    }

    private static DesiccatorTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "Player inventory cannot be null.");
        Objects.requireNonNull(data, "Packet buffer cannot be null.");
        final TileEntity te = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if (te instanceof DesiccatorTileEntity) {
            return (DesiccatorTileEntity) te;
        }
        throw new IllegalStateException("Tile entity is not correct.");
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(canInteractWithCallable, player, BlockInit.DESICCATOR.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if (index < DesiccatorTileEntity.slots && !this.moveItemStackTo(stack, DesiccatorTileEntity.slots, this.slots.size(), false)) {
                return ItemStack.EMPTY;
            }
            if (!this.moveItemStackTo(stack, 0, DesiccatorTileEntity.slots, false)) {
                return ItemStack.EMPTY;
            }
            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return stack;
    }
}
