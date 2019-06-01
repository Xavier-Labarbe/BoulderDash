package model.element;

import contract.Permeability;
import contract.IElement;
import contract.iSprite;

public abstract class Element implements IElement {
    private iSprite sprite;
    private Permeability permeability;
    private Boolean explosable;

    public Element(final iSprite sprite, final Permeability permeability, final Boolean explosable) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
        this.setExplosable(explosable);
    }

    @Override
    public Permeability getPermeability() {
        return this.permeability;
    }

    @Override
    public iSprite getSprite() {
        return this.sprite;
    }

    @Override
    public Boolean isExplosable() {
        return this.explosable;
    }

    public void setExplosable(final Boolean explosable) {
        this.explosable = explosable;
    }

    public void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    public void setSprite(final iSprite sprite) {
        this.sprite = sprite;
    }
}
