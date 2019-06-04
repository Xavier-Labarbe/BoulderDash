package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

    IController getController();

    public IPlayableMap getMap();

    /**
     * Prints the message.
     *
     * @param message
     *            the message
     */
    void printMessage(final String message);

    void setController(IController controller);

    public void setMap(IPlayableMap map);
}
