package me.declipsonator.featurosity.mixins.sporeblossomgrowth;

import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.Featurosity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CropBlock.class)
public class CropBlockMixin {
    @Shadow
    protected static float getGrowthSpeed(Block p_52273_, BlockGetter p_52274_, BlockPos p_52275_) { return 0; }


    @Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I"))
    private int modifyChance(RandomSource instance, int i, BlockState blockState, ServerLevel world, BlockPos pos, RandomSource random) {
        int bound = (int)(25.0f / getGrowthSpeed((Block) (Object) this, world, pos)) + 1;

        for(int y = 0; y < 4; y++) {
            for(int x = -1; x < 2; x++) {
                for(int z = -1; z < 2; z++) {
                    if(world.getBlockState(pos.offset(x, y, z)).getBlock() == Blocks.SPORE_BLOSSOM) {
                        return instance.nextInt(bound / Constants.SPORE_BLOSSOM_GROWTH_MULTIPLIER);
                    }
                }
            }
        }
        return instance.nextInt(bound);
    }
}
