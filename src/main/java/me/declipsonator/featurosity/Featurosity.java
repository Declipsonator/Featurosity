package me.declipsonator.featurosity;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Featurosity implements ModInitializer {
    public static Logger LOG = LogManager.getLogger("Featurosity");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Featurosity!");

        Registry.register(Registries.SOUND_EVENT, Constants.FIRECHARGE_THROW_ID, Constants.FIRECHARGE_THROW_EVENT);

        LOG.info("Initialized Featurosity!");
    }
}
