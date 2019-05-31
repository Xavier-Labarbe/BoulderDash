package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class Dirt extends Motionless {
    private static ISprite sprite = new Sprite(" ", "Dirt.jpg");
    private static Boolean breakable = true;
    private static Permeability premeability = Permeability.BLOCKING;
    private static Boolean explosable = true;

    public Dirt() {
        super(sprite, premeability, explosable, breakable);

    }
}
