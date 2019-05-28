package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Monster extends AliveMobile {
    private static iSprite SPRITE = new Sprite('M', "Monster.jpg");
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveAuto();

    public Monster(final int x, final int y, final PlayableMap map) {
        super(SPRITE, PERMEABILITY, EXPLOSABLE, x, y, STRATEGY_MOVE);
        this.setMap(map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    public void createDiamonds() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable() == true) {
                    this.getMap().setXYElement(i, j, new Diamond(i, j, this.getMap()));
                }
            }
        }
    }

    public void explose() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable() == true) {
                    this.getMap().setXYElement(i, j, new Tunnel());
                }
            }
        }
    }

    public void kill(final Player player) {
        player.setAlive(false);
    }

    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;
    }

}
