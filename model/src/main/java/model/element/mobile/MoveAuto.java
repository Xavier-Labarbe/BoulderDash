package model.element.mobile;

import contract.Permeability;
import model.element.motionless.Tunnel;

public class MoveAuto extends StrategyMove {

    @Override
    public void move(final Mobile mobile) {
        final int x = mobile.getX();
        final int y = mobile.getY();
        int movingVector = mobile.getMovingVector();
        int i = 0;
        Boolean moved = false;
        while ((i < 4) && (moved == false)) {
            switch (movingVector) {
            case 1:
                if (mobile.getMap().getXYElement(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
                    // bas
                    mobile.getMap().setXYElement(x, y + 1, mobile);
                    mobile.setX(x);
                    mobile.setY(y + 1);
                    mobile.getMap().setXYElement(x, y, new Tunnel());
                    moved = true;
                } else {
                    movingVector = 2;
                    i++;
                }
                break;
            case 2:
                if (mobile.getMap().getXYElement(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
                    // gauche
                    mobile.getMap().setXYElement(x + 1, y, mobile);
                    mobile.setX(x + 1);
                    mobile.setY(y);
                    mobile.getMap().setXYElement(x, y, new Tunnel());
                    moved = true;
                } else {
                    movingVector = 3;
                    i++;
                }
                break;
            case 3:
                if (mobile.getMap().getXYElement(x, y - 1).getPermeability() == Permeability.PENETRABLE) {
                    // haut
                    mobile.getMap().setXYElement(x, y - 1, mobile);
                    mobile.setX(x);
                    mobile.setY(y - 1);
                    mobile.getMap().setXYElement(x, y, new Tunnel());
                    moved = true;
                } else {
                    movingVector = 4;
                    i++;
                }
                break;
            case 4:
                if (mobile.getMap().getXYElement(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
                    // droite
                    mobile.getMap().setXYElement(x - 1, y, mobile);
                    mobile.setX(x - 1);
                    mobile.setY(y);
                    mobile.getMap().setXYElement(x, y, new Tunnel());
                    moved = true;
                } else {
                    movingVector = 1;
                    i++;
                }
                break;
            }
            mobile.setMovingVector(movingVector);
            if ((mobile.getX() == mobile.getMap().getPlayer().getX())
                    && (mobile.getY() == mobile.getMap().getPlayer().getY())) {
                mobile.getMap().getPlayer().setAlive(false);
            }
        }
    }

}
