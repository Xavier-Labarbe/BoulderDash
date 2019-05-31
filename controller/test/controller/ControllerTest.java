package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import contract.IModel;

public class ControllerTest {

    int testNumber = 0;
    public Controller controller;

    @Test
    public void orderPerform() {
        boolean expectedBool = false;
        switch(testNumber) {
        case 0 :
            expectedBool = true;
        default :
            break;
        }
        assertTrue(expectedBool);
    }
}
