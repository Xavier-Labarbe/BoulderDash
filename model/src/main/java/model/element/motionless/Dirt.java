package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Dirt.
 */
public class Dirt extends Motionless {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite(" ", "dirt.png");
    
    /** The breakable. */
    private static Boolean breakable = true;
    
    /** The premeability. */
    private static Permeability premeability = Permeability.BLOCKING;
    
    /** The explosable. */
    private static Boolean explosable = true;

    /**
     * Instantiates a new dirt.
     */
    public Dirt() {
        super(sprite, premeability, explosable, breakable);

    }
}
