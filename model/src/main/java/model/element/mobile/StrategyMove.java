package model.element.mobile;

/*
* The Class "StrategyMove".
* @author "Group 1"
* @version 1.0
*/

import contract.IMobile;
import model.element.motionless.Tunnel;

// TODO: Auto-generated Javadoc
/**
 * The Class StrategyMove.
 */
public abstract class StrategyMove {

    /**
     * Move.
     *
     * @param mobile the mobile
     */
    public abstract void move(IMobile mobile);

    /**
     * Move at XY.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     */
    protected void moveAtXY(final IMobile mobile, final int x, final int y) {
        mobile.getMap().setXYElement(mobile.getX(), mobile.getY(), new Tunnel());
        mobile.getMap().setXYElement(x, y, new Tunnel());
        mobile.getMap().setXYElement(x, y, mobile);
        mobile.setX(x);
        mobile.setY(y);
    }

}
