package contract;

import java.util.Observable;

public interface IModel {

    Observable getObservable();

    public IPlayableMap getPlayableMap();

    public void loadMap(final int id);

    public void setPlayableMap(final IPlayableMap playableMap);
}