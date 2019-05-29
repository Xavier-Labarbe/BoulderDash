package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViewPanelTest {
	   int ViewFrame=1;
	@Test
    public void getViewFrame() {
		int expected = 1;
        assertEquals(expected, ViewFrame);
    }

}
