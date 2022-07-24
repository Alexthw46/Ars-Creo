package com.hollingsworth.ars_creo.client.render;

import com.hollingsworth.ars_creo.ArsCreo;
import com.hollingsworth.ars_creo.common.block.CarbuncleWheelBlock;
import com.hollingsworth.ars_creo.common.block.CarbuncleWheelTile;
import com.hollingsworth.ars_creo.common.registry.ModBlockRegistry;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class CarbuncleWheelModel extends AnimatedGeoModel<CarbuncleWheelTile> {


    @Override
    public void setLivingAnimations(CarbuncleWheelTile entity, Integer uniqueID) {
        super.setLivingAnimations(entity, uniqueID);
    }

    @Override
    public void setLivingAnimations(CarbuncleWheelTile entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("wheel");
        Direction facing = entity.getBlockState().getValue(CarbuncleWheelBlock.FACING);
        float angle = getAngleForTe(entity, entity.getBlockPos(), ModBlockRegistry.CARBY_WHEEL.getRotationAxis(entity.getBlockState()));
        if(facing ==  Direction.SOUTH || facing == Direction.EAST) {
            angle = -angle;
        }
        head.setRotationY( angle);
    }

    public static float getAngleForTe(KineticTileEntity te, final BlockPos pos, Direction.Axis axis) {
        float time = AnimationTickHolder.getRenderTime(te.getLevel());
        float offset = getRotationOffsetForPosition(te, pos, axis);
        return ((time * te.getSpeed() * 3f / 10 + offset) % 360) / 180 * (float) Math.PI;
    }
    protected static float getRotationOffsetForPosition(KineticTileEntity te, final BlockPos pos, final Direction.Axis axis) {
        float offset = ICogWheel.isLargeCog(te.getBlockState()) ? 11.25f : 0;
        double d = (((axis == Direction.Axis.X) ? 0 : pos.getX()) + ((axis == Direction.Axis.Y) ? 0 : pos.getY())
                + ((axis == Direction.Axis.Z) ? 0 : pos.getZ())) % 2;
        if (d == 0) {
            offset = 22.5f;
        }
        return offset;
    }

    @Override
    public ResourceLocation getModelLocation(CarbuncleWheelTile object) {
        return new ResourceLocation(ArsCreo.MODID, "geo/starbuncle_wheel.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CarbuncleWheelTile object) {
        return new ResourceLocation(ArsCreo.MODID, "textures/blocks/starbuncle_wheel.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CarbuncleWheelTile animatable) {
        return new ResourceLocation(ArsCreo.MODID, "animations/starbuncle_wheel_animation.json");
    }
}