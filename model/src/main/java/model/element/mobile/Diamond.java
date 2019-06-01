package model.element.mobile;

import contract.IDiamond;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class Diamond extends FallingMobile implements IDiamond {
    private static ISprite sprite = new Sprite("D", "diamond.png");
    private static Permeability permeability = Permeability.BLOCKING;
    private static Boolean explosable = true;

    public Diamond(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    public Diamond(final int x, final int y, final IPlayableMap map, final int nullParamater) {
        super(sprite, permeability, explosable, x, y, map);
    }
}
