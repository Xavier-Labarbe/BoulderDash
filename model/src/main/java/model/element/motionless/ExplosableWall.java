package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class ExplosableWall extends Motionless {
    private static ISprite sprite = new Sprite("W", "ExplosableWall.jpg");
    private static Boolean breakable = false;
    private static Permeability premeability = Permeability.BLOCKING;
    private static Boolean explosable = true;

    public ExplosableWall() {
        super(sprite, premeability, explosable, breakable);
    }
}
