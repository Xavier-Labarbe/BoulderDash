package model.element.mobile;

import contract.ControllerOrder;
import contract.IDiamond;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.IRock;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;
import model.element.motionless.MotionlessFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player extends AliveMobile implements IPlayer {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("P", "player.png");
    
    /** The permeability. */
    private static Permeability permeability = Permeability.PENETRABLE;
    
    /** The explosable. */
    private static Boolean explosable = true;
    
    /** The strategy move. */
    private static StrategyMove strategyMove = new MoveInput();

    /** The number of taken diamond. */
    private int numberOfTakenDiamond = 0;

    /** The moving order. */
    private ControllerOrder movingOrder = ControllerOrder.NOTHING;

    /**
     * Instantiates a new player.
     *
     * @param x the x
     * @param y the y
     * @param map the map
     */
    public Player(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().setPlayer(this);
        this.getMap().addMobiles(this);
    }

    /**
     * Dig tunnel.
     *
     * @param x the x
     * @param y the y
     */
    @Override
    public void digTunnel(final int x, final int y) {
        this.getMap().setXYElement(x, y, MotionlessFactory.createTunnel());
    }

    /**
     * Gets the moving order.
     *
     * @return the moving order
     */
    @Override
    public ControllerOrder getMovingOrder() {
        return this.movingOrder;
    }

    /**
     * Gets the number of taken diamond.
     *
     * @return the number of taken diamond
     */
    @Override
    public int getNumberOfTakenDiamond() {
        return this.numberOfTakenDiamond;
    }

    /**
     * Pickup diamond.
     *
     * @param diamond the diamond
     */
    @Override
    public void pickupDiamond(final IDiamond diamond) {
        this.getMap().setXYElement(diamond.getX(), diamond.getY(), MotionlessFactory.createTunnel());
        this.getMap().addwaitingMobilesForRemoving(diamond);
        this.setNumberOfTakenDiamond(this.getNumberOfTakenDiamond() + 1);
        if (this.getNumberOfTakenDiamond() == this.getMap().getNumberOfDiamondForWin()) {
            this.getMap().getExit().open();
        }

    }

    /**
     * Push rock.
     *
     * @param rock the rock
     */
    @Override
    public void pushRock(final IRock rock) {
        final int xPlayer = this.getX();
        final int yPlayer = this.getY();
        final int xRock = rock.getX();
        final int yRock = rock.getY();
        if ((xRock == (xPlayer + 1)) && (yRock == yPlayer)) {
            this.verifyAndPushForRockPushing(xRock + 1, yRock, rock);
        } else if ((xRock == (xPlayer - 1)) && (yRock == yPlayer)) {
            this.verifyAndPushForRockPushing(xRock - 1, yRock, rock);

        } else if ((yRock == (yPlayer + 1)) && (xRock == xPlayer)) {
            this.verifyAndPushForRockPushing(xRock, yRock + 1, rock);
        }
    }

    /**
     * Sets the moving order.
     *
     * @param movingOrder the new moving order
     */
    @Override
    public void setMovingOrder(final ControllerOrder movingOrder) {
        this.movingOrder = movingOrder;
    }

    /**
     * Sets the number of taken diamond.
     *
     * @param numberOfTakenDiamond the new number of taken diamond
     */
    @Override
    public void setNumberOfTakenDiamond(final int numberOfTakenDiamond) {
        this.numberOfTakenDiamond = numberOfTakenDiamond;
    }

    /**
     * Verify and push for rock pushing.
     *
     * @param x the x
     * @param y the y
     * @param rock the rock
     */
    private void verifyAndPushForRockPushing(final int x, final int y, final IRock rock) {
        if (this.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            this.getMap().setXYElement(rock.getX(), rock.getY(), MotionlessFactory.createTunnel());
            rock.setX(x);
            rock.setY(y);
            this.getMap().setXYElement(x, y, rock);
        }
    }

}
