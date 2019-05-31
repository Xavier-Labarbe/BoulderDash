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

        final PlayableMap playableMap = new PlayableMap();
        final MotionlessFactory factory = new MotionlessFactory();
        final MobileFactory mobileFactory = new MobileFactory(playableMap);

        i = 0;
        // for (int i = 0; i < entity.getFillingMaps().size(); i++)
        for (final FillingMap fillingMap : map.getFillingMaps()) {

            // entity.getFillingMaps().forEach(FillingMap -> {

            switch (fillingMap.getElementChar()) {
            case "|":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case " ":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "W":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "T":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "E":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "R":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), mobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                playableMap.addMobiles(mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
                i++;
                break;
            case "M":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), mobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                playableMap.addMobiles(mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
                i++;
                break;
            case "D":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), mobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                playableMap.addMobiles(mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
                i++;
                break;
            case "P":
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), mobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                playableMap.addMobiles(mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
                i++;
                break;
            default:
                break;
            }
        }
        // });
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
                    /*
                     * System.out.println("x : " + x); System.out.println("y : " + y);
                     * System.out.println(playableMap.getXYElement(x, y) + " ");
                     */
                    System.out.print(playableMap.getXYElement(x, y).getSprite().getConsoleImage());
                } catch (final Exception e) {

                }
            }
            System.out.println();
        }
    }

    /*
     * final String sql = "{call helloworldByCode(?)}"; final CallableStatement call
     * = this.getConnection().prepareCall(sql); call.setString(1, code);
     * call.execute(); final ResultSet resultSet = call.getResultSet(); if
     * (resultSet.first()) { helloWorld = new HelloWorld(resultSet.getInt("id"),
     * code, resultSet.getString("message"));
     */

    @Override
    public Map find(final int id, final String label, final int width, final int height) {
        Map map = new Map(id, label, height, width);
        try {
            final String FillingMapRequest = "{call  getLabelXY(1)}";
            final String mapRequest = "{call  getMap(\"MAP\")}";

            final CallableStatement requestMap = this.getConnection().prepareCall(mapRequest);
            final CallableStatement requestFillingMap = this.getConnection().prepareCall(FillingMapRequest);
            // call.setInt();
            requestMap.execute();
            requestFillingMap.execute();
            final ResultSet mapResultSet = requestMap.getResultSet();
            final ResultSet fillingMapResultSet = requestFillingMap.getResultSet();

            if (mapResultSet.first()) {
                map = new Map(id, mapResultSet.getString("label"), width, height);
            }

            while (fillingMapResultSet.next()) {

                map.add(new FillingMap(new ElementType(fillingMapResultSet.getString("ELEMENT_CHAR")),
                        fillingMapResultSet.getInt("x"), fillingMapResultSet.getInt("y")));
            }

            return map;

        } catch (final SQLException e) {
            e.printStackTrace();
        }
        System.out.println("null fdp");
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
