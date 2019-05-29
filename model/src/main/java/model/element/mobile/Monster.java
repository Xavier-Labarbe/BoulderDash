package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;

public class Monster extends AliveMobile {
    private static iSprite SPRITE = new Sprite("M", "Monster.jpg");
    private static Permeability PERMEABILITY = Permeability.PENETRABLE;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveAuto();

    public Monster(final int x, final int y, final PlayableMap map) {
        super(SPRITE, PERMEABILITY, EXPLOSABLE, x, y, STRATEGY_MOVE);
        this.setMap(map);
        this.getMap().addMobiles(this);
    }

    public void createDiamonds() {

    }

    public void kill(final Player player) {

    }

    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;
    }

}
