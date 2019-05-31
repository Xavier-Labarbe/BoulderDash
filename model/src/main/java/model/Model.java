package model;

import java.util.Observable;

import contract.IPlayableMap;

public final class Model extends Observable {

    private IPlayableMap playableMap;

    public Observable getObservable() {
        return this;
    }

    public IPlayableMap getPlayableMap() {
        return this.playableMap;
    }

    public void loadMap(final int id) {

    }

    public void setPlayableMap(final IPlayableMap playableMap) {
        this.playableMap = playableMap;
    }

}
