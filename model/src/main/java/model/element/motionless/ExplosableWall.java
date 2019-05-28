package model.element.motionless;

import contract.Permeability;
import contract.iSprite;
import model.element.Sprite;

public class ExplosableWall extends Motionless {
    private static iSprite SPRITE = new Sprite('W', "ExplosableWall.jpg");
    private static Boolean BREAKABLE = false;
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static Boolean EXPLOSABLE = true;

    public ExplosableWall() {
        super(SPRITE, PERMEABILITY, EXPLOSABLE);
        this.setBreakable(BREAKABLE);
    }
}
