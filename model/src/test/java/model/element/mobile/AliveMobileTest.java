package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;

// TODO: Auto-generated Javadoc
/**
 * The Class AliveMobileTest.
 */
public class AliveMobileTest {

    /**
     * Sets the up before class.
     *
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * Tear down after class.
     *
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /** The player. */
    public Player player;

    /**
     * Checks if is alivetest.
     */
    @Test
    public void isAlivetest() {
        final Boolean expected = true;
        assertEquals(expected, this.player.isAlive());
    }

    /**
     * Sets the alivetest.
     */
    @Test
    public void setAlivetest() {
        final Boolean expected = false;
        this.player.setAlive(false);
        assertEquals(expected, this.player.isAlive());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.player = new Player(1, 1, new PlayableMap(2, 2, 2));
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
