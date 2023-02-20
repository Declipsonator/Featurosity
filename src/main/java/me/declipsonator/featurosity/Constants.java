package me.declipsonator.featurosity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.tags.ITag;

public class Constants {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Featurosity.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Featurosity.MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Featurosity.MODID);

    //Thrown Fire Charges
    public static final ResourceLocation FIRECHARGE_THROW_ID = new ResourceLocation("featurosity:firecharge_throw");
    public static RegistryObject<SoundEvent> FIRECHARGE_THROW_EVENT = SOUND_EVENTS.register("firecharge_throw", () -> SoundEvent.createVariableRangeEvent(FIRECHARGE_THROW_ID));
    public static final double FIRECHARGE_SPEED = 26.9;

    //Tuff Improvements
    public static final RegistryObject<Block> POLISHED_TUFF = BLOCKS.register("polished_tuff", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5f, 6.0f)));
    public static final RegistryObject<StairBlock> POLISHED_TUFF_STAIRS = BLOCKS.register("polished_tuff_stairs", () -> new StairBlock(POLISHED_TUFF.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_WALL = BLOCKS.register("polished_tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_SLAB = BLOCKS.register("polished_tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));

    public static final RegistryObject<StairBlock> TUFF_STAIRS = BLOCKS.register("tuff_stairs", () -> new StairBlock(Blocks.TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<WallBlock> TUFF_WALL = BLOCKS.register("tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<SlabBlock> TUFF_SLAB = BLOCKS.register("tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    public static final RegistryObject<BlockItem> POLISHED_TUFF_ITEM = ITEMS.register("polished_tuff", () -> new BlockItem(POLISHED_TUFF.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_STAIRS_ITEM = ITEMS.register("polished_tuff_stairs", () -> new BlockItem(POLISHED_TUFF_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_WALL_ITEM = ITEMS.register("polished_tuff_wall", () -> new BlockItem(POLISHED_TUFF_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_SLAB_ITEM = ITEMS.register("polished_tuff_slab", () -> new BlockItem(POLISHED_TUFF_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> TUFF_STAIRS_ITEM = ITEMS.register("tuff_stairs", () -> new BlockItem(TUFF_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TUFF_WALL_ITEM = ITEMS.register("tuff_wall", () -> new BlockItem(TUFF_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TUFF_SLAB_ITEM = ITEMS.register("tuff_slab", () -> new BlockItem(TUFF_SLAB.get(), new Item.Properties()));



}
