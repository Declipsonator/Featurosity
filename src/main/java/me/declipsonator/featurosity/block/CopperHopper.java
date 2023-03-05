package me.declipsonator.featurosity.block;

import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import me.declipsonator.featurosity.registry.FeaturosityBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CopperHopper extends HopperBlock implements EntityBlock {
    public CopperHopper(Properties settings) {
        super(settings);

    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperHopperBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return world.isClientSide() ? null : createTickerHelper(type, FeaturosityBlockEntities.COPPER_HOPPER_BLOCK_ENTITY.get(), CopperHopperBlockEntity::pushItemsTick);
    }
}
