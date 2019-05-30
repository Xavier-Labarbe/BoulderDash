package model.element.mobile;

import contract.ControllerOrder;
import contract.ISprite;
import contract.Permeability;
import model.IPlayableMap;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Player extends AliveMobile implements IAliveMobile, IPlayer {
    private static ISprite sprite = new Sprite('P', "Player.jpg");
    private static Permeability permeability = Permeability.PENETRABLE;
    private static Boolean explosable = true;
    private static StrategyMove strategyMove = new MoveInput();
    private int numberOfTakenDiamond = 0;
    private ControllerOrder movingOrder = ControllerOrder.NOTHING;

    public Player(final int x, final int y, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().setPlayer(this);
        this.getMap().addMobiles(this);
    }

    @Override
    public void digTunnel(final int x, final int y) {
        this.getMap().setXYElement(x, y, new Tunnel());
    }

    @Override
    public ControllerOrder getMovingOrder() {
        return this.movingOrder;
    }

    @Override
    public int getNumberOfTakenDiamond() {
        return this.numberOfTakenDiamond;
    }

    @Override
    public void pickupDiamond(final Diamond diamond) {
        this.getMap().addwaitingMobilesForRemoving(diamond);
        this.setNumberOfTakenDiamond(this.getNumberOfTakenDiamond() + 1);
        if (this.getNumberOfTakenDiamond() == this.getMap().getNumberOfDiamondForWin()) {
            this.getMap().getExit().open();
        }

    }

    @Override
    public void pushRock(final Rock rock) {
        final int xPlayer = this.getX();
        final int yPlayer = this.getY();
        final int xRock = rock.getX();
        final int yRock = rock.getY();
        if ((xRock == (xPlayer + 1)) && (yRock == yPlayer)) {
            this.verifyAndPushForRockPushing(xRock + 1, yRock, rock);
        } else if ((xRock == (xPlayer - 1)) && (yRock == yPlayer)) {
            this.verifyAndPushForRockPushing(xRock - 1, yRock, rock);
        } else if ((yRock == (yPlayer - 1)) && (xRock == xPlayer)) {
            this.verifyAndPushForRockPushing(xRock, yRock - 1, rock);
        } else if ((yRock == (yPlayer + 1)) && (xRock == xPlayer)) {
            this.verifyAndPushForRockPushing(xRock, yRock + 1, rock);
        }
    }

    @Override
    public void setMovingOrder(final ControllerOrder movingOrder) {
        this.movingOrder = movingOrder;
    }

    @Override
    public void setNumberOfTakenDiamond(final int numberOfTakenDiamond) {
        this.numberOfTakenDiamond = numberOfTakenDiamond;
    }

    private void verifyAndPushForRockPushing(final int x, final int y, final Rock rock) {
        if (this.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            this.getMap().setXYElement(rock.getX(), rock.getY(), new Tunnel());
            rock.setX(x);
            rock.setY(y);
            this.getMap().setXYElement(x, y, rock);
        }
    }

}
