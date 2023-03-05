package me.declipsonator.featurosity.registry;

import me.declipsonator.featurosity.Featurosity;
import me.declipsonator.featurosity.extra.CustomMinecartType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MinecartItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeaturosityItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Featurosity.MODID);

    //Tuff Stuff
    public static final RegistryObject<BlockItem> POLISHED_TUFF_ITEM = ITEMS.register("polished_tuff", () -> new BlockItem(FeaturosityBlocks.POLISHED_TUFF.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_STAIRS_ITEM = ITEMS.register("polished_tuff_stairs", () -> new BlockItem(FeaturosityBlocks.POLISHED_TUFF_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_WALL_ITEM = ITEMS.register("polished_tuff_wall", () -> new BlockItem(FeaturosityBlocks.POLISHED_TUFF_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_SLAB_ITEM = ITEMS.register("polished_tuff_slab", () -> new BlockItem(FeaturosityBlocks.POLISHED_TUFF_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> TUFF_STAIRS_ITEM = ITEMS.register("tuff_stairs", () -> new BlockItem(FeaturosityBlocks.TUFF_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TUFF_WALL_ITEM = ITEMS.register("tuff_wall", () -> new BlockItem(FeaturosityBlocks.TUFF_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TUFF_SLAB_ITEM = ITEMS.register("tuff_slab", () -> new BlockItem(FeaturosityBlocks.TUFF_SLAB.get(), new Item.Properties()));

    //Copper Hopper
    public static final RegistryObject<BlockItem> COPPER_HOPPER_ITEM = ITEMS.register("copper_hopper", () -> new BlockItem(FeaturosityBlocks.COPPER_HOPPER.get(), new Item.Properties()));
    public static final RegistryObject<MinecartItem> COPPER_HOPPER_MINECART_ITEM = ITEMS.register("copper_hopper_minecart", () -> new MinecartItem(CustomMinecartType.COPPER_HOPPER, new Item.Properties()));


}