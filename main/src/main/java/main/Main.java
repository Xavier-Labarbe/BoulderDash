/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.sql.SQLException;

import contract.IController;
import contract.IModel;
import contract.IPlayableMap;
import contract.IView;
import controller.Controller;
import model.DAOMap;
import model.DBConnection;
import model.Model;
import model.element.mobile.Diamond;
import model.element.mobile.Monster;
import model.element.mobile.Rock;
import model.element.motionless.Exit;
import model.element.motionless.Tunnel;
import view.View;

public abstract class Main {

    public static void main(final String[] args) throws SQLException {
        final DAOMap dao = new DAOMap(DBConnection.getInstance().getConnection());
        final IPlayableMap playableMap = dao.create(dao.find(1));
        playableMap.setXYElement(1, 6, new Rock(1, 6, playableMap));
        playableMap.setXYElement(2, 5, new Tunnel());
        playableMap.setXYElement(2, 6, new Tunnel());
        playableMap.setXYElement(2, 7, new Tunnel());
        playableMap.setXYElement(2, 8, new Tunnel());
        playableMap.setXYElement(2, 9, new Monster(2, 9, playableMap));
        playableMap.setXYElement(14, 1, new Diamond(14, 1, playableMap));
        playableMap.setXYElement(12, 1, new Diamond(12, 1, playableMap));
        playableMap.setXYElement(16, 1, new Exit(playableMap));
        playableMap.setExit((Exit) playableMap.getXYElement(16, 1));

        final IModel model = new Model();
        model.setPlayableMap(playableMap);
        final IView view = new View(model);
        final IController controller = new Controller(view, model);
        try {
            controller.getLoopGame().loopGame();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
