package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class Border extends Motionless {
    private static ISprite sprite = new Sprite("|", "border.png");
    private static Boolean breakable = false;
    private static Permeability premeability = Permeability.BLOCKING;
    private static Boolean explosable = false;

    public Border() {
        super(sprite, premeability, explosable, breakable);

    }

}
