package me.declipsonator.featurosity.registry;

import me.declipsonator.featurosity.Featurosity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeaturositySoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Featurosity.MODID);

    //Firecharge Throw
    public static final ResourceLocation FIRECHARGE_THROW_ID = new ResourceLocation("featurosity:firecharge_throw");
    public static RegistryObject<SoundEvent> FIRECHARGE_THROW_EVENT = SOUND_EVENTS.register("firecharge_throw", () -> SoundEvent.createVariableRangeEvent(FIRECHARGE_THROW_ID));
}
