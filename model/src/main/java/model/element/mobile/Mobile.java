package model.element.mobile;

import contract.ISprite;
import contract.Permeability;
import model.IPlayableMap;
import model.element.Element;

public abstract class Mobile extends Element implements IMobile {
    private int x;
    private int y;
    private final StrategyMove strategyMove;
    private IPlayableMap map;

    public Mobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove, final IPlayableMap map) {
        super(sprite, permeability, explosable);
        this.map = map;
        this.strategyMove = strategyMove;
        this.x = x;
        this.y = y;

    }

    @Override
    public IPlayableMap getMap() {
        return this.map;
    }

    public StrategyMove getStrategyMove() {
        return this.strategyMove;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void move() {
        this.strategyMove.move(this);
    }

    public void setMap(final IPlayableMap map) {
        this.map = map;
    }

    @Override
    public void setX(final int x) {
        this.x = x;
    }

    @Override
    public void setY(final int y) {
        this.y = y;
    }

}
