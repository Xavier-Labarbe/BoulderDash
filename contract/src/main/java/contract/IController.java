package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IController.
 *
 * @author Group 1.
 */
public interface IController {

    /**
     * Control.
     */
    public void control();

    /**
     * Gets the loop game.
     *
     * @return the loop game
     */
    public ILoopGame getLoopGame();

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel();

    /**
     * Order perform.
     *
     * @param controllerOrder the controller order
     */
    public void orderPerform(ControllerOrder controllerOrder);

    /**
     * Start.
     */
    public void start();
}
