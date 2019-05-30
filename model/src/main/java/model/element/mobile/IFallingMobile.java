package model.element.mobile;

public interface IFallingMobile {

    Boolean isFalling();

    void kill(IAliveMobile aliveMobile);

    void setFalling(Boolean falling);

}