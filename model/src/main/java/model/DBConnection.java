package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 *
 * @author Group 1.
 */
public final class DBConnection {
    /** The instance. */
    private static DBConnection INSTANCE = null;

    /**
     * Gets the single instance of DBConnection.
     *
     * @return single instance of DBConnection
     */
    public static synchronized DBConnection getInstance() {
        if (DBConnection.INSTANCE == null) {
            DBConnection.INSTANCE = new DBConnection();
        }
        return DBConnection.INSTANCE;
    }

    /** The connection. */
    private Connection connection;

    /**
     * Instantiates a new DB connection.
     */
    private DBConnection() {
        this.open();
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Open.
     *
     * @return the boolean
     */
    private Boolean open() {
        final DBProperties dbProperties = new DBProperties();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(),
                    dbProperties.getPassword());
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
