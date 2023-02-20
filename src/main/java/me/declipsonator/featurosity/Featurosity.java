package me.declipsonator.featurosity;

import com.mojang.logging.LogUtils;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.entries.EntryGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Featurosity.MODID)
public class Featurosity {
    public static final String MODID = "featurosity";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Featurosity() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Blocks
        Constants.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        //Items
        Constants.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        //Sounds
        Constants.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());


        // Register ourselves for server and other game events we are interested in
        modEventBus.addListener(this::addGroups);
        LOGGER.info("Featurosity has initialized!");
    }

    @SubscribeEvent
    public void addGroups(CreativeModeTabEvent.BuildContents event) {
        // Add to ingredients tab
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(Items.TUFF);
            event.accept(Constants.TUFF_SLAB_ITEM);
            event.accept(Constants.TUFF_STAIRS_ITEM);
            event.accept(Constants.TUFF_WALL_ITEM);
            event.accept(Constants.POLISHED_TUFF_ITEM);
            event.accept(Constants.POLISHED_TUFF_SLAB_ITEM);
            event.accept(Constants.POLISHED_TUFF_STAIRS_ITEM);
            event.accept(Constants.POLISHED_TUFF_WALL_ITEM);
        }
    }
}
