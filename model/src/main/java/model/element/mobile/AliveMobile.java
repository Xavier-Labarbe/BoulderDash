package model.element.mobile;

import contract.Permeability;
import contract.iSprite;

public abstract class AliveMobile extends Mobile implements iLife {
    protected Boolean alive;

    public AliveMobile(final iSprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove) {
        super(sprite, permeability, explosable, x, y, strategyMove);
    }

    public Boolean getAlive() {
        return this.alive;
    }

    @Override
    public abstract void setAlive(final Boolean alive);
}
