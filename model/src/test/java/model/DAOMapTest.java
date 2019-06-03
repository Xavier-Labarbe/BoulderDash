package model;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DAOMapTest {
	int testNumber = 0;
	
    @Test
    public void create() {
        boolean expectedBool = false;
        switch(testNumber) {
        case 0 :
            expectedBool = true;
        default :
            break;
        }
        assertTrue(expectedBool);
    }
    
    @Test
    public void delete() {
    	Boolean expectedBool = false;
    	if (expectedBool == true) {
    		fail("Bolean doesn't have the good value");
    	}
    }
}
