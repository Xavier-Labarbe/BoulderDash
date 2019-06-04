package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPlayer.
 */
public interface IPlayer extends IAliveMobile {

    /**
     * Dig tunnel.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    void digTunnel(int x, int y);

    /**
     * Gets the moving order.
     *
     * @return the moving order
     */
    ControllerOrder getMovingOrder();

    /**
     * Gets the number of taken diamond.
     *
     * @return the number of taken diamond
     */
    int getNumberOfTakenDiamond();

    /**
     * Pickup diamond.
     *
     * @param diamond the diamond
     */
    void pickupDiamond(IDiamond diamond);

    /**
     * Push rock.
     *
     * @param rock the rock
     */
    void pushRock(IRock rock);

    /**
     * Sets the moving order.
     *
     * @param movingOrder the new moving order
     */
    void setMovingOrder(ControllerOrder movingOrder);

    /**
     * Sets the number of taken diamond.
     *
     * @param numberOfTakenDiamond the new number of taken diamond
     */
    void setNumberOfTakenDiamond(int numberOfTakenDiamond);

}