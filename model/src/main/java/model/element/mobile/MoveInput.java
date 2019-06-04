package model.element.mobile;

import contract.ControllerOrder;
import contract.DoorState;
import contract.IExit;
import contract.IMobile;
import contract.IPlayer;
import contract.Permeability;
import model.element.motionless.Dirt;

// TODO: Auto-generated Javadoc
/**
 * The Class MoveInput.
 */
public class MoveInput extends StrategyMove {

    /**
     * Checks if is A diamond.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    private Boolean isADiamond(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Diamond) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is A dirt.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    private Boolean isADirt(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Dirt) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is A rock.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    private Boolean isARock(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y) instanceof Rock) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is openable and open.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     * @return the boolean
     */
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

    /**
     * Checks if is penetrable.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    private Boolean isPenetrable(final IMobile mobile, final int x, final int y) {
        if (mobile.getMap().getXYElement(x, y).getPermeability() == Permeability.PENETRABLE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move.
     *
     * @param mobile the mobile
     */
    @Override
    public void move(final IMobile mobile) {
        final ControllerOrder movingOrder = mobile.getMap().getPlayer().getMovingOrder();
        final int x = mobile.getX();
        final int y = mobile.getY();
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

    /**
     * Verify and move.
     *
     * @param x the x
     * @param y the y
     * @param mobile the mobile
     */
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
