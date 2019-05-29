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
    final PlayableMap playableMap = new PlayableMap();

    public DAOMap(final Connection connection) throws SQLException {
        super(connection);
    }

    @Override
    public PlayableMap create(final Map entity) {

        entity.getFillingMaps().forEach(name -> {
            switch (name.getElementChar()) {
            case '|':
                this.playableMap.setXYElement(name.getX(), name.getY(),
                        MotionlessFactory.getFromFileSymbol(name.getElementChar()));
                break;
            case ' ':
                this.playableMap.setXYElement(name.getX(), name.getY(),
                        MotionlessFactory.getFromFileSymbol(name.getElementChar()));
                break;
            case 'W':
                this.playableMap.setXYElement(name.getX(), name.getY(),
                        MotionlessFactory.getFromFileSymbol(name.getElementChar()));
                break;
            case 'T':
                this.playableMap.setXYElement(name.getX(), name.getY(),
                        MotionlessFactory.getFromFileSymbol(name.getElementChar()));
                break;
            case 'E':
                this.playableMap.setXYElement(name.getX(), name.getY(),
                        MotionlessFactory.getFromFileSymbol(name.getElementChar()));
                break;
            case 'R':
                this.playableMap.setXYElement(name.getX(), name.getY(), MobileFactory
                        .getFromFileSymbol(name.getElementChar(), name.getX(), name.getY(), this.playableMap));
                this.playableMap.addMobiles(MobileFactory.getFromFileSymbol(name.getElementChar(), name.getX(),
                        name.getY(), this.playableMap));
            case 'M':
                this.playableMap.setXYElement(name.getX(), name.getY(), MobileFactory
                        .getFromFileSymbol(name.getElementChar(), name.getX(), name.getY(), this.playableMap));
                this.playableMap.addMobiles(MobileFactory.getFromFileSymbol(name.getElementChar(), name.getX(),
                        name.getY(), this.playableMap));
                break;
            case 'D':
                this.playableMap.setXYElement(name.getX(), name.getY(), MobileFactory
                        .getFromFileSymbol(name.getElementChar(), name.getX(), name.getY(), this.playableMap));
                this.playableMap.addMobiles(MobileFactory.getFromFileSymbol(name.getElementChar(), name.getX(),
                        name.getY(), this.playableMap));
                break;
            case 'P':
                this.playableMap.setXYElement(name.getX(), name.getY(), MobileFactory
                        .getFromFileSymbol(name.getElementChar(), name.getX(), name.getY(), this.playableMap));
                this.playableMap.addMobiles(MobileFactory.getFromFileSymbol(name.getElementChar(), name.getX(),
                        name.getY(), this.playableMap));
                break;
            default:
                break;
            }

        });
        return this.playableMap;
    }

    @Override
    public boolean delete(final Map entity) {
        return false;
    }

    @Override
    public Map find(final int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Map find(final int id, final String label, final int width, final int height) {
        Map map = new Map(id, label, height, width);

        try {
            final String sql = "{call  getLabelXY(1)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                map = new Map(id, resultSet.getString("label"), width, height);
            }

            if (resultSet.next()) {

                map.add(new FillingMap(new ElementType(resultSet.getString("ELEMENT_CHAR")), resultSet.getInt("x"),
                        resultSet.getInt("y")));
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
