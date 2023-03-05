package me.declipsonator.featurosity.mixins.copperhopper;

import me.declipsonator.featurosity.extra.CustomMinecartType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(AbstractMinecart.Type.class)
public class MinecartTypeMixin {


    @Mutable
    @Shadow @Final private static AbstractMinecart.Type[] $VALUES;

    @SuppressWarnings({"InvokerTarget", "unused", "SameParameterValue"})
    @Invoker("<init>")
    private static AbstractMinecart.Type newType(String internalName, int internalId) {
        throw new AssertionError();
    }


    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(value = "FIELD",
            target = "Lnet/minecraft/world/entity/vehicle/AbstractMinecart$Type;$VALUES:[Lnet/minecraft/world/entity/vehicle/AbstractMinecart$Type;",
            opcode = Opcodes.PUTSTATIC,
            shift = At.Shift.AFTER))
    private static void addCustomType(CallbackInfo ci) {
        ArrayList<AbstractMinecart.Type> types = new ArrayList<>(Arrays.asList($VALUES));
        AbstractMinecart.Type lastType = types.get(types.size() - 1);
        int lastId = lastType.ordinal() + 1;

        types.add(CustomMinecartType.COPPER_HOPPER = newType("featurosity_copper", lastId));

        $VALUES = types.toArray(AbstractMinecart.Type[]::new);
    }
}