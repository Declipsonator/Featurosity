package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.block.CopperHopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

@Mixin(RedstoneWireBlock.class)
public class RedstoneWireBlockMixin {
	@Inject(method = "canRunOnTop", at = @At("HEAD"), cancellable = true)
	private void redstoneOnTop(BlockView world, BlockPos pos, BlockState floor, CallbackInfoReturnable<Boolean> ci) {
		if (floor.getBlock() instanceof CopperHopper) {
			ci.setReturnValue(true);
		}
	}
}