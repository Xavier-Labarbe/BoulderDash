package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMobile.
 */
public interface IMobile extends IElement {

    /**
     * Gets the map.
     *
     * @return the map
     */
    IPlayableMap getMap();

    /**
     * Gets the x.
     *
     * @return the x
     */
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    int getY();

    /**
     * Move.
     */
    void move();

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    public void setMap(final IPlayableMap map);

    /**
     * Sets the x.
     *
     * @param x the coordinate x
     */
    void setX(int x);

    /**
     * Sets the y.
     *
     * @param y the coordinate y
     */
    void setY(int y);
}