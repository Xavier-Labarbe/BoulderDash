package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.ILoopGame;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public final class Controller implements IController {

    /** The model. */
    private IModel model;

    /** The view. */
    private IView view;

    /**  The gameloop. */
    private ILoopGame loopGame;

    /**
     * Instantiates a new controller.
     *
     * @param view  the view
     * @param model the model
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

    /**
     * Gets the loop game.
     *
     * @return the loop game
     */
    @Override
    public ILoopGame getLoopGame() {
        return this.loopGame;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    @Override
    public IModel getModel() {
        return this.model;
    }

    /**
     * Order perform.
     *
     * @param controllerOrder the controller order
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

    /**
     * Sets the loop game.
     *
     * @param loopGame the new loop game
     */
    private void setLoopGame(final ILoopGame loopGame) {
        this.loopGame = loopGame;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */

    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Sets the view.
     *
     * @param pview the new view
     */

    private void setView(final IView pview) {
        this.view = pview;
    }

    /**
     * Start.
     */
    @Override
    public void start() {
        try {
            this.loopGame.loopGame();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
