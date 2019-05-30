package model.element.motionless;

import contract.Permeability;
import contract.ISprite;
import model.element.Element;

public abstract class Motionless extends Element implements IMotionless {
    public Boolean breakable;

    public Motionless(final ISprite sprite, final Permeability permeability, final Boolean explosable,
            final Boolean breakable) {
        super(sprite, permeability, explosable);
        this.breakable = breakable;
    }

    @Override
    public Boolean isBreakable() {
        return this.breakable;
    }

}
