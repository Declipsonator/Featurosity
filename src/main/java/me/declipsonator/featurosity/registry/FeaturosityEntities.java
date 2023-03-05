package me.declipsonator.featurosity.registry;

import me.declipsonator.featurosity.Featurosity;
import me.declipsonator.featurosity.entity.CopperHopperMinecartEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeaturosityEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Featurosity.MODID);

    //Copper Hopper
    public static final RegistryObject<EntityType<CopperHopperMinecartEntity>> COPPER_HOPPER_MINECART_ENTITY = ENTITIES.register("copper_hopper_minecart", () -> EntityType.Builder.of(CopperHopperMinecartEntity::createCopperHopperMinecart, MobCategory.MISC).sized(.98f, 0.7f).clientTrackingRange(8).build("copper_hopper_minecart"));

}
