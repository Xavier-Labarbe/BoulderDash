package contract;

public interface IMobile extends IElement {

    IPlayableMap getMap();

    int getX();

    int getY();

    void move();

    public void setMap(final IPlayableMap map);

    void setX(int x);

    void setY(int y);
}