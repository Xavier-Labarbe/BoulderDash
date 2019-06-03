package model.element.motionless;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.DoorState;
import model.PlayableMap;

public class ExitTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    Exit exit;

    @Test
    public void getDoorStatetest() {
        final DoorState expected = DoorState.CLOSE;
        assertEquals(expected, this.exit.getDoorState());
    }

    @Test
    public void opentest() {
        final DoorState expected = DoorState.OPEN;
        this.exit.open();
        assertEquals(expected, this.exit.getDoorState());
    }

    @Before
    public void setUp() throws Exception {
        this.exit = new Exit(new PlayableMap(2, 2, 2));
    }

    @After
    public void tearDown() throws Exception {
    }

}
