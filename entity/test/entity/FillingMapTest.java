package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class FillingMapTest {
	int x = 1;
	int y = 2;
	String elementChar = "Hello";
	private ElementType elementType;
	private FillingMap fillingMap = new FillingMap(elementType, x, y);
	
	@Test
    public void setXTest() {
        this.fillingMap.setX(1);
        assertEquals(x, this.fillingMap.getX());
    }

    @Test
    public void getXTest() {
        assertEquals(x, this.fillingMap.getX());
    }
    
    @Test
    public void setYTest() {
        this.fillingMap.setY(2);
        assertEquals(y, this.fillingMap.getY());
    }

    @Test
    public void getYTest() {
        assertEquals(y, this.fillingMap.getY());
    }
}
