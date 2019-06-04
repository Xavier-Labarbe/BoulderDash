package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    IController getController();

    /**
     * Prints the message.
     *
     * @param message the message
     */
    void printMessage(final String message);

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */
    void setController(IController controller);
}
