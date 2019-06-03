package contract;

public interface IFallingMobile extends IMobile {

    Boolean isFalling();

    public Boolean isFrozen();

    void kill(IAliveMobile aliveMobile);

    void setFalling(Boolean falling);

    public void setFrozen(final Boolean frozen);

}