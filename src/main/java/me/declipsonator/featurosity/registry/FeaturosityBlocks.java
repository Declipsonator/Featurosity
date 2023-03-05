package me.declipsonator.featurosity.registry;

import me.declipsonator.featurosity.Featurosity;
import me.declipsonator.featurosity.block.CopperHopper;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeaturosityBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Featurosity.MODID);

    //Tuff Stuff
    public static final RegistryObject<Block> POLISHED_TUFF = BLOCKS.register("polished_tuff", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5f, 6.0f)));
    public static final RegistryObject<StairBlock> POLISHED_TUFF_STAIRS = BLOCKS.register("polished_tuff_stairs", () -> new StairBlock(POLISHED_TUFF.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_WALL = BLOCKS.register("polished_tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_SLAB = BLOCKS.register("polished_tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));

    public static final RegistryObject<StairBlock> TUFF_STAIRS = BLOCKS.register("tuff_stairs", () -> new StairBlock(Blocks.TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<WallBlock> TUFF_WALL = BLOCKS.register("tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<SlabBlock> TUFF_SLAB = BLOCKS.register("tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    //Copper Hopper
    public static final RegistryObject<Block> COPPER_HOPPER = BLOCKS.register("copper_hopper", () -> new CopperHopper(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).strength(3.0F).sound(SoundType.COPPER)));

}
