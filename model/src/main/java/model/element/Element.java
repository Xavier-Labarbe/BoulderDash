package model.element;

import contract.IElement;
import contract.ISprite;
import contract.Permeability;

public abstract class Element implements IElement {
    private final ISprite sprite;
    private final Permeability permeability;
    private final Boolean explosable;

    public Element(final ISprite sprite, final Permeability permeability, final Boolean explosable) {
        this.sprite = sprite;
        this.permeability = permeability;
        this.explosable = explosable;
    }

    @Override
    public Permeability getPermeability() {
        return this.permeability;
    }

    @Override
    public ISprite getSprite() {
        return this.sprite;
    }

    @Override
    public Boolean isExplosable() {
        return this.explosable;
    }

}
