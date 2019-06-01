package contract;

import java.util.ArrayList;

public interface IPlayableMap {

    void addMobiles(IMobile mobile);

    void addwaitingMobilesForCreation(IMobile mobile);

    void addwaitingMobilesForRemoving(IMobile mobile);

    IElement[][] getElements();

    IExit getExit();

    int getHeight();

    ArrayList<IMobile> getMobiles();

    int getNumberOfDiamondForWin();

    IPlayer getPlayer();

    ArrayList<IMobile> getWaitingMobilesForCreation();

    ArrayList<IMobile> getWaitingMobilesForRemoving();

    int getWidth();

    Boolean isWin();

    IElement getXYElement(int x, int y);

    void removeMobiles(IMobile mobile);

    void setElements(IElement[][] elements);

    void setExit(IExit exit);

    void setHeight(int height);

    void setNumberOfDiamondForWin(int numberOfDiamondForWin);

    void setPlayer(IPlayer player);

    void setWidth(int width);

    void setWin(Boolean win);

    void setXYElement(int x, int y, IElement element);

}