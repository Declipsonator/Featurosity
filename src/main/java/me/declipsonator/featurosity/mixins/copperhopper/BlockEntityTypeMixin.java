package me.declipsonator.featurosity.mixins.copperhopper;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.extra.BlockEntityTypeInterface;
import net.minecraft.block.Block;
import net.minecraft.block.entity.*;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin implements BlockEntityTypeInterface {
    @Shadow @Final public static BlockEntityType<HopperBlockEntity> HOPPER;

    @Mutable @Shadow @Final private Set<Block> blocks;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void afterStaticInit(CallbackInfo info) {
        ((BlockEntityTypeInterface) HOPPER).addBlocks(Constants.COPPER_HOPPER);
    }

    @Override
    public void addBlocks(Block... blocks) {
        List<Block> list = Lists.newArrayList(this.blocks);
        Collections.addAll(list, blocks);
        this.blocks = ImmutableSet.copyOf(list);
    }
}
