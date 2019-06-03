package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElementTypeTest {
	String expected = "Hello";
	private ElementType elementType = new ElementType(expected);
	@Test
    public void setElementCharTest() {
        this.elementType.setElementChar("Hello");
        assertEquals(expected, this.elementType.getElementChar());
    }

    @Test
    public void getElementCharTest() {
        assertEquals(expected, this.elementType.getElementChar());
    }

}
