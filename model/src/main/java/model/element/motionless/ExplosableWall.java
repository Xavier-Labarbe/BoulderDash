package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class ExplosableWall.
 */
public class ExplosableWall extends Motionless {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("W", "explosableWall.png");
    
    /** The breakable. */
    private static Boolean breakable = false;
    
    /** The premeability. */
    private static Permeability premeability = Permeability.BLOCKING;
    
    /** The explosable. */
    private static Boolean explosable = true;

    /**
     * Instantiates a new explosable wall.
     */
    public ExplosableWall() {
        super(sprite, premeability, explosable, breakable);
    }
}
