package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import model.PlayableMap;
import model.element.motionless.Border;
import model.element.motionless.Dirt;
import model.element.motionless.Tunnel;

public class MoveInputTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    Player p1;
    PlayableMap map1;
    Player p2;
    PlayableMap map2;
    Player p3;
    PlayableMap map3;
    Player p4;
    PlayableMap map4;

    @Test
    public void moveOnDiamondtest() {
        final int expectedx1 = 2;
        final int expectedy1 = 1;
        this.p3.move();
        assertEquals(expectedx1, this.p3.getX());
        assertEquals(expectedy1, this.p3.getY());
    }

    @Test
    public void moveOnTunneltest() {
        final int expectedx1 = 2;
        final int expectedy1 = 1;
        this.p4.move();
        assertEquals(expectedx1, this.p4.getX());
        assertEquals(expectedy1, this.p4.getY());

    }

    @Test
    public void movetest() {
        final int expectedx1 = 1;
        final int expectedx2 = 2;
        final int expectedy1 = 1;
        final int expectedy2 = 1;
        this.p1.move();
        this.p2.move();
        assertEquals(expectedx1, this.p1.getX());
        assertEquals(expectedy1, this.p1.getY());
        assertEquals(expectedx2, this.p2.getX());
        assertEquals(expectedy2, this.p2.getY());
    }

    @Before
    public void setUp() throws Exception {
        this.map1 = new PlayableMap(2, 3, 3);
        this.map2 = new PlayableMap(2, 3, 3);
        this.map3 = new PlayableMap(2, 3, 3);
        this.map4 = new PlayableMap(2, 3, 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.map1.setXYElement(i, j, new Border());
                this.map2.setXYElement(i, j, new Border());
                this.map3.setXYElement(i, j, new Diamond(i, j, this.map3));
                this.map4.setXYElement(i, j, new Dirt());
            }
        }
        this.p1 = new Player(1, 1, this.map1);
        this.p2 = new Player(1, 1, this.map2);
        this.p3 = new Player(1, 1, this.map3);
        this.p4 = new Player(1, 1, this.map4);
        this.map1.setPlayer(this.p1);
        this.map2.setPlayer(this.p2);
        this.map3.setPlayer(this.p3);
        this.map4.setPlayer(this.p4);
        this.map2.setXYElement(2, 1, new Tunnel());
        this.p1.setMovingOrder(ControllerOrder.RIGHT);
        this.p2.setMovingOrder(ControllerOrder.RIGHT);
        this.p3.setMovingOrder(ControllerOrder.RIGHT);
        this.p4.setMovingOrder(ControllerOrder.RIGHT);
    }

    @After
    public void tearDown() throws Exception {
    }

}
