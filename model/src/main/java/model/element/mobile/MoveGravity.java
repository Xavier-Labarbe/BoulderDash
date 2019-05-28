package model.element.mobile;

import contract.Permeability;
import model.element.motionless.Tunnel;

public class MoveGravity extends StrategyMove {

    @Override
    public void move(final Mobile mobile) {
        final int x = mobile.getX();
        final int y = mobile.getY();
        if (mobile.getMap().getXYElement(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
            mobile.getMap().setXYElement(x, y + 1, mobile);
            mobile.setX(x);
            mobile.setY(y + 1);
            mobile.getMap().setXYElement(x, y, new Tunnel());

        }
    }

}
