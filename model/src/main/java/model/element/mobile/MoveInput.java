package model.element.mobile;

import contract.ControllerOrder;
import contract.DoorState;
import contract.IExit;
import contract.IMobile;
import contract.IPlayer;
import contract.Permeability;
import model.element.motionless.Dirt;
import model.element.motionless.Tunnel;

public class MoveInput extends StrategyMove {

    private Boolean isADiamond(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Diamond) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isADirt(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Dirt) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isARock(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Rock) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isOpenableAndOpen(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.OPENABLE) {
            if (((IExit) mobile.getMap().getXYElement(x, y)).getDoorState() == DoorState.OPEN) {
                mobile.getMap().setWin(true);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private Boolean isPenetrable(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(final IMobile mobile) {
        final ControllerOrder movingOrder = mobile.getMap().getPlayer().getMovingOrder();
        final int x = mobile.getX();
        final int y = mobile.getY();

        // movingOrder = ControllerOrder.RIGHT;
        switch (movingOrder) {
        case UP:
            this.verifyAndMove(x, y - 1, mobile);
            break;
        case DOWN:
            this.verifyAndMove(x, y + 1, mobile);
            break;
        case RIGHT:
            this.verifyAndMove(x + 1, y, mobile);
            break;
        case LEFT:
            this.verifyAndMove(x - 1, y, mobile);
            break;
        case NOTHING:
            break;
        }
        mobile.getMap().getPlayer().setMovingOrder(ControllerOrder.NOTHING);
    }

    private void moveAtXY(final IMobile mobile, final int x, final int y) {
        mobile.getMap().setXYElement(mobile.getX(), mobile.getY(), new Tunnel());
        mobile.getMap().setXYElement(x, y, mobile);
        mobile.setX(x);
        mobile.setY(y);
    }

    private void verifyAndMove(final int x, final int y, final IMobile mobile) {
        if (this.isPenetrable(mobile, x, y)) {
            this.moveAtXY(mobile, x, y);
        } else if (this.isARock(mobile, x, y)) {
            ((IPlayer) mobile).pushRock((Rock) mobile.getMap().getXYElement(x, y));
        } else if (this.isADiamond(mobile, x, y)) {
            ((IPlayer) mobile).pickupDiamond((Diamond) mobile.getMap().getXYElement(x, y));
            this.moveAtXY(mobile, x, y);
        } else if (this.isADirt(mobile, x, y)) {
            ((IPlayer) mobile).digTunnel(x, y);
            this.moveAtXY(mobile, x, y);
        } else if (this.isOpenableAndOpen(mobile, x, y)) {
            this.moveAtXY(mobile, x, y);
            mobile.getMap().setWin(true);
        }
    }
}
