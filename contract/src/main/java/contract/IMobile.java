package contract;

public interface IMobile extends IElement {

    IPlayableMap getMap();

    int getX();

    int getY();

    void move();

    void setX(int x);

    void setY(int y);
}