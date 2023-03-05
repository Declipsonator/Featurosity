package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.entity.CopperHopperMinecartEntity;
import me.declipsonator.featurosity.extra.CustomMinecartType;
import me.declipsonator.featurosity.registry.FeaturosityItems;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartEntityMixin {

    @Shadow public abstract AbstractMinecart.Type getMinecartType();

    @Inject(method="createMinecart", at=@At(value="HEAD"), cancellable = true)
    private static void createMinecartEntity(Level world, double x, double y, double z, AbstractMinecart.Type type, CallbackInfoReturnable<AbstractMinecart> info) {
        if (type == CustomMinecartType.COPPER_HOPPER) {
            info.setReturnValue(new CopperHopperMinecartEntity(world, x, y, z));
            info.cancel();
        }
    }

    @Inject(method="getPickResult", at = @At(value = "HEAD"), cancellable = true)
    private void getPickBlockStack(CallbackInfoReturnable<ItemStack> info) {
        if (getMinecartType() == CustomMinecartType.COPPER_HOPPER) {
            info.setReturnValue(new ItemStack(FeaturosityItems.COPPER_HOPPER_MINECART_ITEM.get()));
            info.cancel();
        }
    }
}
