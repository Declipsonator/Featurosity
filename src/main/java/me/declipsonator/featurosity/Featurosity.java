package me.declipsonator.featurosity;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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


        LOG.info("Initialized Featurosity!");
    }
}
