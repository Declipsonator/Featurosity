package me.declipsonator.featurosity.mixins.firecharges;


import me.declipsonator.featurosity.Constants;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FireChargeItem.class)
public class FireChargeItemMixin extends Item {
    public FireChargeItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), Constants.FIRECHARGE_THROW_EVENT.get(), SoundSource.NEUTRAL, 1f, 1);
        if (!world.isClientSide()) {
            Vec3 velocity = getHorizontalVelocity(Constants.FIRECHARGE_SPEED, user.getRotationVector().x, user.getRotationVector().y);
            SmallFireball entity = new SmallFireball(world, user.getX(), user.getEyeY() - 0.1, user.getZ(), velocity.x, velocity.y, velocity.z);
            entity.setItem(itemStack);
            entity.shootFromRotation(user, user.getRotationVector().x, user.getRotationVector().y, 0.0f, 1.5f, 1.0f);
            entity.setOwner(user);
            world.addFreshEntity(entity);
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        if (!user.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
    }


    private Vec3 getHorizontalVelocity(double bps, float pitch, float yaw) {
        Vec3 forward = Vec3.directionFromRotation(pitch, yaw);
        double x = forward.x / 20 * bps;
        double y = forward.y / 20 * bps;
        double z = forward.z / 20 * bps;
        return new Vec3(x, y, z);
    }
}
