package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ElementType;

public class DAOElementsTypes extends DAOEntity<ElementType> {

	public DAOElementsTypes(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public boolean create(ElementType entity) {
		return false;
	}

	@Override
	public boolean delete(ElementType entity) {
		return false;
	}

	@Override
	public boolean update(ElementType entity) {
		return false;
	}

	@Override
	public ElementType find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElementType find(int id, String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementType find(String label) {
		ElementType elementType = new ElementType(label);

		try {
			final String sql = "{call helloworldById(?)}";
			final CallableStatement call = getConnection().prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				elementType = new ElementType(resultSet.getString("label"));
			}
			return elementType;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
