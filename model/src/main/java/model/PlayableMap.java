package model;

import java.util.ArrayList;

import model.element.Element;
import model.element.mobile.Mobile;

public class PlayableMap {
    private Element[][] elements;
    private final ArrayList<Mobile> mobiles;

    private String label;

    public PlayableMap() {
        this.elements = new Element[20][20];
        this.mobiles = new ArrayList<Mobile>();
    }

    public void addMobiles(final Mobile mobile) {
        this.mobiles.add(mobile);
    }

    public Element[][] getElements() {
        return this.elements;

    }

    public ArrayList<Mobile> getMobiles() {
        return this.mobiles;
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

    public void setXYElement(final int x, final int y, final Element element) {
        this.elements[x][y] = element;
    }
}
