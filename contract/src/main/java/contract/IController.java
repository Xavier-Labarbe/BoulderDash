package contract;

import java.sql.SQLException;

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

    public IView getView();

    /**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
    public void orderPerform(ControllerOrder controllerOrder);

    public void restart(int i) throws SQLException;

    void start(int id) throws SQLException;

    public void stop();
}
