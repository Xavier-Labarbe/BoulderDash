// package model;
//
// import java.sql.CallableStatement;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.SQLException;
//
// import entity.ElementType;
// import entity.FillingMap;
//
// public class DAOFillingMap extends DAOEntity<FillingMap>{
//
// public DAOFillingMap(Connection connection) throws SQLException {
// super(connection);
// // TODO Auto-generated constructor stub
// }
//
// @Override
// public boolean create(FillingMap entity) {
// // TODO Auto-generated method stub
// return false;
// }
//
// @Override
// public boolean delete(FillingMap entity) {
// // TODO Auto-generated method stub
// return false;
// }
//
// @Override
// public boolean update(FillingMap entity) {
// // TODO Auto-generated method stub
// return false;
// }
//
// @Override
// public FillingMap find(int id) {
// // TODO Auto-generated method stub
// return null;
// }
//
// @Override
// public FillingMap find(String code) {
// // TODO Auto-generated method stub
// return null;
// }
//
// public FillingMap find(ElementType elementType, int x, int y) {
// FillingMap fillingMap = new FillingMap(elementType, x, y);
//
// try {
// final String sql = "{call machin(?)}";
// final CallableStatement call = getConnection().prepareCall(sql);
// call.setInt(1, id);
// call.execute();
// final ResultSet resultSet = call.getResultSet();
// if (resultSet.first()) {
// fillingMap = new FillingMap(new DAOElementsTypes());
// }
// return fillingMap;
// } catch (final SQLException e) {
// e.printStackTrace();
// }
// return null;
//
// }
// }
