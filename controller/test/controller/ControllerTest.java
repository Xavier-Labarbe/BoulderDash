package controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import contract.ILoopGame;
import contract.IModel;
import model.Model;
import view.View;

public class ControllerTest {
	ILoopGame loopGame;
	Model model = new Model();
	View view = new View(model);
	private Controller controller = new Controller(view, model);

    @Test
    public void setModelTest() {
        this.controller.setModel(model);
        assertEquals(model, this.controller.getModel());
    }

    @Test
    public void getModelTest() {
        assertEquals(model, this.controller.getModel());
    }
    
    @Test
    public void setLoopGameTest() {
        this.controller.setLoopGame(loopGame);
        assertEquals(loopGame, this.controller.getLoopGame());
    }

    @Test
    public void getLoopGameTest() {
        assertEquals(loopGame, this.controller.getLoopGame());
    }
}
