package model.element.mobile;

import contract.IMobile;
import contract.Permeability;
import model.element.motionless.Tunnel;

public class MoveAuto extends StrategyMove {

    @Override
    public void move(final IMobile mobile) {
        final int x = mobile.getX();
        final int y = mobile.getY();
        int movingVector = (((Monster) mobile).getMovingVector());

        int i = 0;
        Boolean moved = false;
        while ((i < 4) && (moved == false)) {
            switch (movingVector) {
            case 1:
                if (this.verifyAndMoveIfPossible(x, y - 1, mobile)) {
                    moved = true;
                } else {
                    movingVector = 2;
                    i++;
                }
                break;
            case 2:
                if (this.verifyAndMoveIfPossible(x - 1, y, mobile)) {
                    moved = true;
                } else {
                    movingVector = 3;
                    i++;
                }
                break;
            case 3:
                if (this.verifyAndMoveIfPossible(x, y + 1, mobile)) {
                    moved = true;
                } else {
                    movingVector = 4;
                    i++;
                }
                break;
            case 4:
                if (this.verifyAndMoveIfPossible(x + 1, y, mobile)) {
                    moved = true;
                } else {
                    movingVector = 1;
                    i++;
                }
                break;
            }
            ((Monster) mobile).setMovingVector(movingVector);
            if ((mobile.getX() == mobile.getMap().getPlayer().getX())
                    && (mobile.getY() == mobile.getMap().getPlayer().getY())) {
                ((Monster) mobile).kill(mobile.getMap().getPlayer());
                ;
            }
        }
    }

    private Boolean verifyAndMoveIfPossible(final int x, final int y, final IMobile mobile) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            mobile.getMap().setXYElement(mobile.getX(), mobile.getY(), new Tunnel());
            mobile.getMap().setXYElement(x, y, new Tunnel());
            mobile.getMap().setXYElement(x, y, mobile);
            mobile.setX(x);
            mobile.setY(y);
            return true;
        }
        return false;
    }

}
