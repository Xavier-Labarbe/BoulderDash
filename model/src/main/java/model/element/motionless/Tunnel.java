package model.element.motionless;

import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class Tunnel extends Motionless {
    private static ISprite sprite = new Sprite("T", "tunnel.png");
    private static Boolean breakable = false;
    private static Permeability premeability = Permeability.PENETRABLE;
    private static Boolean explosable = true;

    public Tunnel() {
        super(sprite, premeability, explosable, breakable);

    }
}
