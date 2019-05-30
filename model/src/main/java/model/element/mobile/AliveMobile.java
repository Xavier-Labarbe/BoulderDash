package model.element.mobile;

import contract.ISprite;
import contract.Permeability;
import model.IPlayableMap;

public class AliveMobile extends Mobile implements IAliveMobile {
    private Boolean alive = true;

    public AliveMobile(final ISprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove, final IPlayableMap map) {
        super(sprite, permeability, explosable, x, y, strategyMove, map);
    }

    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;
    }

}
