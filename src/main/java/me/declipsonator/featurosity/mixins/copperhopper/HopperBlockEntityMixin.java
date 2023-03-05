package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.registry.FeaturosityBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin extends RandomizableContainerBlockEntity {

    @Shadow private int cooldownTime;

    protected HopperBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Inject(method = "setCooldown", at = @At("HEAD"), cancellable = true)
    private void setCoolDown(int cooldown, CallbackInfo info) {
        if (cooldown > 0 && this.getType() == FeaturosityBlockEntities.COPPER_HOPPER_BLOCK_ENTITY.get()) {
            this.cooldownTime = cooldown - 4;
            info.cancel();
        }
    }
}
