package model.element.mobile;

import contract.IAliveMobile;
import contract.IFallingMobile;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;

public abstract class FallingMobile extends Mobile implements IFallingMobile {
    private static StrategyMove strategyMove = new MoveGravity();
    private Boolean falling = false;
    private Boolean frozen = false;

    public FallingMobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
    }

    @Override
    public Boolean isFalling() {
        return this.falling;
    }

    public Boolean isFrozen() {
        return this.frozen;
    }

    @Override
    public void kill(final IAliveMobile aliveMobile) {
        aliveMobile.setAlive(false);
        aliveMobile.getMap().addwaitingMobilesForRemoving(aliveMobile);

    }

    @Override
    public void setFalling(final Boolean falling) {
        this.falling = falling;
    }

    public void setFrozen(final Boolean frozen) {
        this.frozen = frozen;
    }

}
