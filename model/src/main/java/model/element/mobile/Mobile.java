package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Element;

public abstract class Mobile extends Element implements IMobile {
    private int x;
    private int y;
    private int movingVector = 1;
    private StrategyMove strategyMove = null;
    private PlayableMap map;
    private Boolean beRemove = false;

    public Mobile(final iSprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove) {
        super(sprite, permeability, explosable);
        this.map = new PlayableMap();
        this.setStrategyMove(strategyMove);
        this.setX(x);
        this.setY(y);

    }

    @Override
    public Boolean getBeRemove() {
        return this.beRemove;
    }

    @Override
    public PlayableMap getMap() {
        return this.map;
    }

    public int getMovingVector() {
        return this.movingVector;
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

    public Boolean isLocationUsed(final int x, final int y) {
        return true;
    }

    @Override
    public void move() {
        this.strategyMove.move(this);
    }

    @Override
    public void setBeRemove(final Boolean beRemove) {
        this.beRemove = beRemove;
    }

    public void setMap(final PlayableMap map) {
        this.map = map;
    }

    public void setMovingVector(final int movingVector) {
        this.movingVector = movingVector;
    }

    @Override
    public void setStrategyMove(final StrategyMove strategyMove) {
        this.strategyMove = strategyMove;
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
