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
 * The Class MoveAutoTest.
 */
public class MoveAutoTest {

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

    /** The monster 1. */
    Monster monster1;

    /** The map 1. */
    PlayableMap map1;

    /** The monster 2. */
    Monster monster2;

    /** The map 2. */
    PlayableMap map2;

    /**
     * Movetest.
     */
    @Test
    public void movetest() {
        final int expectedx1 = 1;
        final int expectedx2 = 2;
        final int expectedy1 = 1;
        final int expectedy2 = 1;
        this.monster1.move();
        this.monster2.move();
        assertEquals(expectedx1, this.monster1.getX());
        assertEquals(expectedy1, this.monster1.getY());
        assertEquals(expectedx2, this.monster2.getX());
        assertEquals(expectedy2, this.monster2.getY());
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
        this.map2.setXYElement(2, 1, new Tunnel());
        this.monster1 = new Monster(1, 1, this.map1);
        this.monster2 = new Monster(1, 1, this.map2);
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
