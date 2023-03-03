package me.declipsonator.featurosity.block.entity;

import me.declipsonator.featurosity.Constants;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class CopperHopperBlockEntity extends HopperBlockEntity {
    public static final int TRANSFER_COOLDOWN = 4;

    public CopperHopperBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }


    @Override
    public BlockEntityType<?> getType() {
        return Constants.COPPER_HOPPER_BLOCK_ENTITY;
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.copper_hopper");
    }
}
