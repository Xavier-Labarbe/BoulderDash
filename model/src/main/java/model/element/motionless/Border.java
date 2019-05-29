package model.element.motionless;

import contract.Permeability;
import contract.iSprite;
import model.element.Sprite;

public class Border extends Motionless {
    private static iSprite SPRITE = new Sprite('|', "Border.jpg");
    private static Boolean BREAKABLE = false;
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static Boolean EXPLOSABLE = false;

    public Border() {
        super(SPRITE, PERMEABILITY, EXPLOSABLE);
        this.setBreakable(BREAKABLE);
    }

}
