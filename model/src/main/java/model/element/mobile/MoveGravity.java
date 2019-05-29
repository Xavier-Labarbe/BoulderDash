package model.element.mobile;

import contract.Permeability;
import model.element.motionless.ExplosableWall;
import model.element.motionless.Tunnel;

public class MoveGravity extends StrategyMove {

    @Override
    public void move(final Mobile mobile) {
        final int x = mobile.getX();
        final int y = mobile.getY();
        if (mobile.getMap().getXYElement(x, y + 1).getPermeability() == Permeability.PENETRABLE) {

            if ((mobile.getMap().getXYElement(x, y + 1) instanceof AliveMobile)) {
                System.out.println("ok");
                ((IFallingMobile) mobile).kill((AliveMobile) mobile.getMap().getXYElement(x, y + 1));
                if (mobile.getMap().getXYElement(x, y + 1) instanceof IMonster) {
                    ((IMonster) mobile.getMap().getXYElement(x, y + 1)).createDiamonds();
                }
                mobile.getMap().setXYElement(x, y + 1, mobile);
                mobile.setX(x);
                mobile.setY(y + 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());

            } else {
                mobile.getMap().setXYElement(x, y + 1, mobile);
                mobile.setX(x);
                mobile.setY(y + 1);
                mobile.getMap().setXYElement(x, y, new Tunnel());
            }
        } else if (mobile.getMap().getXYElement(x, y + 1).getPermeability() == Permeability.BLOCKING) {
            if ((mobile.getMap().getXYElement(x, y + 1) instanceof FallingMobile)
                    || (mobile.getMap().getXYElement(x, y + 1) instanceof ExplosableWall)) {
                if ((mobile.getMap().getXYElement(x + 1, y) instanceof Tunnel)
                        && (mobile.getMap().getXYElement(x + 1, y + 1) instanceof Tunnel)) {
                    mobile.getMap().setXYElement(x + 1, y + 1, mobile);
                    mobile.setX(x + 1);
                    mobile.setY(y + 1);
                    mobile.getMap().setXYElement(x, y, new Tunnel());
                } else if ((mobile.getMap().getXYElement(x - 1, y) instanceof Tunnel)
                        && (mobile.getMap().getXYElement(x - 1, y + 1) instanceof Tunnel)) {
                    mobile.getMap().setXYElement(x - 1, y + 1, mobile);
                    mobile.setX(x - 1);
                    mobile.setY(y + 1);
                    mobile.getMap().setXYElement(x, y, new Tunnel());
                }
            }
        }

    }

}
