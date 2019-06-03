package model.element.motionless;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MotionlessTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    Dirt dirt;

    @Test
    public void iSBreakabletest() {
        final Boolean expected = true;
        assertEquals(expected, this.dirt.isExplosable());
    }

    @Before
    public void setUp() throws Exception {
        this.dirt = new Dirt();
    }

    @After
    public void tearDown() throws Exception {
    }

}
