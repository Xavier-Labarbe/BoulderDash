package model.element.mobile;

import contract.IAliveMobile;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Monster extends AliveMobile implements IAliveMobile, IMonster {
    private static ISprite sprite = new Sprite('M', "Monster.jpg");
    private static Permeability permeability = Permeability.PENETRABLE;
    private static Boolean explosable = true;
    private static StrategyMove strategyMove = new MoveAuto();
    private int movingVector = 1;

    public Monster(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    @Override
    public void createDiamonds() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable()) {
                    if (this.getMap().getXYElement(i, j) instanceof Mobile) {
                        this.getMap().addwaitingMobilesForRemoving((Mobile) this.getMap().getXYElement(i, j));
                    }
                    this.getMap().addwaitingMobilesForCreation(new Diamond(i, j, this.getMap(), 0));
                }
            }
        }
    }

    @Override
    public void explose() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable()) {
                    this.getMap().setXYElement(i, j, new Tunnel());
                }
            }
        }
    }

    public int getMovingVector() {
        return this.movingVector;
    }

    public void kill(final Player player) {
        player.setAlive(false);
    }

    public void setMovingVector(final int movingVector) {
        this.movingVector = movingVector;
    }
}
