package me.declipsonator.featurosity.block.entity;

import me.declipsonator.featurosity.registry.FeaturosityBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class CopperHopperBlockEntity extends HopperBlockEntity {
    public static final int TRANSFER_COOLDOWN = 4;

    public CopperHopperBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }


    @Override
    public BlockEntityType<?> getType() {
        return FeaturosityBlockEntities.COPPER_HOPPER_BLOCK_ENTITY.get();
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.copper_hopper");
    }
}
