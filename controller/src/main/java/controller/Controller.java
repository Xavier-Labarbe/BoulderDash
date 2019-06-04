package controller;

import java.sql.SQLException;

import contract.ControllerOrder;
import contract.IController;
import contract.ILoopGame;
import contract.IModel;
import contract.IPlayableMap;
import contract.IView;
import model.DAOMap;
import model.DBConnection;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

    /** The model. */
    private IModel model;

    /** The view. */
    private IView view;

    /** The gameloop */
    private ILoopGame loopGame;

    /**
     * Instantiates a new controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */

    public Controller(final IView view, final IModel model) {
        this.loopGame = new LoopGame();
        this.setView(view);
        this.view.setController(this);
        this.setModel(model);
        this.setLoopGame(this.loopGame);
        this.loopGame.setController(this);
    }

    /**
     * Control.
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IController#control()
     */
    @Override
    public void control() {
        this.view.printMessage(
                "Appuyer sur les touches '↑', '↓', '←' ou '→', pour vous déplacer. Ramassez le nombre de diamant attendu pour atteindre la sortie. ATTENTION AUX CAILLOUX !");
    }

    @Override
    public ILoopGame getLoopGame() {
        return this.loopGame;
    }

    @Override
    public IModel getModel() {
        return this.model;
    }

    @Override
    public IView getView() {
        return this.view;
    }

    /**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IController#orderPerform(contract.ControllerOrder)
     */
    @Override
    public void orderPerform(final ControllerOrder controllerOrder) {
        this.getModel().getPlayableMap().getPlayer().setMovingOrder(controllerOrder);
    }

    @Override
    public void restart(final int id) throws SQLException {
        this.stop();
    }

    private void setLoopGame(final ILoopGame loopGame) {
        this.loopGame = loopGame;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */

    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */

    private void setView(final IView pview) {
        this.view = pview;
    }

    @Override
    public void start(final int id) throws SQLException {
        // reload model
        final DAOMap dao = new DAOMap(DBConnection.getInstance().getConnection());
        this.getModel().setPlayableMap(dao.create(dao.find(id)));
        final IPlayableMap map = this.getModel().getPlayableMap();
        for (int y = 0; y < map.getWidth(); y++) {
            for (int x = 0; x < map.getHeight(); x++) {
                System.out.print(map.getXYElement(x, y).getSprite().getConsoleImage() + " ");
            }
            System.out.println();

        }
        this.loopGame = new LoopGame();
        this.loopGame.setController(this);
        this.getView().setMap(this.getModel().getPlayableMap());
        try {
            this.loopGame.loopGame();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        this.loopGame = null;
        // this.loopGame.setIsRunning(false);
    }

}
