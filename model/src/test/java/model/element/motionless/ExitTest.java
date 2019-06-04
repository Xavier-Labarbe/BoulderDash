package model.element.motionless;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.DoorState;
import model.PlayableMap;

// TODO: Auto-generated Javadoc
/**
 * The Class ExitTest.
 */
public class ExitTest {

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

    /** The exit. */
    Exit exit;

    /**
     * Gets the door statetest.
     *
     */
    @Test
    public void getDoorStatetest() {
        final DoorState expected = DoorState.CLOSE;
        assertEquals(expected, this.exit.getDoorState());
    }

    /**
     * Opentest.
     */
    @Test
    public void opentest() {
        final DoorState expected = DoorState.OPEN;
        this.exit.open();
        assertEquals(expected, this.exit.getDoorState());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.exit = new Exit(new PlayableMap(2, 2, 2));
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
