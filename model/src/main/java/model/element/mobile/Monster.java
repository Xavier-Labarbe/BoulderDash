package model.element.mobile;

import contract.IAliveMobile;
import contract.IFallingMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;
import model.element.motionless.MotionlessFactory;

public class Monster extends AliveMobile implements IAliveMobile {
    private static ISprite sprite = new Sprite("M", "monster.png");
    private static Permeability permeability = Permeability.PENETRABLE;
    private static Boolean explosable = true;
    private static StrategyMove strategyMove = new MoveAuto();
    private int movingVector = 1;

    public Monster(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    public void createDiamonds() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable()) {
                    if (this.getMap().getXYElement(i, j) instanceof Mobile) {
                        this.getMap().addwaitingMobilesForRemoving((Mobile) this.getMap().getXYElement(i, j));
                        if (this.getMap().getXYElement(i, y - 2) instanceof IFallingMobile) {
                            ((Rock) this.getMap().getXYElement(i, y - 2)).setFrozen(true);
                        }
                    }
                    this.getMap().setXYElement(i, j, MotionlessFactory.createTunnel());
                    this.getMap().addwaitingMobilesForCreation(MobileFactory.createDiamond(i, j, this.getMap(), 0));

                }
            }
        }
    }

    public void explose() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable()) {
                    this.getMap().setXYElement(i, j, MotionlessFactory.createTunnel());
                }
            }
        }
    }

    public int getMovingVector() {
        return this.movingVector;
    }

    public void kill(final IPlayer player) {
        player.setAlive(false);
    }

    public void setMovingVector(final int movingVector) {
        this.movingVector = movingVector;
    }
}
