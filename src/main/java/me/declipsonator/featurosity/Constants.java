package me.declipsonator.featurosity;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Constants {
    //Thrown Fire Charges
    public static final Identifier FIRECHARGE_THROW_ID = new Identifier("featurosity:firecharge_throw");
    public static SoundEvent FIRECHARGE_THROW_EVENT = SoundEvent.of(FIRECHARGE_THROW_ID);
    public static final double FIRECHARGE_SPEED = 26.9;
}
