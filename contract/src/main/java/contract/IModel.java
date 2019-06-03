package contract;

public interface IModel {

    public IPlayableMap getPlayableMap();

    public void loadMap(final int id);

    public void setPlayableMap(final IPlayableMap playableMap);
}