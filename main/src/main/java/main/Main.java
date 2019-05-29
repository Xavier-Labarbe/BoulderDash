/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import contract.IModel;
import controller.Controller;
import controller.LoopGame;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws InterruptedException 
	 */
	public static void main(final String[] args) throws InterruptedException {
		LoopGame.loopGame();
		final IModel model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);

		controller.control();
		controller.orderPerform(ControllerOrder.NOTHING);
	}
}
