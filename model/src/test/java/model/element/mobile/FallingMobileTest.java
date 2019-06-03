package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;

public class FallingMobileTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    public Rock rock;

    @Test
    public void isFallingtest() {
        final Boolean expected = false;
        assertEquals(expected, this.rock.isFalling());
    }

    @Test
    public void killtest() {
        final Monster monster = new Monster(0, 0, new PlayableMap(2, 2, 2));
        final Boolean expected = false;
        this.rock.kill(monster);
        assertEquals(expected, monster.isAlive());
    }

    @Test
    public void setFallingtest() {
        final Boolean expected = true;
        this.rock.setFalling(true);
        assertEquals(expected, this.rock.isFalling());
    }

    @Before
    public void setUp() throws Exception {
        this.rock = new Rock(0, 0, new PlayableMap(2, 2, 2));
    }

    @After
    public void tearDown() throws Exception {
    }

}
