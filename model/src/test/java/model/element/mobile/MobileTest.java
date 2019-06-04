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
 * The Class MobileTest.
 */
public class MobileTest {

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
     * Gets the strategytest.
     *
     */
    @Test
    public void getStrategytest() {
        final StrategyMove expected = new MoveGravity();
        assertEquals(expected.getClass(), this.rock.getStrategyMove().getClass());
    }

    /**
     * Gets the xtest.
     *
     */
    @Test
    public void getXtest() {
        final int expected = 1;
        assertEquals(expected, this.rock.getX());
    }

    /**
     * Gets the ytest.
     *
     */
    @Test
    public void getYtest() {
        final int expected = 1;
        assertEquals(expected, this.rock.getY());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.rock = new Rock(1, 1, new PlayableMap(2, 2, 2));

    }

    /**
     * Sets the xtest.
     */
    @Test
    public void setXtest() {
        final int expected = 0;
        this.rock.setX(0);
        assertEquals(expected, this.rock.getX());
    }

    /**
     * Sets the ytest.
     */
    @Test
    public void setYtest() {
        final int expected = 0;
        this.rock.setY(0);
        assertEquals(expected, this.rock.getY());
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
