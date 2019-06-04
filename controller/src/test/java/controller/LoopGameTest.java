package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import contract.IController;

// TODO: Auto-generated Javadoc
/**
 * The Class LoopGameTest.
 */
public class LoopGameTest {

    /** The Is running. */
    Boolean IsRunning = true;

    /** The controller. */
    IController controller;

    /** The loop game. */
    private final LoopGame loopGame = new LoopGame();

    /**
     * Gets the controller test.
     *
     */
    @Test
    public void getControllerTest() {
        assertEquals(this.controller, this.loopGame.getController());
    }

    /**
     * Gets the checks if is running test.
     *
     */
    @Test
    public void getIsRunningTest() {
        assertTrue(this.loopGame.getIsRunning());
    }

    /**
     * Render.
     */
    @Test
    public void render() {
        this.loopGame.setIsRunning(this.IsRunning);
        if (this.loopGame.getIsRunning() == false) {
            fail("la game loop est arrétée");
        }
    }

    /**
     * Sets the controller test.
     */
    @Test
    public void setControllerTest() {
        this.loopGame.setController(this.controller);
        assertEquals(this.controller, this.loopGame.getController());
    }

    /**
     * Sets the is running test.
     */
    @Test
    public void setIsRunningTest() {
        this.loopGame.setIsRunning(true);
        assertTrue(this.loopGame.getIsRunning());
    }
}