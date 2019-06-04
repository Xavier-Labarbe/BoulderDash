package model.element.mobile;

import contract.IAliveMobile;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class AliveMobile.
 */
public class AliveMobile extends Mobile implements IAliveMobile {
    
    /** The alive. */
    private Boolean alive = true;

    /**
     * Instantiates a new alive mobile.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     * @param explosable the explosable
     * @param x the x
     * @param y the y
     * @param strategyMove the strategy move
     * @param map the map
     */
    public AliveMobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
    }

    /**
     * Checks if is alive.
     *
     * @return the boolean
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Sets the alive.
     *
     * @param alive the new alive
     */
    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;
    }

}
