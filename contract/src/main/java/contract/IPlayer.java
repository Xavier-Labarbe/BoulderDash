package contract;

public interface IPlayer extends IAliveMobile {

    void digTunnel(int x, int y);

    ControllerOrder getMovingOrder();

    int getNumberOfTakenDiamond();

    void pickupDiamond(IDiamond diamond);

    void pushRock(IRock rock);

    void setMovingOrder(ControllerOrder movingOrder);

    void setNumberOfTakenDiamond(int numberOfTakenDiamond);

}