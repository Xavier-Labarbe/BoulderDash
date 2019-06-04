package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFallingMobile.
 */
public interface IFallingMobile extends IMobile {

    /**
     * Checks if is falling.
     *
     * @return the boolean
     */
    Boolean isFalling();

    /**
     * Checks if is frozen.
     *
     * @return the boolean
     */
    public Boolean isFrozen();

    /**
     * Kill.
     *
     * @param aliveMobile the alive mobile
     */
    void kill(IAliveMobile aliveMobile);

    /**
     * Sets the falling.
     *
     * @param falling the new falling
     */
    void setFalling(Boolean falling);

    /**
     * Sets the frozen.
     *
     * @param frozen the new frozen
     */
    public void setFrozen(final Boolean frozen);

}