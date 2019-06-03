package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;
import model.element.motionless.Tunnel;

public class MonsterTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    public Monster monster;
    public PlayableMap map;

    @Test
    public void killtest() {
        final Player player = new Player(0, 0, this.map);
        final Boolean expected = false;
        this.monster.kill(player);
        assertEquals(expected, player.isAlive());
    }

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

    @After
    public void tearDown() throws Exception {
    }

}
