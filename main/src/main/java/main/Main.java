/**
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
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws SQLException the SQL exception
     */
    public static void main(final String[] args) throws SQLException {
        final DAOMap dao = new DAOMap(DBConnection.getInstance().getConnection());
        final IPlayableMap playableMap = dao.create(dao.find(5));
        final IModel model = new Model();
        model.setPlayableMap(playableMap);
        final IView view = new View(model);
        final IController controller = new Controller(view, model);
        controller.start();

    }
}
