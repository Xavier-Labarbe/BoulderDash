package model.element;

import contract.IElement;
import contract.ISprite;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class Element.
 */
public abstract class Element implements IElement {
    
    /** The sprite. */
    private final ISprite sprite;
    
    /** The permeability. */
    private final Permeability permeability;
    
    /** The explosable. */
    private final Boolean explosable;

    /**
     * Instantiates a new element.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     * @param explosable the explosable
     */
    public Element(final ISprite sprite, final Permeability permeability, final Boolean explosable) {
        this.sprite = sprite;
        this.permeability = permeability;
        this.explosable = explosable;
    }

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    @Override
    public Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    @Override
    public ISprite getSprite() {
        return this.sprite;
    }

    /**
     * Checks if is explosable.
     *
     * @return the boolean
     */
    @Override
    public Boolean isExplosable() {
        return this.explosable;
    }

}
