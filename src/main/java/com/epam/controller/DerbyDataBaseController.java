package com.epam.controller;

import java.sql.*;

public class DerbyDataBaseController implements DatabaseController {
    public static final String DERBY_JDBC_EMBEDDED_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DERBY_PROTOCOL = "jdbc:derby:";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE";
    public static final String SQL_DROP_TABLE = "DROP TABLE";
    private String dbName;
    private String dbUrl;
    private Connection connection;


    public DerbyDataBaseController(String dbName) throws SQLException, ClassNotFoundException {
        this.dbName = dbName;
        this.dbUrl = String.format("%s%s;create=true", DERBY_PROTOCOL, dbName);
        this.createDatabase();
        connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void createDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(DERBY_JDBC_EMBEDDED_DRIVER);
        connect();
    }

    @Override
    public void createTable(String tableName, String parameters) throws SQLException {
        connect();
        if (!isTableExists(tableName)) {
            String query = String.format(String.format("%s %s(%s)", SQL_CREATE_TABLE, tableName, parameters));
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            pStatement.execute();
            pStatement.close();
        }
        disconnect();
    }

    @Override
    public void deleteTable(String tableName) throws SQLException {
        connect();
        if (isTableExists(tableName)) {
            String query = String.format("%s %s", SQL_DROP_TABLE, tableName);
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            pStatement.execute();
        }
        disconnect();
    }

    @Override
    public boolean isTableExists(String tableName) throws SQLException {
        boolean isExists = false;
        connect();
        if (connection != null) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, tableName.toUpperCase(), null);
            if (resultSet.next()) {
                isExists = true;
            }
        }
        return isExists;
    }


    @Override
    public boolean connect() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(dbUrl);
        }
        return !connection.isClosed();
    }

    @Override
    public boolean disconnect() throws SQLException {
        if (connection != null)
            connection.close();
        if (connection == null || connection.isClosed())
            return true;
        return false;
    }

}
