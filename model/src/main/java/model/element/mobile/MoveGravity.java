package model.element.mobile;

import contract.Permeability;
import model.element.motionless.ExplosableWall;
import model.element.motionless.Tunnel;

public class MoveGravity extends StrategyMove {

    @Override
    public void move(final IMobile mobile) {
        final int x = mobile.getX();
        final int y = mobile.getY();
        if (mobile.getMap().getXYElement(x, y + 1).getPermeability() == Permeability.PENETRABLE) {

            if ((mobile.getMap().getXYElement(x, y + 1) instanceof AliveMobile)) {
                if (((IFallingMobile) mobile).isFalling()) {
                    ((IFallingMobile) mobile).kill((AliveMobile) mobile.getMap().getXYElement(x, y + 1));
                    if (mobile.getMap().getXYElement(x, y + 1) instanceof IMonster) {
                        ((IMonster) mobile.getMap().getXYElement(x, y + 1)).createDiamonds();
                    }
                    this.moveAtXY(x, y + 1, mobile);
                }

            } else {
                this.moveAtXY(x, y + 1, mobile);
                ((IFallingMobile) mobile).setFalling(true);
            }
        } else if (mobile.getMap().getXYElement(x, y + 1).getPermeability() == Permeability.BLOCKING) {
            if ((mobile.getMap().getXYElement(x, y + 1) instanceof FallingMobile)
                    || (mobile.getMap().getXYElement(x, y + 1) instanceof ExplosableWall)) {
                if ((mobile.getMap().getXYElement(x + 1, y) instanceof Tunnel)
                        && (mobile.getMap().getXYElement(x + 1, y + 1) instanceof Tunnel)) {
                    this.moveAtXY(x + 1, y + 1, mobile);
                    ((IFallingMobile) mobile).setFalling(true);
                } else if ((mobile.getMap().getXYElement(x - 1, y) instanceof Tunnel)
                        && (mobile.getMap().getXYElement(x - 1, y + 1) instanceof Tunnel)) {
                    this.moveAtXY(x - 1, y + 1, mobile);
                    ((IFallingMobile) mobile).setFalling(true);
                }
            }
        }

    }

    private void moveAtXY(final int x, final int y, final IMobile mobile) {
        mobile.getMap().setXYElement(mobile.getX(), mobile.getY(), new Tunnel());
        mobile.getMap().setXYElement(x, y, mobile);
        mobile.setX(x);
        mobile.setY(y);

    }

}
