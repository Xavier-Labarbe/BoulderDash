package model;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Entity;

/***
 * The Class DAOEntity.**
 *
 * @author Jean-Aymeric Diet**@param <E>*the element type
 */
abstract class DAOEntity<E extends Entity> {

    /** The connection. */
    private final Connection connection;

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection
     *            the connection
     * @throws SQLException
     *             the SQL exception
     */
    public DAOEntity(final Connection connection) throws SQLException {
        this.connection = connection;
    }

    /**
     * Creates the.
     *
     * @param entity
     *            the entity
     * @return true, if successful
     */
    public abstract PlayableMap create(E entity);

    /**
     * Delete.
     *
     * @param entity
     *            the entity
     * @return true, if successful
     */
    public abstract boolean delete(E entity);

    /**
     * Find.
     *
     * @param id
     *            the id
     * @return the e
     */
    /**
     * Find.
     *
     * @param code
     *            the code
     * @return the e
     */
    public abstract E find(final int id, final String label, final int width, final int height);

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    protected Connection getConnection() {
        return this.connection;
    }

    /**
     * Update.
     *
     * @param entity
     *            the entity
     * @return true, if successful
     */
    public abstract boolean update(E entity);

}
