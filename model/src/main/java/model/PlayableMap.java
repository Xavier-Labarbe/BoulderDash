package model;

import java.util.ArrayList;

import model.element.Element;
import model.element.mobile.IMobile;
import model.element.mobile.Mobile;
import model.element.mobile.Player;
import model.element.motionless.Exit;

public class PlayableMap {
    private Element[][] elements;
    private final ArrayList<Mobile> mobiles;
    private final ArrayList<Mobile> waitingMobilesForCreation;
    private final ArrayList<Mobile> waitingMobilesForRemoving;
    private Player player;
    private Exit exit;
    private Boolean win = false;

    private int numberOfDiamondForWin;

    private int width;

    private int height;

    private String label;

    public PlayableMap(final int numberOfDiamondForWin) {
        this.elements = new Element[10][10];
        this.mobiles = new ArrayList<Mobile>();
        this.waitingMobilesForCreation = new ArrayList<Mobile>();
        this.waitingMobilesForRemoving = new ArrayList<Mobile>();
        this.setNumberOfDiamondForWin(numberOfDiamondForWin);
    }

    public void addMobiles(final Mobile mobile) {
        this.mobiles.add(mobile);
    }

    public void addwaitingMobilesForCreation(final Mobile mobile) {
        this.waitingMobilesForCreation.add(mobile);
    }

    public void addwaitingMobilesForRemoving(final Mobile mobile) {
        this.waitingMobilesForRemoving.add(mobile);
    }

    public Element[][] getElements() {
        return this.elements;

    }

    public Exit getExit() {
        return this.exit;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<Mobile> getMobiles() {
        return this.mobiles;
    }

    public int getNumberOfDiamondForWin() {
        return this.numberOfDiamondForWin;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Mobile> getWaitingMobilesForCreation() {
        return this.waitingMobilesForCreation;
    }

    public ArrayList<Mobile> getWaitingMobilesForRemoving() {
        return this.waitingMobilesForRemoving;
    }

    public int getWidth() {
        return this.width;
    }

    public Boolean getWin() {
        return this.win;
    }

    public Element getXYElement(final int x, final int y) {
        return this.elements[x][y];
    }

    public void removeMobiles(final IMobile mobile) {
        this.mobiles.remove(mobile);
    }

    public void setElements(final Element[][] elements) {
        this.elements = elements;
    }

    public void setExit(final Exit exit) {
        this.exit = exit;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public void setNumberOfDiamondForWin(final int numberOfDiamondForWin) {
        this.numberOfDiamondForWin = numberOfDiamondForWin;
    }

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public void setWin(final Boolean win) {
        this.win = win;
    }

    public void setXYElement(final int x, final int y, final Element element) {
        this.elements[x][y] = element;
    }
}
