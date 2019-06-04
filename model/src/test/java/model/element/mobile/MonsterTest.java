package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;
import model.element.motionless.Tunnel;

// TODO: Auto-generated Javadoc
/**
 * The Class MonsterTest.
 */
public class MonsterTest {

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

    /** The monster. */
    public Monster monster;

    /** The map. */
    public PlayableMap map;

    /**
     * Killtest.
     */
    @Test
    public void killtest() {
        final Player player = new Player(0, 0, this.map);
        final Boolean expected = false;
        this.monster.kill(player);
        assertEquals(expected, player.isAlive());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.map = new PlayableMap(2, 10, 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.map.setXYElement(i, j, new Tunnel());
            }
        }
        this.monster = new Monster(5, 5, this.map);
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
