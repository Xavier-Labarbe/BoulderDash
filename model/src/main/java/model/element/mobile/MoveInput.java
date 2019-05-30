package model.element.mobile;

import contract.ControllerOrder;
import contract.Permeability;
import model.element.motionless.Dirt;
import model.element.motionless.DoorState;
import model.element.motionless.Exit;
import model.element.motionless.Tunnel;

public class MoveInput extends StrategyMove {

    private Boolean isADiamond(final Mobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Diamond) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isADirt(final Mobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Dirt) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isARock(final Mobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Rock) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isOpenableAndOpen(final Mobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.OPENABLE) {
            if (((Exit) mobile.getMap().getXYElement(x, y)).getDoorState() == DoorState.OPEN) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private Boolean isPenetrable(final Mobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(final Mobile mobile) {
        ControllerOrder movingOrder = mobile.getMap().getPlayer().getMovingOrder();
        final int x = mobile.getX();
        final int y = mobile.getY();

        movingOrder = ControllerOrder.RIGHT;
        switch (movingOrder) {
        case UP:
            if (this.isPenetrable(mobile, x, y - 1)) {
                this.moveAtXY(mobile, x, y - 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isARock(mobile, x, y - 1)) {
                ((Player) mobile).pushRock((Rock) mobile.getMap().getXYElement(x, y - 1));
            } else if (this.isADiamond(mobile, x, y - 1)) {
                ((Player) mobile).pickupDiamond((Diamond) mobile.getMap().getXYElement(x, y - 1));
                this.moveAtXY(mobile, x, y - 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isADirt(mobile, x, y - 1)) {
                ((Player) mobile).digTunnel(x, y - 1);
                this.moveAtXY(mobile, x, y - 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isOpenableAndOpen(mobile, x, y - 1)) {
                this.moveAtXY(mobile, x, y - 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
                mobile.getMap().setWin(true);
            }
            break;
        case DOWN:
            if (this.isPenetrable(mobile, x, y + 1)) {
                this.moveAtXY(mobile, x, y + 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isARock(mobile, x, y + 1)) {
                ((Player) mobile).pushRock((Rock) mobile.getMap().getXYElement(x, y + 1));
            } else if (this.isADiamond(mobile, x, y + 1)) {
                ((Player) mobile).pickupDiamond((Diamond) mobile.getMap().getXYElement(x, y + 1));
                this.moveAtXY(mobile, x, y + 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isADirt(mobile, x, y + 1)) {
                ((Player) mobile).digTunnel(x, y + 1);
                this.moveAtXY(mobile, x, y + 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isOpenableAndOpen(mobile, x, y + 1)) {
                this.moveAtXY(mobile, x, y + 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
                mobile.getMap().setWin(true);
            }
            break;
        case RIGHT:
            if (this.isPenetrable(mobile, x + 1, y)) {
                this.moveAtXY(mobile, x + 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isARock(mobile, x + 1, y)) {
                ((Player) mobile).pushRock((Rock) mobile.getMap().getXYElement(x + 1, y));
            } else if (this.isADiamond(mobile, x + 1, y)) {
                ((Player) mobile).pickupDiamond((Diamond) mobile.getMap().getXYElement(x + 1, y));
                this.moveAtXY(mobile, x + 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isADirt(mobile, x + 1, y)) {
                ((Player) mobile).digTunnel(x + 1, y);
                this.moveAtXY(mobile, x + 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isOpenableAndOpen(mobile, x + 1, y)) {
                this.moveAtXY(mobile, x + 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
                mobile.getMap().setWin(true);
            }
            break;
        case LEFT:
            if (this.isPenetrable(mobile, x - 1, y)) {
                this.moveAtXY(mobile, x - 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isARock(mobile, x - 1, y)) {
                ((Player) mobile).pushRock((Rock) mobile.getMap().getXYElement(x - 1, y));
            } else if (this.isADiamond(mobile, x - 1, y)) {
                ((Player) mobile).pickupDiamond((Diamond) mobile.getMap().getXYElement(x - 1, y));
                this.moveAtXY(mobile, x - 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isADirt(mobile, x - 1, y)) {
                ((Player) mobile).digTunnel(x - 1, y);
                this.moveAtXY(mobile, x - 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            } else if (this.isOpenableAndOpen(mobile, x - 1, y)) {
                this.moveAtXY(mobile, x - 1, y);
                mobile.getMap().setXYElement(x, y, new Tunnel());
                mobile.getMap().setWin(true);
            }
            break;
        case NOTHING:
            break;
        }

    }

    private void moveAtXY(final Mobile mobile, final int x, final int y) {
        mobile.getMap().setXYElement(x, y, mobile);
        mobile.setX(x);
        mobile.setY(y);
    }
}
