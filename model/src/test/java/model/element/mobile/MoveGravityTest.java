package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;
import model.element.motionless.Dirt;
import model.element.motionless.Tunnel;

// TODO: Auto-generated Javadoc
/**
 * The Class MoveGravityTest.
 */
public class MoveGravityTest {

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

    /** The rock 1. */
    Rock rock1;

    /** The map 1. */
    PlayableMap map1;

    /** The rock 2. */
    Rock rock2;

    /** The map 2. */
    PlayableMap map2;

    /**
     * Move diagonaltest.
     */
    @Test
    public void moveDiagonaltest() {
        final int expectedx1 = 2;
        final int expectedy1 = 2;
        this.rock2.move();
        assertEquals(expectedx1, this.rock2.getX());
        assertEquals(expectedy1, this.rock2.getY());

    }

    /**
     * Movedowntest.
     */
    @Test
    public void movedowntest() {
        final int expectedx1 = 1;
        final int expectedy1 = 2;
        this.rock1.move();
        assertEquals(expectedx1, this.rock1.getX());
        assertEquals(expectedy1, this.rock1.getY());

    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.map1 = new PlayableMap(2, 3, 3);
        this.map2 = new PlayableMap(2, 3, 3);
        this.map1.setPlayer(new Player(0, 0, this.map1));
        this.map2.setPlayer(new Player(0, 0, this.map2));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.map1.setXYElement(i, j, new Dirt());
                this.map2.setXYElement(i, j, new Dirt());
            }
        }
        this.map1.setXYElement(1, 2, new Tunnel());
        this.map2.setXYElement(2, 1, new Tunnel());
        this.map2.setXYElement(2, 2, new Tunnel());
        this.map2.setXYElement(1, 2, new Rock(1, 2, this.map2));
        this.rock1 = new Rock(1, 1, this.map1);
        this.rock2 = new Rock(1, 1, this.map2);
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
