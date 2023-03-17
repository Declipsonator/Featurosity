package me.declipsonator.featurosity;

import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import me.declipsonator.featurosity.block.CopperHopper;
import me.declipsonator.featurosity.entity.CopperHopperMinecartEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.HopperMinecartEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

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

    //Copper Hopper
    public static final Block COPPER_HOPPER = new CopperHopper(AbstractBlock.Settings.of(Material.METAL, MapColor.ORANGE).strength(3.0F).sounds(BlockSoundGroup.COPPER));
    public static final BlockItem COPPER_HOPPER_ITEM = new BlockItem(COPPER_HOPPER, new Item.Settings());
    public static final BlockEntityType<CopperHopperBlockEntity> COPPER_HOPPER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(CopperHopperBlockEntity::new, COPPER_HOPPER).build();
    public static final EntityType<CopperHopperMinecartEntity> COPPER_HOPPER_MINECART_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.MISC, CopperHopperMinecartEntity::createCopperHopperMinecart).dimensions(EntityDimensions.fixed(.98f, 0.7f)).trackRangeBlocks(8).build();
    public static final EntityModelLayer COPPER_HOPPER_MINECART_MODEL_LAYER = new EntityModelLayer(new Identifier("featurosity", "copper_hopper_minecart"), "main");
    public static MinecartItem COPPER_HOPPER_MINECART_ITEM;

    //Cooked Rotten Flesh
    public static final FoodComponent COOKED_ROTTEN_FLESH_COMPONENT = new FoodComponent.Builder().hunger(5).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.2f).meat().build();
    public static final Item COOKED_ROTTEN_FLESH = new Item(new Item.Settings().food(COOKED_ROTTEN_FLESH_COMPONENT));
}
