package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ElementType;
import entity.FillingMap;
import entity.Map;
import model.element.mobile.MobileFactory;
import model.element.motionless.MotionlessFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOMap.
 */
public class DAOMap extends DAOEntity<Map> {

    /** The connection. */
    private Connection connection;

    /**
     * Instantiates a new DAO map.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public DAOMap(final Connection connection) throws SQLException {
        super(connection);
        this.connection = connection;
    }

    /**
     * Creates the.
     *
     * @param map the map
     * @return the playable map
     */
    @Override
    public PlayableMap create(final Map map) {

        final PlayableMap playableMap = new PlayableMap(map.getDiamondNumberForWin(), map.getWidth(), map.getHeight());
        for (final FillingMap fillingMap : map.getFillingMaps()) {
            switch (fillingMap.getElementChar()) {
            case "|":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        MotionlessFactory.getFromFileSymbol(fillingMap.getElementChar(), playableMap));
                break;
            case " ":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        MotionlessFactory.getFromFileSymbol(fillingMap.getElementChar(), playableMap));
                break;
            case "W":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        MotionlessFactory.getFromFileSymbol(fillingMap.getElementChar(), playableMap));
                break;
            case "T":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        MotionlessFactory.getFromFileSymbol(fillingMap.getElementChar(), playableMap));
                break;
            case "E":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        MotionlessFactory.getFromFileSymbol(fillingMap.getElementChar(), playableMap));
                break;
            case "R":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), MobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));

                break;
            case "M":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), MobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                break;
            case "D":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), MobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                break;
            case "P":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), MobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                break;
            default:
                break;
            }
        }
        return playableMap;
    }

    /**
     * Display.
     *
     * @param playableMap the playable map
     */

    /**
     * Find.
     *
     * @param id the id
     * @return the map
     */
    @Override
    public Map find(final int id) {
        Map map = null;
        try {
            final String FillingMapRequest = "{call  getLabelXY(" + id + ")}";
            final String mapRequest = "{call  getMap(" + id + ")}";

            final CallableStatement requestMap = this.getConnection().prepareCall(mapRequest);
            final CallableStatement requestFillingMap = this.getConnection().prepareCall(FillingMapRequest);
            // call.setInt();
            requestMap.execute();
            requestFillingMap.execute();
            final ResultSet mapResultSet = requestMap.getResultSet();
            final ResultSet fillingMapResultSet = requestFillingMap.getResultSet();
            if (mapResultSet.first()) {
                map = new Map(id, mapResultSet.getString("label"), mapResultSet.getInt("WIDTH"),
                        mapResultSet.getInt("HEIGHT"), mapResultSet.getInt("D_NUMBER_FOR_WIN"));

                while (fillingMapResultSet.next()) {
                    map.add(new FillingMap(new ElementType(fillingMapResultSet.getString("ELEMENT_CHAR")),
                            fillingMapResultSet.getInt("x"), fillingMapResultSet.getInt("y")));
                }

            }

            return map;

        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    @Override
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Sets the connection.
     *
     * @param connection the new connection
     */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

}
