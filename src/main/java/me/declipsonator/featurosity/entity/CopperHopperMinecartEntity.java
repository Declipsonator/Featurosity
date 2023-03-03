package me.declipsonator.featurosity.entity;

import me.declipsonator.featurosity.Constants;
import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.Hopper;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.HopperMinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CopperHopperMinecartEntity extends HopperMinecartEntity {

    public CopperHopperMinecartEntity(EntityType<? extends HopperMinecartEntity> entity, World world) {
        super(entity, world);
    }


    public CopperHopperMinecartEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public static CopperHopperMinecartEntity createCopperHopperMinecart(EntityType<CopperHopperMinecartEntity> type, World world) {
        return new CopperHopperMinecartEntity(type, world);
    }

    @Override
    public boolean canOperate() {
        if (CopperHopperBlockEntity.extract(this.world, this)) {
            return true;
        }
        List<ItemEntity> list = this.world.getEntitiesByClass(ItemEntity.class, this.getBoundingBox().expand(0.25, 0.0, 0.25), EntityPredicates.VALID_ENTITY);
        if (!list.isEmpty()) {
            CopperHopperBlockEntity.extract(this, list.get(0));
        }
        return false;
    }

    @Override
    public Item getItem() {
        return Constants.COPPER_HOPPER_MINECART_ITEM;
    }

    @Override
    public EntityType<?> getType() {
        return Constants.COPPER_HOPPER_MINECART_ENTITY;
    }

    @Override
    public Text getName() {
        return Text.translatable("entity.copper_hopper_minecart");
    }

    @Override
    public BlockState getDefaultContainedBlock() {
        return Constants.COPPER_HOPPER.getDefaultState();
    }

    @Override
    public void setTransferCooldown(int transferCooldown) {
        super.setTransferCooldown(0);
    }

    @Override
    public void tick() {
        super.tick();
        super.tick();

    }
}
