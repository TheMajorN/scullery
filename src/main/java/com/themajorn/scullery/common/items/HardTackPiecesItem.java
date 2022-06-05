package com.themajorn.scullery.common.items;

import com.themajorn.scullery.core.util.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class HardTackPiecesItem extends Item {
    public HardTackPiecesItem() {
        super(new Item.Properties()
                .tab(ItemGroup.TAB_FOOD)
                .fireResistant());
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(Hand.MAIN_HAND);
        ItemStack hardTackStack = ItemInit.HARDTACK.get().getDefaultInstance();

        if (stack.getItem() == ItemInit.HARDTACK_PIECES.get()) {
            player.playSound(SoundEvents.SWEET_BERRY_BUSH_BREAK, 0.1F, 0.05F);
            for (int i = 0 ; i < 4 ; i++) {
                player.inventory.add(hardTackStack);
                hardTackStack.grow(1);
            }
            stack.shrink(1);
        }
        return ActionResult.sidedSuccess(stack, world.isClientSide());
    }
}
