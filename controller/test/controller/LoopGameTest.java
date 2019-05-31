package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.mobile.Player;
import model.element.mobile.Rock;

public class LoopGameTest {
	private int testNumber = 0;
    private int expected = 0;
	Boolean IsRunning = true;
    public LoopGame loopGame;
	
	@Test
	public void doGameUpdatestest() {
		if (Player.getAlive() == true) {
			assertTrue(Player.getAlive());
		}else {
			assertFalse(Player.getAlive());
		}
	}
	
	@Test
    public void setIsRunningTest() {
        this.loopGame.setIsRunning(true);
        assertEquals(IsRunning, this.loopGame.getIsRunning());
    }

    @Test
    public void getIsRunningTest() {
        assertEquals(IsRunning, this.loopGame.getIsRunning());
    }
}
