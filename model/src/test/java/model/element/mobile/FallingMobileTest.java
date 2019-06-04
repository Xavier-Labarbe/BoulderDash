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
 * The Class FallingMobileTest.
 */
public class FallingMobileTest {

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

    /** The rock. */
    public Rock rock;

    /**
     * Checks if is fallingtest.
     */
    @Test
    public void isFallingtest() {
        final Boolean expected = false;
        assertEquals(expected, this.rock.isFalling());
    }

    /**
     * Killtest.
     */
    @Test
    public void killtest() {
        final Monster monster = new Monster(0, 0, new PlayableMap(2, 2, 2));
        final Boolean expected = false;
        this.rock.kill(monster);
        assertEquals(expected, monster.isAlive());
    }

    /**
     * Sets the fallingtest.
     */
    @Test
    public void setFallingtest() {
        final Boolean expected = true;
        this.rock.setFalling(true);
        assertEquals(expected, this.rock.isFalling());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.rock = new Rock(0, 0, new PlayableMap(2, 2, 2));
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
