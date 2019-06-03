package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PlayableMap;

public class MobileFactoryTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    MobileFactory fatory;
    PlayableMap map;

    @Test
    public void getFromFileSymboltest() {
        final Rock expected = new Rock(0, 0, this.map);
        assertEquals(expected.getClass(), this.fatory.getFromFileSymbol("R", 0, 0, this.map).getClass());
    }

    @Before
    public void setUp() throws Exception {
        this.map = new PlayableMap(2, 2, 2);
        this.fatory = new MobileFactory(this.map);
    }

    @After
    public void tearDown() throws Exception {
    }

}
