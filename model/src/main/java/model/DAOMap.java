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

public class DAOMap extends DAOEntity<Map> {

    private Connection connection;

    public DAOMap(final Connection connection) throws SQLException {
        super(connection);
        this.connection = connection;
    }

    @Override
    public PlayableMap create(final Map map) {

        int i = 0;
        final PlayableMap playableMap = new PlayableMap(map.getDiamondNumberForWin(), map.getWidth(), map.getHeight());
        final MotionlessFactory factory = new MotionlessFactory(playableMap);

        i = 0;
        for (final FillingMap fillingMap : map.getFillingMaps()) {

            switch (fillingMap.getElementChar()) {
            case "|":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                break;
            case " ":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                break;
            case "W":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                break;
            case "T":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                break;
            case "E":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
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

        this.display(playableMap);
        return playableMap;
    }

    @Override
    public boolean delete(final Map map) {
        return false;
    }

    public void display(final PlayableMap playableMap) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                try {
                    System.out.print(playableMap.getXYElement(x, y).getSprite().getConsoleImage());
                } catch (final Exception e) {

                }
            }
            System.out.println();
        }
        System.out.println();

    }

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

    @Override
    public Map find(final String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean update(final Map entity) {
        return false;
    }

}
