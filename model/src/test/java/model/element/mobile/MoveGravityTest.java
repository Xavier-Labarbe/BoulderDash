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

public class MoveGravityTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    Rock rock1;
    PlayableMap map1;
    Rock rock2;

    PlayableMap map2;

    @Test
    public void moveDiagonaltest() {
        final int expectedx1 = 2;
        final int expectedy1 = 2;
        this.rock2.move();
        assertEquals(expectedx1, this.rock2.getX());
        assertEquals(expectedy1, this.rock2.getY());

    }

    @Test
    public void movedowntest() {
        final int expectedx1 = 1;
        final int expectedy1 = 2;
        this.rock1.move();
        assertEquals(expectedx1, this.rock1.getX());
        assertEquals(expectedy1, this.rock1.getY());

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
        this.map1.setXYElement(1, 2, new Tunnel());
        this.map2.setXYElement(2, 1, new Tunnel());
        this.map2.setXYElement(2, 2, new Tunnel());
        this.map2.setXYElement(1, 2, new Rock(1, 2, this.map2));
        this.rock1 = new Rock(1, 1, this.map1);
        this.rock2 = new Rock(1, 1, this.map2);
    }

    @After
    public void tearDown() throws Exception {
    }

}
