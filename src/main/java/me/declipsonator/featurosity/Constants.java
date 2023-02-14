package me.declipsonator.featurosity;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Constants {
    //Thrown Fire Charges
    public static final Identifier FIRECHARGE_THROW_ID = new Identifier("featurosity:firecharge_throw");
    public static SoundEvent FIRECHARGE_THROW_EVENT = SoundEvent.of(FIRECHARGE_THROW_ID);
    public static final double FIRECHARGE_SPEED = 26.9;

    //Tuff Improvements
    public static final Block POLISHED_TUFF = new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.TERRACOTTA_GRAY).sounds(BlockSoundGroup.TUFF).requiresTool().strength(1.5f, 6.0f));
    public static final StairsBlock POLISHED_TUFF_STAIRS = new StairsBlock(POLISHED_TUFF.getDefaultState(), AbstractBlock.Settings.copy(POLISHED_TUFF));
    public static final Block POLISHED_TUFF_WALL = new WallBlock(AbstractBlock.Settings.copy(POLISHED_TUFF));
    public static final Block POLISHED_TUFF_SLAB = new SlabBlock(AbstractBlock.Settings.copy(POLISHED_TUFF));

    public static final Block TUFF_STAIRS = new StairsBlock(Blocks.TUFF.getDefaultState(), AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block TUFF_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block TUFF_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF));

    public static final BlockItem POLISHED_TUFF_ITEM = new BlockItem(POLISHED_TUFF, new Item.Settings());
    public static final BlockItem POLISHED_TUFF_STAIRS_ITEM = new BlockItem(POLISHED_TUFF_STAIRS, new Item.Settings());
    public static final BlockItem POLISHED_TUFF_WALL_ITEM = new BlockItem(POLISHED_TUFF_WALL, new Item.Settings());
    public static final BlockItem POLISHED_TUFF_SLAB_ITEM = new BlockItem(POLISHED_TUFF_SLAB, new Item.Settings());

    public static final BlockItem TUFF_STAIRS_ITEM = new BlockItem(TUFF_STAIRS, new Item.Settings());
    public static final BlockItem TUFF_WALL_ITEM = new BlockItem(TUFF_WALL, new Item.Settings());
    public static final BlockItem TUFF_SLAB_ITEM = new BlockItem(TUFF_SLAB, new Item.Settings());

}
