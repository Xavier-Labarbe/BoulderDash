package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import contract.IController;

public class LoopGameTest {
    Boolean IsRunning = true;
    IController controller;
    private final LoopGame loopGame = new LoopGame();

    @Test
    public void getControllerTest() {
        assertEquals(this.controller, this.loopGame.getController());
    }

    @Test
    public void getIsRunningTest() {
        assertTrue(this.loopGame.getIsRunning());
    }

    @Test
    public void render() {
        this.loopGame.setIsRunning(this.IsRunning);
        if (this.loopGame.getIsRunning() == false) {
            fail("la game loop est arrétée");
        }
    }

    @Test
    public void setControllerTest() {
        this.loopGame.setController(this.controller);
        assertEquals(this.controller, this.loopGame.getController());
    }

    @Test
    public void setIsRunningTest() {
        this.loopGame.setIsRunning(true);
        assertTrue(this.loopGame.getIsRunning());
    }
}