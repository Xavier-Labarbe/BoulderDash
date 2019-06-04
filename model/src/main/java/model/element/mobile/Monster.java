package model.element.mobile;

import contract.IAliveMobile;
import contract.IFallingMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;
import model.element.motionless.MotionlessFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Monster.
 */
public class Monster extends AliveMobile implements IAliveMobile {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("M", "monster.png");
    
    /** The permeability. */
    private static Permeability permeability = Permeability.PENETRABLE;
    
    /** The explosable. */
    private static Boolean explosable = true;
    
    /** The strategy move. */
    private static StrategyMove strategyMove = new MoveAuto();
    
    /** The moving vector. */
    private int movingVector = 1;

    /**
     * Instantiates a new monster.
     *
     * @param x the x
     * @param y the y
     * @param map the map
     */
    public Monster(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    /**
     * Creates the diamonds.
     */
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

    /**
     * Explose.
     */
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

    /**
     * Gets the moving vector.
     *
     * @return the moving vector
     */
    public int getMovingVector() {
        return this.movingVector;
    }

    /**
     * Kill.
     *
     * @param player the player
     */
    public void kill(final IPlayer player) {
        player.setAlive(false);
    }

    /**
     * Sets the moving vector.
     *
     * @param movingVector the new moving vector
     */
    public void setMovingVector(final int movingVector) {
        this.movingVector = movingVector;
    }
}
