package model.element.mobile;

import contract.IMobile;
import contract.Permeability;
import model.element.motionless.MotionlessFactory;

public class MoveAuto extends StrategyMove {

    @Override
    public void move(final IMobile mobile) {
        final int x = mobile.getX();
        final int y = mobile.getY();
        int movingVector = (((Monster) mobile).getMovingVector());
        Boolean moved = false;

        switch (movingVector) {
        case 1:
            if (this.verifyIfPossible(x + 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x + 1, y, mobile);
                moved = true;
                movingVector = 2;
            }
            if (this.verifyIfPossible(x, y - 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y - 1, mobile);
                moved = true;
                movingVector = 1;
            }
            if (this.verifyIfPossible(x - 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x - 1, y, mobile);
                moved = true;
                movingVector = 4;
            }
            if (this.verifyIfPossible(x, y + 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y + 1, mobile);
                moved = true;
                movingVector = 3;
            }
            break;
        case 2:
            if (this.verifyIfPossible(x, y + 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y + 1, mobile);
                moved = true;
                movingVector = 3;
            }
            if (this.verifyIfPossible(x + 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x + 1, y, mobile);
                moved = true;
                movingVector = 2;
            }
            if (this.verifyIfPossible(x, y - 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y - 1, mobile);
                moved = true;
                movingVector = 1;
            }
            if (this.verifyIfPossible(x - 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x - 1, y, mobile);
                moved = true;
                movingVector = 4;
            }

            break;
        case 3:
            if (this.verifyIfPossible(x - 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x - 1, y, mobile);
                moved = true;
                movingVector = 4;
            }
            if (this.verifyIfPossible(x, y + 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y + 1, mobile);
                moved = true;
                movingVector = 3;
            }
            if (this.verifyIfPossible(x + 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x + 1, y, mobile);
                moved = true;
                movingVector = 2;
            }
            if (this.verifyIfPossible(x, y - 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y - 1, mobile);
                moved = true;
                movingVector = 1;
            }

            break;
        case 4:
            if (this.verifyIfPossible(x, y - 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y - 1, mobile);
                moved = true;
                movingVector = 1;
            }
            if (this.verifyIfPossible(x - 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x - 1, y, mobile);
                moved = true;
                movingVector = 4;
            }
            if (this.verifyIfPossible(x, y + 1, mobile) && (moved == false)) {
                this.moveAtXY(x, y + 1, mobile);
                moved = true;
                movingVector = 3;
            }
            if (this.verifyIfPossible(x + 1, y, mobile) && (moved == false)) {
                this.moveAtXY(x + 1, y, mobile);
                moved = true;
                movingVector = 2;
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

    private void moveAtXY(final int x, final int y, final IMobile mobile) {
        mobile.getMap().setXYElement(mobile.getX(), mobile.getY(), MotionlessFactory.createTunnel());
        mobile.getMap().setXYElement(x, y, MotionlessFactory.createTunnel());
        mobile.getMap().setXYElement(x, y, mobile);
        mobile.setX(x);
        mobile.setY(y);
    }

    private Boolean verifyIfPossible(final int x, final int y, final IMobile mobile) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            return true;
        }
        return false;
    }

}
