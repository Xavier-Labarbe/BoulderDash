package model.element.motionless;

import contract.Permeability;
import contract.iSprite;
import model.element.Element;

public abstract class Motionless extends Element {
    public boolean breakable;

    public Motionless(final iSprite sprite, final Permeability permeability, final Boolean explosable) {
        super(sprite, permeability, explosable);
    }

    public boolean getBreakable() {
        return this.breakable;
    }

    public void setBreakable(final Boolean breakable) {
        this.breakable = breakable;
    }
}
