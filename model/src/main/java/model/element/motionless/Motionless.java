package model.element.motionless;

import contract.Permeability;
import contract.ISprite;
import model.element.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class Motionless.
 */
public abstract class Motionless extends Element implements IMotionless {
    
    /** The breakable. */
    public Boolean breakable;

    /**
     * Instantiates a new motionless.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     * @param explosable the explosable
     * @param breakable the breakable
     */
    public Motionless(final ISprite sprite, final Permeability permeability, final Boolean explosable,
            final Boolean breakable) {
        super(sprite, permeability, explosable);
        this.breakable = breakable;
    }

    /**
     * Checks if is breakable.
     *
     * @return the boolean
     */
    @Override
    public Boolean isBreakable() {
        return this.breakable;
    }

}
