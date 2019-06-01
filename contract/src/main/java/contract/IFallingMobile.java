package contract;

public interface IFallingMobile extends IMobile {

    Boolean isFalling();

    void kill(IAliveMobile aliveMobile);

    void setFalling(Boolean falling);

}