package com.hollingsworth.ars_creo.common.contraption;

import com.simibubi.create.content.contraptions.components.structureMovement.MovementBehaviour;

public class AbstractTurretBehavior extends MovementBehaviour implements ITurretBehavior {

    @Override
    public boolean renderAsNormalTileEntity() {
        return true;
    }
}