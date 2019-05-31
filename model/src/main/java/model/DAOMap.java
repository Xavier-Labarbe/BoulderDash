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
        for (final FillingMap fillingMap : map.getFillingMaps()) {
            System.out.println(fillingMap.getElementChar());
            i++;
        }
        System.out.println(i);

        final PlayableMap playableMap = new PlayableMap();
        final MotionlessFactory factory = new MotionlessFactory();
        final MobileFactory mobileFactory = new MobileFactory(playableMap);

        i = 0;
        // for (int i = 0; i < entity.getFillingMaps().size(); i++)
        for (final FillingMap fillingMap : map.getFillingMaps()) {

            // entity.getFillingMaps().forEach(FillingMap -> {

            switch (fillingMap.getElementChar()) {
            case "|":
                System.out.println("|" + factory.getFromFileSymbol(fillingMap.getElementChar()));
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case " ":
                System.out.println(" " + factory.getFromFileSymbol(fillingMap.getElementChar()));
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "W":
                System.out.println("W" + factory.getFromFileSymbol(fillingMap.getElementChar()));
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "T":
                System.out.println("T" + factory.getFromFileSymbol(fillingMap.getElementChar()));
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "E":
                System.out.println("E" + factory.getFromFileSymbol(fillingMap.getElementChar()));
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(),
                        factory.getFromFileSymbol(fillingMap.getElementChar()));
                i++;
                break;
            case "R":
                System.out.println("R" + mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
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
                System.out.println("D" + mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
                playableMap.setXYElement(fillingMap.getX(), fillingMap.getY(), mobileFactory.getFromFileSymbol(
                        fillingMap.getElementChar(), fillingMap.getX(), fillingMap.getY(), playableMap));
                playableMap.addMobiles(mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
                i++;
                break;
            case "P":
                System.out.println("P" + mobileFactory.getFromFileSymbol(fillingMap.getElementChar(), fillingMap.getX(),
                        fillingMap.getY(), playableMap));
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
        System.out.println(i);
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
                     * System.out.println("x : " + x); System.out.println("y : "
                     * + y); System.out.println(playableMap.getXYElement(x, y) +
                     * " ");
                     */
                    System.out.print(playableMap.getXYElement(x, y).getSprite().getConsoleImage());
                } catch (final Exception e) {

                }
            }
            System.out.println();
        }
    }

    /*
     * final String sql = "{call helloworldByCode(?)}"; final CallableStatement
     * call = this.getConnection().prepareCall(sql); call.setString(1, code);
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

            int i = 0;
            for (final FillingMap fillingMap : map.getFillingMaps()) {
                System.out.println(fillingMap.getElementChar());
                i++;
            }
            System.out.print(i);
            System.out.println("nice fdp");
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
