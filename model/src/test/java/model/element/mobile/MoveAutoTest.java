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

public class MoveAutoTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    Monster monster1;
    PlayableMap map1;
    Monster monster2;
    PlayableMap map2;

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

    @After
    public void tearDown() throws Exception {
    }

}
