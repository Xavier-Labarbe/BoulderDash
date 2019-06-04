package model.element.mobile;

import contract.IPlayableMap;
import contract.IRock;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Rock.
 */
public class Rock extends FallingMobile implements IRock {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("R", "rock.png");
    
    /** The permeability. */
    private static Permeability permeability = Permeability.BLOCKING;
    
    /** The explosable. */
    private static Boolean explosable = true;

    /**
     * Instantiates a new rock.
     *
     * @param x the x
     * @param y the y
     * @param map the map
     */
    public Rock(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

}
