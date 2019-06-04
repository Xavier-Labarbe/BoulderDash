package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Border.
 */
public class Border extends Motionless {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("|", "border.png");
    
    /** The breakable. */
    private static Boolean breakable = false;
    
    /** The permeability. */
    private static Permeability permeability = Permeability.BLOCKING;
    
    /** The explosable. */
    private static Boolean explosable = false;

    /**
     * Instantiates a new border.
     */
    public Border() {
        super(sprite, permeability, explosable, breakable);

    }

}
