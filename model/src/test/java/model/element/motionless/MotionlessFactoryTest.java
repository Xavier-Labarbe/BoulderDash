package model.element.motionless;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;

public class MotionlessFactoryTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    MotionlessFactory fatory;

    PlayableMap map;

    @Test
    public void getFromFileSymboltest() {
        final Dirt expected = new Dirt();
        assertEquals(expected.getClass(), this.fatory.getFromFileSymbol(" ").getClass());
    }

    @Before
    public void setUp() throws Exception {
        this.map = new PlayableMap(2, 2, 2);
        this.fatory = new MotionlessFactory(this.map);
    }

    @After
    public void tearDown() throws Exception {
    }

}
