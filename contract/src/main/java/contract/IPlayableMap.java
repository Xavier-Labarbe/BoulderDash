package contract;

import java.util.ArrayList;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPlayableMap.
 */
public interface IPlayableMap {

    /**
     * Adds the mobiles.
     *
     * @param mobile the mobile
     */
    void addMobiles(IMobile mobile);

    /**
     * Addwaiting mobiles for creation.
     *
     * @param mobile the mobile
     */
    void addwaitingMobilesForCreation(IMobile mobile);

    /**
     * Addwaiting mobiles for removing.
     *
     * @param mobile the mobile
     */
    void addwaitingMobilesForRemoving(IMobile mobile);

    /**
     * Gets the elements.
     *
     * @return the elements
     */
    IElement[][] getElements();

    /**
     * Gets the exit.
     *
     * @return the exit
     */
    IExit getExit();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the mobiles.
     *
     * @return the mobiles
     */
    ArrayList<IMobile> getMobiles();

    /**
     * Gets the number of diamond for win.
     *
     * @return the number of diamond for win
     */
    int getNumberOfDiamondForWin();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

    /**
     * Gets the player.
     *
     * @return the player
     */
    IPlayer getPlayer();

    /**
     * Gets the waiting mobiles for creation.
     *
     * @return the waiting mobiles for creation
     */
    ArrayList<IMobile> getWaitingMobilesForCreation();

    /**
     * Gets the waiting mobiles for removing.
     *
     * @return the waiting mobiles for removing
     */
    ArrayList<IMobile> getWaitingMobilesForRemoving();

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the XY element.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @return the XY element
     */
    IElement getXYElement(int x, int y);

    /**
     * Checks if is win.
     *
     * @return the boolean
     */
    Boolean isWin();

    /**
     * Removes the mobiles.
     *
     * @param mobile the mobile
     */
    void removeMobiles(IMobile mobile);

    /**
     * Sets the elements.
     *
     * @param elements the new elements
     */
    void setElements(IElement[][] elements);

    /**
     * Sets the exit.
     *
     * @param exit the new exit
     */
    void setExit(IExit exit);

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    void setHeight(int height);

    /**
     * Sets the number of diamond for win.
     *
     * @param numberOfDiamondForWin the new number of diamond for win
     */
    void setNumberOfDiamondForWin(int numberOfDiamondForWin);

    /**
     * Sets the player.
     *
     * @param player the new player
     */
    void setPlayer(IPlayer player);

    /**
     * Sets the width.
     *
     * @param width the new width
     */
    void setWidth(int width);

    /**
     * Sets the win.
     *
     * @param win the new win
     */
    void setWin(Boolean win);

    /**
     * Sets the XY element.
     *
     * @param x       the x
     * @param y       the y
     * @param element the element
     */
    void setXYElement(int x, int y, IElement element);

}