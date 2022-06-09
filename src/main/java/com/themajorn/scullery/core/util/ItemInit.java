package com.themajorn.scullery.core.util;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.blocks.BlockItemBase;
import com.themajorn.scullery.common.items.BeefJerkySlicesItem;
import com.themajorn.scullery.common.items.HardTackPiecesItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scullery.MOD_ID);

    // === HERBS, SPICES, SEASONINGS === //

    public static final RegistryObject<Item> ROSEMARY = ITEMS.register("rosemary",
            () -> new BlockItem(BlockInit.ROSEMARY.get(), new Item.Properties()
                    .tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> THYME = ITEMS.register("thyme",
            () -> new BlockItem(BlockInit.THYME.get(), new Item.Properties()
                    .tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new BlockItem(BlockInit.PEPPER.get(), new Item.Properties()
                    .tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> BASIL = ITEMS.register("basil",
            () -> new BlockItem(BlockInit.BASIL.get(), new Item.Properties()
                    .tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> MINT = ITEMS.register("mint",
            () -> new BlockItem(BlockInit.MINT.get(), new Item.Properties()
                    .tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> OREGANO = ITEMS.register("oregano",
            () -> new BlockItem(BlockInit.OREGANO.get(), new Item.Properties()
                    .tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));


    // === INGREDIENTS === //

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> DOUGH_BALLS = ITEMS.register("dough_balls",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> BROWN_SUGAR = ITEMS.register("brown_sugar",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> MOLASSES = ITEMS.register("molasses",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));


    // === BERRIES === //

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new BlockItem(BlockInit.BLUEBERRY.get(), new Item.Properties().food(new Food.Builder().nutrition(1)
                    .saturationMod(0.1F).fast().alwaysEat().build()).tab(ItemGroup.TAB_FOOD)));


    // === MEAT === //

    public static final RegistryObject<Item> SLICED_BEEF = ITEMS.register("sliced_beef",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(0)
                    .saturationMod(0.2F).fast().meat().build())));

    public static final RegistryObject<Item> SALTED_BEEF = ITEMS.register("salted_beef",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(0)
                    .saturationMod(-0.4F).fast().effect(new EffectInstance(Effects.HUNGER), 10.0F)
                    .meat().build())));

    public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).fireResistant().food(new Food.Builder().nutrition(2)
                    .saturationMod(0.6F).fast().meat().build())));

    public static final RegistryObject<Item> BEEF_JERKY_SLICES = ITEMS.register("beef_jerky_slices",
            BeefJerkySlicesItem::new);


    // === GRAIN === //

    public static final RegistryObject<Item> HARDTACK = ITEMS.register("hardtack",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).fireResistant().food(new Food.Builder().nutrition(1)
                    .saturationMod(2.8F).fast().build())));

    public static final RegistryObject<Item> HARDTACK_PIECES = ITEMS.register("hardtack_pieces",
            HardTackPiecesItem::new);


    // === NUTS === //

    public static final RegistryObject<Item> ACORN = ITEMS.register("acorn",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(0)
                    .saturationMod(-0.5F).fast().build())));

    public static final RegistryObject<Item> ALMOND = ITEMS.register("almond",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1)
                    .saturationMod(0.5F).fast().build())));

    public static final RegistryObject<Item> CHESTNUT = ITEMS.register("chestnut",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> OPEN_CHESTNUT = ITEMS.register("open_chestnut",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));


    // === FRUIT === //

    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1)
                    .saturationMod(0.2F).fast().build())));

    public static final RegistryObject<Item> APPLE_SLICES = ITEMS.register("apple_slices",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(2)
                    .saturationMod(0.2F).fast().build())));

    public static final RegistryObject<Item> DRIED_APPLE_SLICES = ITEMS.register("dried_apple_slices",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).fireResistant().food(new Food.Builder().nutrition(2)
                    .saturationMod(0.2F).fast().build())));

    // === MEALS === //

    public static final RegistryObject<Item> ADVENTURING_RATIONS = ITEMS.register("adventuring_ration",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).fireResistant().food(new Food.Builder().nutrition(16)
                    .saturationMod(12.5F).build())));


    // === BLOCK ITEMS === //

    public static final RegistryObject<Item> OLIVE_LOG_ITEM = ITEMS.register("olive_log",
            () -> new BlockItemBase(BlockInit.OLIVE_LOG.get()));

    public static final RegistryObject<Item> OLIVE_WOOD_ITEM = ITEMS.register("olive_wood",
            () -> new BlockItemBase(BlockInit.OLIVE_WOOD.get()));

    public static final RegistryObject<Item> STRIPPED_OLIVE_LOG_ITEM = ITEMS.register("stripped_olive_log",
            () -> new BlockItemBase(BlockInit.STRIPPED_OLIVE_LOG.get()));

    public static final RegistryObject<Item> STRIPPED_OLIVE_WOOD_ITEM = ITEMS.register("stripped_olive_wood",
            () -> new BlockItemBase(BlockInit.STRIPPED_OLIVE_WOOD.get()));

    public static final RegistryObject<Item> OLIVE_PLANK_ITEM = ITEMS.register("olive_plank",
            () -> new BlockItemBase(BlockInit.OLIVE_PLANK.get()));

    public static final RegistryObject<Item> OLIVE_LEAVES_ITEM = ITEMS.register("olive_leaves",
            () -> new BlockItemBase(BlockInit.OLIVE_LEAVES.get()));

    public static final RegistryObject<Item> OLIVE_SAPLING_ITEM = ITEMS.register("olive_sapling",
            () -> new BlockItemBase(BlockInit.OLIVE_SAPLING.get()));

    public static final RegistryObject<Item> CHESTNUT_LOG_ITEM = ITEMS.register("chestnut_log",
            () -> new BlockItemBase(BlockInit.CHESTNUT_LOG.get()));

    public static final RegistryObject<Item> CHESTNUT_WOOD_ITEM = ITEMS.register("chestnut_wood",
            () -> new BlockItemBase(BlockInit.CHESTNUT_WOOD.get()));

    public static final RegistryObject<Item> STRIPPED_CHESTNUT_LOG_ITEM = ITEMS.register("stripped_chestnut_log",
            () -> new BlockItemBase(BlockInit.STRIPPED_CHESTNUT_LOG.get()));

    public static final RegistryObject<Item> STRIPPED_CHESTNUT_WOOD_ITEM = ITEMS.register("stripped_chestnut_wood",
            () -> new BlockItemBase(BlockInit.STRIPPED_CHESTNUT_WOOD.get()));

    public static final RegistryObject<Item> CHESTNUT_PLANK_ITEM = ITEMS.register("chestnut_plank",
            () -> new BlockItemBase(BlockInit.CHESTNUT_PLANK.get()));

    public static final RegistryObject<Item> CHESTNUT_SAPLING_ITEM = ITEMS.register("chestnut_sapling",
            () -> new BlockItemBase(BlockInit.CHESTNUT_SAPLING.get()));

    public static final RegistryObject<Item> CHESTNUT_LEAVES_ITEM = ITEMS.register("chestnut_leaves",
            () -> new BlockItemBase(BlockInit.CHESTNUT_LEAVES.get()));

    public static final RegistryObject<Item> ALMOND_LOG_ITEM = ITEMS.register("almond_log",
            () -> new BlockItemBase(BlockInit.ALMOND_LOG.get()));

    public static final RegistryObject<Item> ALMOND_WOOD_ITEM = ITEMS.register("almond_wood",
            () -> new BlockItemBase(BlockInit.ALMOND_WOOD.get()));

    public static final RegistryObject<Item> STRIPPED_ALMOND_LOG_ITEM = ITEMS.register("stripped_almond_log",
            () -> new BlockItemBase(BlockInit.STRIPPED_ALMOND_LOG.get()));

    public static final RegistryObject<Item> STRIPPED_ALMOND_WOOD_ITEM = ITEMS.register("stripped_almond_wood",
            () -> new BlockItemBase(BlockInit.STRIPPED_ALMOND_WOOD.get()));

    public static final RegistryObject<Item> ALMOND_PLANK_ITEM = ITEMS.register("almond_plank",
            () -> new BlockItemBase(BlockInit.ALMOND_PLANK.get()));

    public static final RegistryObject<Item> ALMOND_SAPLING_ITEM = ITEMS.register("almond_sapling",
            () -> new BlockItemBase(BlockInit.ALMOND_SAPLING.get()));

    public static final RegistryObject<Item> ALMOND_LEAVES_ITEM = ITEMS.register("almond_leaves",
            () -> new BlockItemBase(BlockInit.ALMOND_LEAVES.get()));

    public static final RegistryObject<Item> CUTTING_BOARD_ITEM = ITEMS.register("cutting_board",
            () -> new BlockItemBase(BlockInit.CUTTING_BOARD.get()));

    public static final RegistryObject<Item> DESICCATOR_ITEM = ITEMS.register("desiccator",
            () -> new BlockItemBase(BlockInit.DESICCATOR.get()));
}
