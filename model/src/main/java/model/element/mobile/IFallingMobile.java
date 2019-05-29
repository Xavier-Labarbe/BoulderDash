package model.element.mobile;

public interface IFallingMobile {

    Boolean isFalling();

    void kill(AliveMobile aliveMobile);

    void setFalling(Boolean falling);

}