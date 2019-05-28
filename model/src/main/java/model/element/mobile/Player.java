package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Player extends AliveMobile {
    private static iSprite SPRITE = new Sprite('P', "Player.jpg");
    private static Permeability PERMEABILITY = Permeability.PENETRABLE;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveInput();

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

    public void pickupDiamond(final Diamond diamond) {
        diamond.setVisible(false);
        this.getMap().setXYElement(diamond.getX(), diamond.getY(), new Tunnel());
        diamond.getMap().removeMobiles(diamond);

    }

    public void pushRock(final Rock rock) {
        final int x_p = this.getX();
        final int y_p = this.getY();
        final int x_r = rock.getX();
        final int y_r = rock.getY();
        if ((x_r == (x_p + 1)) && (y_r == y_p)) {
            System.out.println("droite");
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

}
