package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Element;

public abstract class Mobile extends Element {
    private int x;
    private int y;
    private StrategyMove strategyMove = null;
    private PlayableMap map;

    public Mobile(final iSprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove) {
        super(sprite, permeability, explosable);
        this.map = new PlayableMap();
        this.setStrategyMove(strategyMove);
        this.setX(x);
        this.setY(y);
    }

    public PlayableMap getMap() {
        return this.map;
    }

    public StrategyMove getStrategyMove() {
        return this.strategyMove;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Boolean isLocationUsed(final int x, final int y) {
        return true;
    }

    public void move() {
        this.strategyMove.move();
    }

    public void setMap(final PlayableMap map) {
        this.map = map;
    }

    public void setStrategyMove(final StrategyMove strategyMove) {
        this.strategyMove = strategyMove;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

}
