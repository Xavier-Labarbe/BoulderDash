package model.element.mobile;

import contract.Permeability;
import contract.iSprite;

public abstract class FallingMobile extends Mobile {
    private Boolean falling;
    private Boolean visible;

    public FallingMobile(final iSprite sprite, final Permeability permeability, final Boolean explosable, final int x,
            final int y, final StrategyMove strategyMove) {
        super(sprite, permeability, explosable, x, y, strategyMove);
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public Boolean isFalling() {
        return this.falling;
    }

    public void kill(final iLife elementAlive) {
        elementAlive.setAlive(false);
    }

    public void setFalling(final Boolean falling) {
        this.falling = falling;
    }

    public void setVisible(final Boolean visible) {
        this.visible = visible;
    }
}
