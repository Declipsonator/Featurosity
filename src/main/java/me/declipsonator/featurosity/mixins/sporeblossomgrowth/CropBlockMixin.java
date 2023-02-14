package me.declipsonator.featurosity.mixins.sporeblossomgrowth;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin {

    @Shadow
    protected static float getAvailableMoisture(Block block, BlockView world, BlockPos pos) { return 0; }


    @Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I"))
    private int modifyChance(Random instance, int i, BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int bound = (int)(25.0f / getAvailableMoisture((Block) (Object) this, world, pos)) + 1;

        for(int y = 0; y < 4; y++) {
            for(int x = -1; x < 2; x++) {
                for(int z = -1; z < 2; z++) {
                    if(world.getBlockState(pos.add(x, y, z)).getBlock() == Blocks.SPORE_BLOSSOM) {
                        return instance.nextInt(bound / 2);
                    }
                }
            }
        }
        return instance.nextInt(bound);
    }
}
