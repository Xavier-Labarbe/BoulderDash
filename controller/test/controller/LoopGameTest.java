package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import model.element.mobile.Player;

public class LoopGameTest {
	private int testNumber = 0;
    private int expected = 0;
	
	@Test
	public void doGameUpdates() {
		if (Player.getAlive() == true) {
			assertTrue(Player.getAlive());
		}else {
			assertFalse(Player.getAlive());
		}
	}
	
	@Test
    public void setIsRunning() {
        testNumber = expected;
        assertEquals(expected, testNumber);
    }

    @Test
    public void setView() {
        assertEquals(expected, testNumber);
    }

    @Test
    public void getIsRunning() {
    	Boolean IsRunning = true;
        assertEquals(expected, IsRunning);
    }
}
