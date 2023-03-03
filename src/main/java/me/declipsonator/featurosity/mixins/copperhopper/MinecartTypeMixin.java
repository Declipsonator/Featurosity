package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.extra.CustomMinecartType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.DyeColor;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(AbstractMinecartEntity.Type.class)
public class MinecartTypeMixin {
    @Shadow(aliases = "field_7673")
    @Mutable
    private static AbstractMinecartEntity.Type[] values;

    @SuppressWarnings({"InvokerTarget", "unused", "SameParameterValue"})
    @Invoker("<init>")
    private static AbstractMinecartEntity.Type newType(String internalName, int internalId) {
        throw new AssertionError();
    }

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(value = "FIELD",
            target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity$Type;field_7673:[Lnet/minecraft/entity/vehicle/AbstractMinecartEntity$Type;",
            opcode = Opcodes.PUTSTATIC,
            shift = At.Shift.AFTER))
    private static void addCustomType(CallbackInfo ci) {
        ArrayList<AbstractMinecartEntity.Type> types = new ArrayList<>(Arrays.asList(values));
        AbstractMinecartEntity.Type lastType = types.get(types.size() - 1);
        int lastId = lastType.ordinal() + 1;

        types.add(CustomMinecartType.COPPER_HOPPER = newType("featurosity_copper", lastId));

        values = types.toArray(AbstractMinecartEntity.Type[]::new);
    }
}