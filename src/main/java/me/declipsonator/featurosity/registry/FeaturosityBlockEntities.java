package me.declipsonator.featurosity.registry;

import me.declipsonator.featurosity.Featurosity;
import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeaturosityBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Featurosity.MODID);

    //Copper Hopper
    public static final RegistryObject<BlockEntityType<CopperHopperBlockEntity>> COPPER_HOPPER_BLOCK_ENTITY = BLOCK_ENTITIES.register("copper_hopper", () -> BlockEntityType.Builder.of(CopperHopperBlockEntity::new, FeaturosityBlocks.COPPER_HOPPER.get()).build(null));

}
