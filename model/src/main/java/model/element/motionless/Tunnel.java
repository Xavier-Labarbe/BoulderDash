package model.element.motionless;

import contract.Permeability;
import contract.ISprite;
import model.element.Sprite;

public class Tunnel extends Motionless {
    private static ISprite sprite = new Sprite('T', "Tunnel.jpg");
    private static Boolean breakable = false;
    private static Permeability premeability = Permeability.PENETRABLE;
    private static Boolean explosable = true;

    public Tunnel() {
        super(sprite, premeability, explosable, breakable);

    }
}
