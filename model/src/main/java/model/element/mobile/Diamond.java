package model.element.mobile;

import contract.IDiamond;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Diamond.
 */
public class Diamond extends FallingMobile implements IDiamond {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("D", "diamond.png");
    
    /** The permeability. */
    private static Permeability permeability = Permeability.BLOCKING;
    
    /** The explosable. */
    private static Boolean explosable = true;

    /**
     * Instantiates a new diamond.
     *
     * @param x the x
     * @param y the y
     * @param map the map
     */
    public Diamond(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    /**
     * Instantiates a new diamond.
     *
     * @param x the x
     * @param y the y
     * @param map the map
     * @param nullParamater the null paramater
     */
    public Diamond(final int x, final int y, final IPlayableMap map, final int nullParamater) {

        super(sprite, permeability, explosable, x, y, map);
        this.getMap().setXYElement(x, y, this);
    }
}
