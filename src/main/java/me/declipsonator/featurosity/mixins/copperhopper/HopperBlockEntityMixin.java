package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin extends LootableContainerBlockEntity {
    @Shadow private int transferCooldown;

    protected HopperBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Inject(method = "setTransferCooldown", at = @At("HEAD"), cancellable = true)
    private void setCoolDown(int cooldown, CallbackInfo info) {
        if (cooldown > 0 && this.getType() == Constants.COPPER_HOPPER_BLOCK_ENTITY) {
            this.transferCooldown = cooldown - 4;
            info.cancel();
        }
    }
}
