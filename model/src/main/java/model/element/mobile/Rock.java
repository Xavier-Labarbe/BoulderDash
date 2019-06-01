package model.element.mobile;

import contract.IPlayableMap;
import contract.IRock;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class Rock extends FallingMobile implements IRock {
    private static ISprite sprite = new Sprite("R", "rock.png");
    private static Permeability permeability = Permeability.BLOCKING;
    private static Boolean explosable = true;

    public Rock(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

}
