package model.element.motionless;

import contract.Permeability;
import contract.iSprite;
import model.element.Sprite;

public class Dirt extends Motionless {
    private static iSprite SPRITE = new Sprite(' ', "Dirt.jpg");
    private static Boolean BREAKABLE = true;
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static Boolean EXPLOSABLE = true;

    public Dirt() {
        super(SPRITE, PERMEABILITY, EXPLOSABLE);
        this.setBreakable(BREAKABLE);
    }
}
