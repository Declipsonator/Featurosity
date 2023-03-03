package me.declipsonator.featurosity.extra;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.DyeColor;

public class CustomMinecartType {
    static {
        AbstractMinecartEntity.Type.values();
    }

    public static AbstractMinecartEntity.Type COPPER_HOPPER;

}