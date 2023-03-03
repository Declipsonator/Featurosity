package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.entity.CopperHopperMinecartEntity;
import me.declipsonator.featurosity.extra.CustomMinecartType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin {

    @Shadow public abstract AbstractMinecartEntity.Type getMinecartType();

    @Inject(method="create", at=@At(value="HEAD"), cancellable = true)
    private static void createMinecartEntity(World world, double x, double y, double z, AbstractMinecartEntity.Type type, CallbackInfoReturnable<AbstractMinecartEntity> info) {
        if (type == CustomMinecartType.COPPER_HOPPER) {
            info.setReturnValue(new CopperHopperMinecartEntity(world, x, y, z));
            info.cancel();
        }
    }

    @Inject(method="getPickBlockStack", at = @At(value = "HEAD"), cancellable = true)
    private void getPickBlockStack(CallbackInfoReturnable<ItemStack> info) {
        if (getMinecartType() == CustomMinecartType.COPPER_HOPPER) {
            info.setReturnValue(new ItemStack(Constants.COPPER_HOPPER_MINECART_ITEM));
            info.cancel();
        }
    }
}
