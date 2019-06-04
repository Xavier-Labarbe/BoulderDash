package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.IElement;
import contract.IExit;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import model.element.Element;

public class PlayableMap extends Observable implements IPlayableMap {
    private IElement[][] elements;
    private final ArrayList<IMobile> mobiles;
    private final ArrayList<IMobile> waitingMobilesForCreation;
    private final ArrayList<IMobile> waitingMobilesForRemoving;
    private IPlayer player;
    private IExit exit;
    private Boolean win = false;

    private int numberOfDiamondForWin;

    private int width;

    private int height;

    private String label;
    private int id;

    public PlayableMap(final int numberOfDiamondForWin, final int width, final int height, final int id) {
        this.elements = new Element[width][height];
        this.width = width;
        this.height = height;
        this.mobiles = new ArrayList<IMobile>();
        this.waitingMobilesForCreation = new ArrayList<IMobile>();
        this.waitingMobilesForRemoving = new ArrayList<IMobile>();
        this.setNumberOfDiamondForWin(numberOfDiamondForWin);
        this.setId(id);
    }

    @Override
    public void addMobiles(final IMobile mobile) {
        this.mobiles.add(mobile);
    }

    @Override
    public void addwaitingMobilesForCreation(final IMobile mobile) {
        this.waitingMobilesForCreation.add(mobile);
    }

    @Override
    public void addwaitingMobilesForRemoving(final IMobile mobile) {
        this.waitingMobilesForRemoving.add(mobile);
    }

    @Override
    public IElement[][] getElements() {
        return this.elements;

    }

    @Override
    public IExit getExit() {
        return this.exit;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public ArrayList<IMobile> getMobiles() {
        return this.mobiles;
    }

    @Override
    public int getNumberOfDiamondForWin() {
        return this.numberOfDiamondForWin;
    }

    @Override
    public Observable getObservable() {
        return this;
    }

    @Override
    public IPlayer getPlayer() {
        return this.player;
    }

    @Override
    public ArrayList<IMobile> getWaitingMobilesForCreation() {
        return this.waitingMobilesForCreation;
    }

    @Override
    public ArrayList<IMobile> getWaitingMobilesForRemoving() {
        return this.waitingMobilesForRemoving;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public IElement getXYElement(final int x, final int y) {
        return this.elements[x][y];
    }

    @Override
    public Boolean isWin() {
        return this.win;
    }

    @Override
    public void removeMobiles(final IMobile mobile) {
        this.mobiles.remove(mobile);
    }

    @Override
    public void setElements(final IElement[][] elements) {
        this.elements = elements;
    }

    @Override
    public void setExit(final IExit exit) {
        this.exit = exit;
    }

    @Override
    public void setHeight(final int height) {
        this.height = height;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Override
    public void setNumberOfDiamondForWin(final int numberOfDiamondForWin) {
        this.numberOfDiamondForWin = numberOfDiamondForWin;
    }

    @Override
    public void setPlayer(final IPlayer player) {
        this.player = player;
    }

    @Override
    public void setWidth(final int width) {
        this.width = width;
    }

    @Override
    public void setWin(final Boolean win) {
        this.win = win;
    }

    @Override
    public void setXYElement(final int x, final int y, final IElement element) {
        this.elements[x][y] = element;
        this.notifyObservers();
        this.setChanged();
    }
}
