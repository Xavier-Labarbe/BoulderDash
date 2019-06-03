package model;

import contract.IModel;
import contract.IPlayableMap;

public final class Model implements IModel {

    private IPlayableMap playableMap;

    @Override
    public IPlayableMap getPlayableMap() {
        return this.playableMap;
    }

    @Override
    public void loadMap(final int id) {

    }

    @Override
    public void setPlayableMap(final IPlayableMap playableMap) {
        this.playableMap = playableMap;
    }

}
