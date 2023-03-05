package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.block.CopperHopper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(RedStoneWireBlock.class)
public class RedstoneWireBlockMixin {
	@Inject(method = "canSurviveOn", at = @At("HEAD"), cancellable = true)
	private void redstoneOnTop(BlockGetter world, BlockPos pos, BlockState floor, CallbackInfoReturnable<Boolean> ci) {
		if (floor.getBlock() instanceof CopperHopper) {
			ci.setReturnValue(true);
		}
	}
}