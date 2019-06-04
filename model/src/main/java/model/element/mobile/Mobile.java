package model.element.mobile;

import contract.IMobile;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;
import model.element.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class Mobile.
 */
public abstract class Mobile extends Element implements IMobile {
    
    /** The x. */
    private int x;
    
    /** The y. */
    private int y;
    
    /** The strategy move. */
    private final StrategyMove strategyMove;
    
    /** The map. */
    private IPlayableMap map;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     * @param explosable the explosable
     * @param x the x
     * @param y the y
     * @param strategyMove the strategy move
     * @param map the map
     */
    public Mobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove, final IPlayableMap map) {
        super(sprite, permeability, explosable);
        this.map = map;
        this.strategyMove = strategyMove;
        this.x = x;
        this.y = y;

    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    @Override
    public IPlayableMap getMap() {
        return this.map;
    }

    /**
     * Gets the strategy move.
     *
     * @return the strategy move
     */
    public StrategyMove getStrategyMove() {
        return this.strategyMove;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Move.
     */
    @Override
    public void move() {
        this.strategyMove.move(this);
    }

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    public void setMap(final IPlayableMap map) {
        this.map = map;
    }

    /**
     * Sets the x.
     *
     * @param x the new x
     */
    @Override
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Sets the y.
     *
     * @param y the new y
     */
    @Override
    public void setY(final int y) {
        this.y = y;
    }

}
