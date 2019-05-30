package model;

import java.util.ArrayList;

import contract.IElement;
import model.element.mobile.IMobile;
import model.element.mobile.IPlayer;
import model.element.motionless.Exit;

public interface IPlayableMap {

    void addMobiles(IMobile mobile);

    void addwaitingMobilesForCreation(IMobile mobile);

    void addwaitingMobilesForRemoving(IMobile mobile);

    IElement[][] getElements();

    Exit getExit();

    int getHeight();

    ArrayList<IMobile> getMobiles();

    int getNumberOfDiamondForWin();

    IPlayer getPlayer();

    ArrayList<IMobile> getWaitingMobilesForCreation();

    ArrayList<IMobile> getWaitingMobilesForRemoving();

    int getWidth();

    Boolean getWin();

    IElement getXYElement(int x, int y);

    void removeMobiles(IMobile mobile);

    void setElements(IElement[][] elements);

    void setExit(Exit exit);

    void setHeight(int height);

    void setNumberOfDiamondForWin(int numberOfDiamondForWin);

    void setPlayer(IPlayer player);

    void setWidth(int width);

    void setWin(Boolean win);

    void setXYElement(int x, int y, IElement element);

}