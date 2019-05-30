package model.element.mobile;

import contract.ISprite;
import contract.Permeability;
import model.IPlayableMap;

public abstract class FallingMobile extends Mobile implements IFallingMobile {
    private static StrategyMove strategyMove = new MoveGravity();
    private Boolean falling = false;

    public FallingMobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
    }

    @Override
    public Boolean isFalling() {
        return this.falling;
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

}
