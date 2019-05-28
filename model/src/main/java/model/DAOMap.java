package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ElementType;
import entity.FillingMap;
import entity.Map;

public class DAOMap extends DAOEntity<Map> {

	private Connection connection;

	public DAOMap(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean create(Map entity) {
		return false;
	}

	@Override
	public boolean delete(Map entity) {
		return false;
	}

	@Override
	public boolean update(Map entity) {
		return false;
	}

	public Map find(int id, String label, int width, int height) {
		Map map = new Map(id, label, height, width);

		try {
			final String sql = "{call  getLabelXY(1)}";
			final CallableStatement call = getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(id, resultSet.getString("label"), width, height);
			}
			if (resultSet.next()) {

				map.add(new FillingMap(new ElementType(resultSet.getString("label")), resultSet.getInt("x"), resultSet.getInt("y")));
			}

			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
