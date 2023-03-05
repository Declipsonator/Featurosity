package me.declipsonator.featurosity.entity;

import me.declipsonator.featurosity.block.entity.CopperHopperBlockEntity;
import me.declipsonator.featurosity.registry.FeaturosityBlocks;
import me.declipsonator.featurosity.registry.FeaturosityEntities;
import me.declipsonator.featurosity.registry.FeaturosityItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.vehicle.MinecartHopper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class CopperHopperMinecartEntity extends MinecartHopper {

    public CopperHopperMinecartEntity(EntityType<? extends MinecartHopper> entity, Level world) {
        super(entity, world);
    }


    public CopperHopperMinecartEntity(Level world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public static CopperHopperMinecartEntity createCopperHopperMinecart(EntityType<CopperHopperMinecartEntity> type, Level world) {
        return new CopperHopperMinecartEntity(type, world);
    }

    @Override
    public boolean suckInItems() {
        if (CopperHopperBlockEntity.suckInItems(this.level, this)) {
            return true;
        }
        List<ItemEntity> list = this.level.getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(0.25, 0.0, 0.25), EntitySelector.ENTITY_STILL_ALIVE);
        if (!list.isEmpty()) {
            CopperHopperBlockEntity.addItem(this, list.get(0));
        }
        return false;
    }

    @Override
    public Item getDropItem() {
        return FeaturosityItems.COPPER_HOPPER_MINECART_ITEM.get();
    }

    @Override
    public EntityType<?> getType() {
        return FeaturosityEntities.COPPER_HOPPER_MINECART_ENTITY.get();
    }

    @Override
    public Component getName() {
        return Component.translatable("entity.copper_hopper_minecart");
    }

    @Override
    public BlockState getDefaultDisplayBlockState() {
        return FeaturosityBlocks.COPPER_HOPPER.get().defaultBlockState();
    }

    @Override
    public void tick() {
        super.tick();
        super.tick();

    }
}
