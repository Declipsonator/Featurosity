package me.declipsonator.featurosity;

import me.declipsonator.featurosity.extra.CustomMinecartType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.NoteBlock;
import net.minecraft.client.render.entity.MinecartEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.client.render.entity.model.MinecartEntityModel;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.HopperMinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Featurosity implements ModInitializer {
    public static Logger LOG = LogManager.getLogger("Featurosity");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Featurosity!");


        //FireCharges
        Registry.register(Registries.SOUND_EVENT, Constants.FIRECHARGE_THROW_ID, Constants.FIRECHARGE_THROW_EVENT);



        //Tuff Stuff
        Registry.register(Registries.BLOCK, new Identifier("featurosity", "polished_tuff"), Constants.POLISHED_TUFF);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "polished_tuff"), Constants.POLISHED_TUFF_ITEM);

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "polished_tuff_stairs"), Constants.POLISHED_TUFF_STAIRS);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "polished_tuff_stairs"), Constants.POLISHED_TUFF_STAIRS_ITEM);

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "polished_tuff_wall"), Constants.POLISHED_TUFF_WALL);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "polished_tuff_wall"), Constants.POLISHED_TUFF_WALL_ITEM);

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "polished_tuff_slab"), Constants.POLISHED_TUFF_SLAB);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "polished_tuff_slab"), Constants.POLISHED_TUFF_SLAB_ITEM);

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "tuff_stairs"), Constants.TUFF_STAIRS);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "tuff_stairs"), Constants.TUFF_STAIRS_ITEM);

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "tuff_wall"), Constants.TUFF_WALL);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "tuff_wall"), Constants.TUFF_WALL_ITEM);

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "tuff_slab"), Constants.TUFF_SLAB);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "tuff_slab"), Constants.TUFF_SLAB_ITEM);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(Blocks.TUFF);
            content.add(Constants.POLISHED_TUFF_ITEM);
            content.add(Constants.POLISHED_TUFF_STAIRS_ITEM);
            content.add(Constants.POLISHED_TUFF_WALL_ITEM);
            content.add(Constants.POLISHED_TUFF_SLAB_ITEM);
            content.add(Constants.TUFF_STAIRS_ITEM);
            content.add(Constants.TUFF_WALL_ITEM);
            content.add(Constants.TUFF_SLAB_ITEM);
        });

        // Copper Hopper

        Constants.COPPER_HOPPER_MINECART_ITEM = new MinecartItem(CustomMinecartType.COPPER_HOPPER, new Item.Settings().maxCount(1));

        Registry.register(Registries.BLOCK, new Identifier("featurosity", "copper_hopper"), Constants.COPPER_HOPPER);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "copper_hopper"), Constants.COPPER_HOPPER_ITEM);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("featurosity", "copper_hopper"), Constants.COPPER_HOPPER_BLOCK_ENTITY);
        Registry.register(Registries.ENTITY_TYPE, new Identifier("featurosity", "copper_hopper_minecart"), Constants.COPPER_HOPPER_MINECART_ENTITY);
        Registry.register(Registries.ITEM, new Identifier("featurosity", "copper_hopper_minecart"), Constants.COPPER_HOPPER_MINECART_ITEM);
        EntityModelLayerRegistry.registerModelLayer(Constants.COPPER_HOPPER_MINECART_MODEL_LAYER, MinecartEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(Constants.COPPER_HOPPER_MINECART_ENTITY, (context) -> new MinecartEntityRenderer<>(context, Constants.COPPER_HOPPER_MINECART_MODEL_LAYER));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.addAfter(Items.HOPPER, Constants.COPPER_HOPPER_ITEM);
            content.addAfter(Items.HOPPER_MINECART, Constants.COPPER_HOPPER_MINECART_ITEM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.HOPPER_MINECART, Constants.COPPER_HOPPER_MINECART_ITEM);
        });


        LOG.info("Initialized Featurosity!");
    }
}
