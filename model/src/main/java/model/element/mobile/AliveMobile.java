package model.element.mobile;

import contract.Permeability;
import contract.iSprite;

public class AliveMobile extends Mobile implements IAliveMobile {
    private Boolean alive;

    public AliveMobile(final iSprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove) {
        super(sprite, permeability, explosable, x, y, strategyMove);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Boolean isAlive() {
        // TODO Auto-generated method stub
        return this.alive;
    }

    @Override
    public void setAlive(final Boolean alive) {
        // TODO Auto-generated method stub
        this.alive = alive;
    }

}
