package com.themajorn.scullery.common.items;

import com.themajorn.scullery.core.util.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class BeefJerkySlicesItem extends Item {
    public BeefJerkySlicesItem() {
        super(new Item.Properties()
                .tab(ItemGroup.TAB_FOOD)
                .fireResistant());
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(Hand.MAIN_HAND);
        ItemStack beefStack = ItemInit.BEEF_JERKY.get().getDefaultInstance();

        if (stack.getItem() == ItemInit.BEEF_JERKY_SLICES.get()) {
            player.playSound(SoundEvents.WEEPING_VINES_HIT, 0.1F, 0.05F);
            for (int i = 0 ; i < 4 ; i++) {
                player.inventory.add(beefStack);
                beefStack.grow(1);
            }
            stack.shrink(1);
        }
        return ActionResult.sidedSuccess(stack, world.isClientSide());
    }
}