package model;

import java.util.ArrayList;

import contract.IElement;
import contract.IExit;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import model.element.Element;

public class PlayableMap implements IPlayableMap {
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

    public PlayableMap(final int numberOfDiamondForWin) {
        this.elements = new Element[10][10];
        this.mobiles = new ArrayList<IMobile>();
        this.waitingMobilesForCreation = new ArrayList<IMobile>();
        this.waitingMobilesForRemoving = new ArrayList<IMobile>();
        this.setNumberOfDiamondForWin(numberOfDiamondForWin);
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

    @Override
    public ArrayList<IMobile> getMobiles() {
        return this.mobiles;
    }

    @Override
    public int getNumberOfDiamondForWin() {
        return this.numberOfDiamondForWin;
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
    public Boolean getWin() {
        return this.win;
    }

    @Override
    public IElement getXYElement(final int x, final int y) {
        return this.elements[x][y];
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
    }
}
