package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;

public class Diamond extends FallingMobile {
    private static iSprite SPRITE = new Sprite('D', "Diamond.jpg");
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveGravity();

    public Diamond(final int x, final int y, final PlayableMap map) {
        super(SPRITE, PERMEABILITY, EXPLOSABLE, x, y, STRATEGY_MOVE);
        this.setMap(map);
        this.getMap().addMobiles(this);
    }

}