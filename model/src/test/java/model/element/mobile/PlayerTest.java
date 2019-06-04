package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;
import model.element.Element;
import model.element.motionless.Dirt;
import model.element.motionless.Tunnel;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
public class PlayerTest {

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

    /** The map 1. */
    PlayableMap map1;

    /** The player 1. */
    public Player player1;

    /**
     * Dig tunneltest.
     */
    @Test
    public void digTunneltest() {
        final Element expected = new Tunnel();
        this.player1.getMap().setXYElement(5, 6, new Dirt());
        this.player1.digTunnel(5, 6);
        assertEquals(expected.getClass(), this.player1.getMap().getXYElement(5, 6).getClass());
    }

    /**
     * Push rocktest.
     */
    @Test
    public void pushRocktest() {
        final Rock rock1 = new Rock(6, 5, this.map1);
        this.player1.pushRock(rock1);
        final Rock rock2 = new Rock(4, 5, this.map1);
        this.player1.pushRock(rock2);
        assertEquals(6, rock1.getX());
        assertEquals(5, rock1.getY());
        assertEquals(3, rock2.getX());
        assertEquals(5, rock2.getY());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.map1 = new PlayableMap(2, 10, 10);
        this.player1 = new Player(5, 5, this.map1);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.map1.setXYElement(i, j, new Dirt());
            }
        }
        this.map1.setXYElement(3, 5, new Tunnel());
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
