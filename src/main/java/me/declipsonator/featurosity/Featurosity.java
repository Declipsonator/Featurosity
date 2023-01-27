package me.declipsonator.featurosity;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.FireChargeItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Featurosity implements ModInitializer {
    public static Logger LOG = LogManager.getLogger("Featurosity");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Featurosity!");
    }
}
