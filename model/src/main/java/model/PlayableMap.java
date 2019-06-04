package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.IElement;
import contract.IExit;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import model.element.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayableMap.
 */
public class PlayableMap extends Observable implements IPlayableMap {
    
    /** The elements. */
    private IElement[][] elements;
    
    /** The mobiles. */
    private final ArrayList<IMobile> mobiles;
    
    /** The waiting mobiles for creation. */
    private final ArrayList<IMobile> waitingMobilesForCreation;
    
    /** The waiting mobiles for removing. */
    private final ArrayList<IMobile> waitingMobilesForRemoving;
    
    /** The player. */
    private IPlayer player;
    
    /** The exit. */
    private IExit exit;
    
    /** The win. */
    private Boolean win = false;

    /** The number of diamond for win. */
    private int numberOfDiamondForWin;

    /** The width. */
    private int width;

    /** The height. */
    private int height;

    /**
     * Instantiates a new playable map.
     *
     * @param numberOfDiamondForWin the number of diamond for win
     * @param width the width
     * @param height the height
     */
    public PlayableMap(final int numberOfDiamondForWin, final int width, final int height) {
        this.elements = new Element[width][height];
        this.width = width;
        this.height = height;
        this.mobiles = new ArrayList<IMobile>();
        this.waitingMobilesForCreation = new ArrayList<IMobile>();
        this.waitingMobilesForRemoving = new ArrayList<IMobile>();
        this.setNumberOfDiamondForWin(numberOfDiamondForWin);
    }

    /**
     * Adds the mobiles.
     *
     * @param mobile the mobile
     */
    @Override
    public void addMobiles(final IMobile mobile) {
        this.mobiles.add(mobile);
    }

    /**
     * Addwaiting mobiles for creation.
     *
     * @param mobile the mobile
     */
    @Override
    public void addwaitingMobilesForCreation(final IMobile mobile) {
        this.waitingMobilesForCreation.add(mobile);
    }

    /**
     * Addwaiting mobiles for removing.
     *
     * @param mobile the mobile
     */
    @Override
    public void addwaitingMobilesForRemoving(final IMobile mobile) {
        this.waitingMobilesForRemoving.add(mobile);
    }

    /**
     * Gets the elements.
     *
     * @return the elements
     */
    @Override
    public IElement[][] getElements() {
        return this.elements;

    }

    /**
     * Gets the exit.
     *
     * @return the exit
     */
    @Override
    public IExit getExit() {
        return this.exit;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the mobiles.
     *
     * @return the mobiles
     */
    @Override
    public ArrayList<IMobile> getMobiles() {
        return this.mobiles;
    }

    /**
     * Gets the number of diamond for win.
     *
     * @return the number of diamond for win
     */
    @Override
    public int getNumberOfDiamondForWin() {
        return this.numberOfDiamondForWin;
    }

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    @Override
    public Observable getObservable() {
        return this;
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    @Override
    public IPlayer getPlayer() {
        return this.player;
    }

    /**
     * Gets the waiting mobiles for creation.
     *
     * @return the waiting mobiles for creation
     */
    @Override
    public ArrayList<IMobile> getWaitingMobilesForCreation() {
        return this.waitingMobilesForCreation;
    }

    /**
     * Gets the waiting mobiles for removing.
     *
     * @return the waiting mobiles for removing
     */
    @Override
    public ArrayList<IMobile> getWaitingMobilesForRemoving() {
        return this.waitingMobilesForRemoving;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * Gets the XY element.
     *
     * @param x the x
     * @param y the y
     * @return the XY element
     */
    @Override
    public IElement getXYElement(final int x, final int y) {
        return this.elements[x][y];
    }

    /**
     * Checks if is win.
     *
     * @return the boolean
     */
    @Override
    public Boolean isWin() {
        return this.win;
    }

    /**
     * Removes the mobiles.
     *
     * @param mobile the mobile
     */
    @Override
    public void removeMobiles(final IMobile mobile) {
        this.mobiles.remove(mobile);
    }

    /**
     * Sets the elements.
     *
     * @param elements the new elements
     */
    @Override
    public void setElements(final IElement[][] elements) {
        this.elements = elements;
    }

    /**
     * Sets the exit.
     *
     * @param exit the new exit
     */
    @Override
    public void setExit(final IExit exit) {
        this.exit = exit;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    @Override
    public void setHeight(final int height) {
        this.height = height;
    }

    /**
     * Sets the number of diamond for win.
     *
     * @param numberOfDiamondForWin the new number of diamond for win
     */
    @Override
    public void setNumberOfDiamondForWin(final int numberOfDiamondForWin) {
        this.numberOfDiamondForWin = numberOfDiamondForWin;
    }

    /**
     * Sets the player.
     *
     * @param player the new player
     */
    @Override
    public void setPlayer(final IPlayer player) {
        this.player = player;
    }

    /**
     * Sets the width.
     *
     * @param width the new width
     */
    @Override
    public void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Sets the win.
     *
     * @param win the new win
     */
    @Override
    public void setWin(final Boolean win) {
        this.win = win;
    }

    /**
     * Sets the XY element.
     *
     * @param x the x
     * @param y the y
     * @param element the element
     */
    @Override
    public void setXYElement(final int x, final int y, final IElement element) {
        this.elements[x][y] = element;
        this.notifyObservers();
        this.setChanged();
    }
}
