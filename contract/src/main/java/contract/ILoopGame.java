package contract;

public interface ILoopGame {

    IController getController();

    Boolean getIsRunning();

    void loopGame() throws InterruptedException;

    void setController(IController controller);

    void setIsRunning(Boolean isRunning);

}