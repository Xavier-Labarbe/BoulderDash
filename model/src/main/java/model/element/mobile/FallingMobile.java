package model.element.mobile;

import contract.IAliveMobile;
import contract.IFallingMobile;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class FallingMobile.
 */
public abstract class FallingMobile extends Mobile implements IFallingMobile {
    
    /** The strategy move. */
    private static StrategyMove strategyMove = new MoveGravity();
    
    /** The falling. */
    private Boolean falling = false;
    
    /** The frozen. */
    private Boolean frozen = false;

    /**
     * Instantiates a new falling mobile.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     * @param explosable the explosable
     * @param x the x
     * @param y the y
     * @param map the map
     */
    public FallingMobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
    }

    /**
     * Checks if is falling.
     *
     * @return the boolean
     */
    @Override
    public Boolean isFalling() {
        return this.falling;
    }

    /**
     * Checks if is frozen.
     *
     * @return the boolean
     */
    public Boolean isFrozen() {
        return this.frozen;
    }

    /**
     * Kill.
     *
     * @param aliveMobile the alive mobile
     */
    @Override
    public void kill(final IAliveMobile aliveMobile) {
        aliveMobile.setAlive(false);
        aliveMobile.getMap().addwaitingMobilesForRemoving(aliveMobile);

    }

    /**
     * Sets the falling.
     *
     * @param falling the new falling
     */
    @Override
    public void setFalling(final Boolean falling) {
        this.falling = falling;
    }

    /**
     * Sets the frozen.
     *
     * @param frozen the new frozen
     */
    public void setFrozen(final Boolean frozen) {
        this.frozen = frozen;
    }

}
