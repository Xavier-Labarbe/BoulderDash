package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MapTest {
	ArrayList<FillingMap> fillingMap = new ArrayList<FillingMap>();
	int id = 1;
	String label = "Hello";
	int width = 2;
	int height = 3;
	int diamondNumberForWin = 4;
	private Map map = new Map(id, label, width, height, diamondNumberForWin);
	
	@Test
    public void getHeight() {
    	assertEquals(height, this.map.getHeight());
    }

	@Test
    public void getId() {
    	assertEquals(id, this.map.getId());
    }

	@Test
    public void getWidth() {
    	assertEquals(width, this.map.getWidth());
    }
	
	@Test
    public void getdiamondNumberForWin() {
    	assertEquals(diamondNumberForWin, this.map.getDiamondNumberForWin());
    }
	
	@Test
	public void getElementLabel() {
		assertEquals(label, this.map.getelementLabel());
	}
	
	@Test
	public void getFillingMaps() {
		assertEquals(fillingMap, this.map.getFillingMaps());
	}
}
