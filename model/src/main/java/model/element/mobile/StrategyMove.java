package model.element.mobile;

import contract.IMobile;
import model.element.motionless.Tunnel;

public abstract class StrategyMove {

    public abstract void move(IMobile mobile);

    protected void moveAtXY(final IMobile mobile, final int x, final int y) {
        mobile.getMap().setXYElement(mobile.getX(), mobile.getY(), new Tunnel());
        mobile.getMap().setXYElement(x, y, new Tunnel());
        mobile.getMap().setXYElement(x, y, mobile);
        mobile.setX(x);
        mobile.setY(y);
    }

}
