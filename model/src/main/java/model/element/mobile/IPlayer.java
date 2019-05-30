package model.element.mobile;

import contract.ControllerOrder;

public interface IPlayer extends IAliveMobile {

    void digTunnel(int x, int y);

    ControllerOrder getMovingOrder();

    int getNumberOfTakenDiamond();

    void pickupDiamond(Diamond diamond);

    void pushRock(Rock rock);

    void setMovingOrder(ControllerOrder movingOrder);

    void setNumberOfTakenDiamond(int numberOfTakenDiamond);

}