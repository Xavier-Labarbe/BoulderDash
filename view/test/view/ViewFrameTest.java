package view;

import static org.junit.Assert.*;

import org.junit.Test;

import contract.IController;
import contract.IModel;

public class ViewFrameTest {
    public IController controller;
    public IModel model;
    public ViewFrame viewFrame;
    @Test
    public void getControllerTest() {
        assertEquals(this.viewFrame.getController(), controller);
    }

    @Test
    public void getModelTest() {
        assertEquals(this.viewFrame.getModel(), model);
    }
    
    @Test
    public void setControllerTest() {
    	this.viewFrame.setController(controller);
    	assertEquals(controller, this.viewFrame.getController());
    }
    
    @Test
    public void setModelTest() {
    	this.viewFrame.setModel(model);
    	assertEquals(model, this.viewFrame.getModel());
    }
}
