package model.element;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    public Sprite sprite;

    @Test
    public void getConsoleImagetest() {
        final String expected = "R";
        assertEquals(expected, this.sprite.getConsoleImage());
    }

    @Test
    public void getImageNametest() {
        final String expected = "rock.png";
        assertEquals(expected, this.sprite.getImageName());
    }

    @Before
    public void setUp() throws Exception {
        this.sprite = new Sprite("R", "rock.png");
    }

    @After
    public void tearDown() throws Exception {
    }

}
