package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

    IController getController();

    /**
     * Prints the message.
     *
     * @param message the message
     */
    void printMessage(final String message);

    void setController(IController controller);
}
