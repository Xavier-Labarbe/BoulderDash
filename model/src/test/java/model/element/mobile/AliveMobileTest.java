package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;

public class AliveMobileTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    public Player player;

    @Test
    public void isAlivetest() {
        final Boolean expected = true;
        assertEquals(expected, this.player.isAlive());
    }

    @Test
    public void setAlivetest() {
        final Boolean expected = false;
        this.player.setAlive(false);
        assertEquals(expected, this.player.isAlive());
    }

    @Before
    public void setUp() throws Exception {
        this.player = new Player(1, 1, new PlayableMap(2, 2, 2));
    }

    @After
    public void tearDown() throws Exception {
    }

}
