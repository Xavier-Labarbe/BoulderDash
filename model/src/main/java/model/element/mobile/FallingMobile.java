package model.element.mobile;

import contract.Permeability;
import contract.iSprite;

public abstract class FallingMobile extends Mobile implements IFallingMobile {
    private Boolean falling = false;

    public FallingMobile(final iSprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove) {
        super(sprite, permeability, explosable, x, y, strategyMove);
    }

    @Override
    public Boolean isFalling() {
        return this.falling;
    }

    @Override
    public void kill(final AliveMobile aliveMobile) {
        aliveMobile.setAlive(false);
        aliveMobile.getMap().addwaitingMobilesForRemoving(aliveMobile);
        // aliveMobile.getMap().setXYElement(aliveMobile.getX(), aliveMobile.getY(), new
        // Tunnel());

        System.out.println("kill");
    }

    @Override
    public void setFalling(final Boolean falling) {
        this.falling = falling;
    }

}
