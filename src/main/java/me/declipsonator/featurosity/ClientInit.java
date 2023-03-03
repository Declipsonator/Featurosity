package me.declipsonator.featurosity;

import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CrowdinTranslate.downloadTranslations("featurosity", "featurosity");
    }
}
