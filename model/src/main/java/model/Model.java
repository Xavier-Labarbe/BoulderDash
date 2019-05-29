package model;

import java.util.Observable;

import contract.IModel;

public final class Model extends Observable implements IModel {

    private PlayableMap playableMap;

    public Observable getObservable() {
        return this;
    }

    public PlayableMap getPlayableMap() {
        return this.playableMap;
    }

    public void loadMap(final int id) {

    }

    public void setPlayableMap(final PlayableMap playableMap) {
        this.playableMap = playableMap;
    }

}
