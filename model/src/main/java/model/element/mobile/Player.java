package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Player extends AliveMobile {
    private static iSprite SPRITE = new Sprite("P", "Player.jpg");
    private static Permeability PERMEABILITY = Permeability.PENETRABLE;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveInput();

    public Player(final int x, final int y, final PlayableMap map) {
        super(SPRITE, PERMEABILITY, EXPLOSABLE, x, y, STRATEGY_MOVE);
        this.setMap(map);
        this.getMap().addMobiles(this);
    }

    public void digTunnel(final int x, final int y) {
        this.getMap().setXYElement(x, y, new Tunnel());
    }

    public void pickupDiamond(final Diamond diamond) {
        diamond.setVisible(false);
        diamond.getMap().removeMobiles(diamond);
    }

    public void pushRock(final Rock rock) {
        final int x_p = this.getX();
        final int y_p = this.getY();
        final int x_r = rock.getX();
        final int y_r = rock.getY();
        if ((x_r == (x_p + 1)) && (y_r == y_p)) {
            System.out.println("droite");
            rock.setX(x_r + 1);
        } else if ((x_r == (x_p - 1)) && (y_r == y_p)) {
            System.out.println("gauche");
            rock.setX(x_r - 1);
        } else if ((y_r == (y_p - 1)) && (x_r == x_p)) {
            System.out.println("haut");
            rock.setY(y_r - 1);
        } else if ((y_r == (y_p + 1)) && (x_r == x_p)) {
            System.out.println("bas");
            rock.setY(y_r + 1);
        }
    }

    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;
    }

}
