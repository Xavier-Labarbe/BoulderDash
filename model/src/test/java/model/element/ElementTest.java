package model.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.Permeability;
import model.PlayableMap;
import model.element.mobile.Rock;

// TODO: Auto-generated Javadoc
/**
 * The Class ElementTest.
 */
public class ElementTest {

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

    /** The rock. */
    public Rock rock;

    /**
     * Gets the permeabilitytest.
     *
     */
    @Test
    public void getPermeabilitytest() {
        final Permeability expected = Permeability.BLOCKING;
        assertEquals(expected, this.rock.getPermeability());

    }

    /**
     * Gets the spritetest.
     *
     */
    @Test
    public void getSpritetest() {

        assertNotNull(this.rock.getSprite());
    }

    /**
     * Checks if is explosable test.
     */
    @Test
    public void isExplosableTest() {
        final Boolean expected = true;
        assertEquals(expected, this.rock.isExplosable());

    }

    /**
     * Sets the up.
     *
     */
    @Before
    public void setUp() throws Exception {
        this.rock = new Rock(0, 0, new PlayableMap(2, 2, 2));
    }

    /**
     * Tear down.
     *
     */
    @After
    public void tearDown() throws Exception {
    }

}
