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
import view.View;

public abstract class Main {

    public static void main(final String[] args) throws SQLException {
        final DAOMap dao = new DAOMap(DBConnection.getInstance().getConnection());
        final IPlayableMap playableMap = dao.create(dao.find(4));
        final IModel model = new Model();
        model.setPlayableMap(playableMap);
        final IView view = new View(model);
        final IController controller = new Controller(view, model);
        controller.start(4);

    }
}
