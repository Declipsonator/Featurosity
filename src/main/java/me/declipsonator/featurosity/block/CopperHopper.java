package me.declipsonator.featurosity.block;

import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperHopper extends HopperBlock implements BlockEntityProvider {
    public CopperHopper(Settings settings) {
        super(settings);

    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperHopperBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient() ? null : checkType(type, Constants.COPPER_HOPPER_BLOCK_ENTITY, CopperHopperBlockEntity::serverTick);
    }
}
