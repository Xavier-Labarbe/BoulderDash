package model.element.mobile;

import contract.ISprite;
import contract.Permeability;
import model.IPlayableMap;
import model.element.Sprite;

public class Rock extends FallingMobile {
    private static ISprite sprite = new Sprite('R', "Rock.jpg");
    private static Permeability permeability = Permeability.BLOCKING;
    private static Boolean explosable = true;

    public Rock(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

}
