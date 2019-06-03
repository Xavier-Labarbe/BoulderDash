package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

    /**
     * Control.
     */
    public void control();

    public ILoopGame getLoopGame();

    public IModel getModel();

    /**
     * Order perform.
     *
     * @param controllerOrder the controller order
     */
    public void orderPerform(ControllerOrder controllerOrder);

    public void start();
}
