package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayableMapTest {
	int height = 1;
	int width = 2;
	int numberOfDiamondForWin = 3;
    private PlayableMap Playablemap = new PlayableMap(numberOfDiamondForWin,width,height);
	@Test
    public void setHeightTest() {
        this.Playablemap.setHeight(1);
        assertEquals(height, this.Playablemap.getHeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(height, this.Playablemap.getHeight());
    }
    
    @Test
    public void setWidthTest() {
        this.Playablemap.setWidth(2);
        assertEquals(width, this.Playablemap.getWidth());
    }

    @Test
    public void getWidthTest() {
        assertEquals(width, this.Playablemap.getWidth());
    }
    
    @Test
    public void setNumberOfDiamondForWinTest() {
        this.Playablemap.setNumberOfDiamondForWin(3);
        assertEquals(numberOfDiamondForWin, this.Playablemap.getNumberOfDiamondForWin());
    }

    @Test
    public void getNumberOfDiamondForWinTest() {
        assertEquals(numberOfDiamondForWin, this.Playablemap.getNumberOfDiamondForWin());
    }
}
