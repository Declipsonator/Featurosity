package me.declipsonator.featurosity;

import com.mojang.logging.LogUtils;
import me.declipsonator.featurosity.registry.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static me.declipsonator.featurosity.Featurosity.MODID;

@Mod(MODID)
public class Featurosity {
    public static final String MODID = "featurosity";
    public static final Logger LOGGER = LogUtils.getLogger();


    public Featurosity() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Blocks
        FeaturosityBlocks.BLOCKS.register(modEventBus);

        //Items
        FeaturosityItems.ITEMS.register(modEventBus);

        //Block Entities
        FeaturosityBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        //Entities
        FeaturosityEntities.ENTITIES.register(modEventBus);

        //Sounds
        FeaturositySoundEvents.SOUND_EVENTS.register(modEventBus);

        modEventBus.addListener(this::onClientSetup);

        // Register ourselves for server and other game events we are interested in
        modEventBus.addListener(this::addGroups);
        LOGGER.info("Featurosity has initialized!");
    }

    @SubscribeEvent
    public void addGroups(CreativeModeTabEvent.BuildContents event) {
        // Add to ingredients tab
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(Items.TUFF);
            event.accept(FeaturosityItems.TUFF_SLAB_ITEM);
            event.accept(FeaturosityItems.TUFF_STAIRS_ITEM);
            event.accept(FeaturosityItems.TUFF_WALL_ITEM);
            event.accept(FeaturosityItems.POLISHED_TUFF_ITEM);
            event.accept(FeaturosityItems.POLISHED_TUFF_SLAB_ITEM);
            event.accept(FeaturosityItems.POLISHED_TUFF_STAIRS_ITEM);
            event.accept(FeaturosityItems.POLISHED_TUFF_WALL_ITEM);
        }
        if (event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(FeaturosityItems.COPPER_HOPPER_MINECART_ITEM);
            event.accept(FeaturosityItems.COPPER_HOPPER_ITEM);
        }
        if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(FeaturosityItems.COOKED_ROTTEN_FLESH_ITEM);
        }
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(FeaturosityEntities.COPPER_HOPPER_MINECART_ENTITY.get(), (context) -> new MinecartRenderer<>(context, ModelLayers.HOPPER_MINECART));
    }
}
