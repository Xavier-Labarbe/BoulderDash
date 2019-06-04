package model;

import contract.IModel;
import contract.IPlayableMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
public final class Model implements IModel {

    /** The playable map. */
    private IPlayableMap playableMap;

    /**
     * Gets the playable map.
     *
     * @return the playable map
     */
    @Override
    public IPlayableMap getPlayableMap() {
        return this.playableMap;
    }

    /**
     * Sets the playable map.
     *
     * @param playableMap the new playable map
     */
    @Override
    public void setPlayableMap(final IPlayableMap playableMap) {
        this.playableMap = playableMap;
    }

}
