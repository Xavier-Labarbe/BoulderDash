package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILoopGame.
 */
public interface ILoopGame {

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    IController getController();

    /**
     * Gets the checks if is running.
     *
     * @return the checks if is running
     */
    Boolean getIsRunning();

    /**
     * Loop game.
     *
     * @throws InterruptedException the interrupted exception
     */
    void loopGame() throws InterruptedException;

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */
    void setController(IController controller);

    /**
     * Sets the checks if is running.
     *
     * @param isRunning the new checks if is running
     */
    void setIsRunning(Boolean isRunning);

}