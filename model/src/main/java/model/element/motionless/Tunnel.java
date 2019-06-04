package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Tunnel.
 */
public class Tunnel extends Motionless {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("T", "tunnel.png");
    
    /** The breakable. */
    private static Boolean breakable = false;
    
    /** The premeability. */
    private static Permeability premeability = Permeability.PENETRABLE;
    
    /** The explosable. */
    private static Boolean explosable = false;

    /**
     * Instantiates a new tunnel.
     */
    public Tunnel() {
        super(sprite, premeability, explosable, breakable);

    }
}
