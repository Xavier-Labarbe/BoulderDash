package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import contract.IController;


public class LoopGameTest {
	Boolean IsRunning = true;
	IController controller;
    private LoopGame loopGame = new LoopGame();
	
	@Test
	public void render() {
		this.loopGame.setIsRunning(IsRunning);
		if (loopGame.getIsRunning() == false) {
			fail("la game loop est arrétée");
		}
	}
	
	@Test
    public void setIsRunningTest() {
        this.loopGame.setIsRunning(true);
        assertTrue(this.loopGame.getIsRunning());
    }

    @Test
    public void getIsRunningTest() {
        assertTrue(this.loopGame.getIsRunning());
    }
    
    @Test
    public void setControllerTest() {
        this.loopGame.setController(controller);
        assertEquals(controller, this.loopGame.getController());
    }

    @Test
    public void getControllerTest() {
        assertEquals(controller, this.loopGame.getController());
    }
}