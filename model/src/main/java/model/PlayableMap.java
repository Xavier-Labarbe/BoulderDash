package model;

import java.util.ArrayList;

import model.element.Element;
import model.element.mobile.Mobile;
import model.element.mobile.Player;

public class PlayableMap {
    private Element[][] elements;
    private final ArrayList<Mobile> mobiles;
    private Player player;
    private int width;
    private int height;

    private String label;

    public PlayableMap() {
        this.elements = new Element[10][10];
        this.mobiles = new ArrayList<Mobile>();
    }

    public void addMobiles(final Mobile mobile) {
        this.mobiles.add(mobile);
    }

    public Element[][] getElements() {
        return this.elements;

    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<Mobile> getMobiles() {
        return this.mobiles;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getWidth() {
        return this.width;
    }

    public Element getXYElement(final int x, final int y) {
        return this.elements[x][y];
    }

    public void removeMobiles(final Mobile mobile) {
        this.mobiles.remove(mobile);
    }

    public void setElements(final Element[][] elements) {
        this.elements = elements;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public void setXYElement(final int x, final int y, final Element element) {
        this.elements[x][y] = element;
    }
}
