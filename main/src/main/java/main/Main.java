/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.sql.SQLException;

import model.DAOMap;
import model.DBConnection;

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
     * @throws SQLException
     */
    public static void main(final String[] args) throws SQLException {

        final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
        daoMap.create(daoMap.find(1));
    }
}
