package model.element;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class SpriteTest.
 */
public class SpriteTest {

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

    /** The sprite. */
    public Sprite sprite;

    /**
     * Gets the console imagetest.
     *
     */
    @Test
    public void getConsoleImagetest() {
        final String expected = "R";
        assertEquals(expected, this.sprite.getConsoleImage());
    }

    /**
     * Gets the image nametest.
     *
     */
    @Test
    public void getImageNametest() {
        final String expected = "rock.png";
        assertEquals(expected, this.sprite.getImageName());
    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.sprite = new Sprite("R", "rock.png");
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
