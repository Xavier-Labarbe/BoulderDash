package model.element.mobile;

import model.PlayableMap;

public interface IMobile {

    public Boolean getBeRemove();

    PlayableMap getMap();

    int getX();

    int getY();

    void move();

    public void setBeRemove(Boolean beRemove);

    void setStrategyMove(StrategyMove strategyMove);

    void setX(int x);

    void setY(int y);
}