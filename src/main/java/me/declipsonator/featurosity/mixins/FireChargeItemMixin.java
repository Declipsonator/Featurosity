package me.declipsonator.featurosity.mixins;

import me.declipsonator.featurosity.Constants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.FireChargeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FireChargeItem.class)
public class FireChargeItemMixin extends Item {
    public FireChargeItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), Constants.FIRECHARGE_THROW_EVENT, SoundCategory.NEUTRAL, 1f, 1);
        if (!world.isClient) {
            Vec3d velocity = getHorizontalVelocity(Constants.FIRECHARGE_SPEED, user.getPitch(), user.getYaw());
            SmallFireballEntity entity = new SmallFireballEntity(world, user.getX(), user.getEyeY() - 0.1, user.getZ(), velocity.x, velocity.y, velocity.z);
            entity.setItem(itemStack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            entity.setOwner(user);
            world.spawnEntity(entity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


    private Vec3d getHorizontalVelocity(double bps, float pitch, float yaw) {
        Vec3d forward = Vec3d.fromPolar(pitch, yaw);
        double x = forward.x / 20 * bps;
        double y = forward.y / 20 * bps;
        double z = forward.z / 20 * bps;
        return new Vec3d(x, y, z);
    }
}
