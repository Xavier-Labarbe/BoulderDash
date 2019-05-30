package model.element.mobile;

import contract.ControllerOrder;
import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Player extends AliveMobile implements IAliveMobile {
    private static iSprite SPRITE = new Sprite('P', "Player.jpg");
    private static Permeability PERMEABILITY = Permeability.PENETRABLE;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveInput();
    private Boolean alive;
    private int numberOfTakenDiamond = 0;

    private ControllerOrder movingOrder = ControllerOrder.NOTHING;

    public Player(final int x, final int y, final PlayableMap map) {
        super(SPRITE, PERMEABILITY, EXPLOSABLE, x, y, STRATEGY_MOVE);
        this.setMap(map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().setPlayer(this);
        this.getMap().addMobiles(this);
        this.setAlive(true);
    }

    public void digTunnel(final int x, final int y) {
        this.getMap().setXYElement(x, y, new Tunnel());
    }

    public ControllerOrder getMovingOrder() {
        return this.movingOrder;
    }

    public int getNumberOfTakenDiamond() {
        return this.numberOfTakenDiamond;
    }

    @Override
    public Boolean isAlive() {
        // TODO Auto-generated method stub
        return this.alive;
    }

    public void pickupDiamond(final Diamond diamond) {
        // this.getMap().setXYElement(diamond.getX(), diamond.getY(), new Tunnel());
        diamond.setX(0);
        diamond.setY(0);
        this.getMap().addwaitingMobilesForRemoving(diamond);
        this.setNumberOfTakenDiamond(this.getNumberOfTakenDiamond() + 1);
        if (this.getNumberOfTakenDiamond() == this.getMap().getNumberOfDiamondForWin()) {
            this.getMap().getExit().open();
        }

    }

    public void pushRock(final Rock rock) {
        final int x_p = this.getX();
        final int y_p = this.getY();
        final int x_r = rock.getX();
        final int y_r = rock.getY();
        if ((x_r == (x_p + 1)) && (y_r == y_p)) {
            if (this.getMap().getXYElement(x_r + 1, y_r).getPermeability() == Permeability.PENETRABLE) {
                rock.setX(x_r + 1);
                this.getMap().setXYElement(x_r + 1, y_r, rock);
                this.getMap().setXYElement(x_r, y_r, new Tunnel());
            }
        } else if ((x_r == (x_p - 1)) && (y_r == y_p)) {
            System.out.println("gauche");
            if (this.getMap().getXYElement(x_r - 1, y_r).getPermeability() == Permeability.PENETRABLE) {
                rock.setX(x_r - 1);
                this.getMap().setXYElement(x_r - 1, y_r, rock);
                this.getMap().setXYElement(x_r, y_r, new Tunnel());
            }

        } else if ((y_r == (y_p - 1)) && (x_r == x_p)) {
            System.out.println("haut");
            if (this.getMap().getXYElement(x_r, y_r - 1).getPermeability() == Permeability.PENETRABLE) {
                rock.setY(y_r - 1);
                this.getMap().setXYElement(x_r, y_r - 1, rock);
                this.getMap().setXYElement(x_r, y_r, new Tunnel());
            }
        } else if ((y_r == (y_p + 1)) && (x_r == x_p)) {
            System.out.println("bas");
            if (this.getMap().getXYElement(x_r, y_r + 1).getPermeability() == Permeability.PENETRABLE) {
                rock.setY(y_r + 1);
                this.getMap().setXYElement(x_r, y_r + 1, rock);
                this.getMap().setXYElement(x_r, y_r, new Tunnel());
            }
        }
    }

    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;

    }

    public void setMovingOrder(final ControllerOrder movingOrder) {
        this.movingOrder = movingOrder;
    }

    public void setNumberOfTakenDiamond(final int numberOfTakenDiamond) {
        this.numberOfTakenDiamond = numberOfTakenDiamond;
    }

}
