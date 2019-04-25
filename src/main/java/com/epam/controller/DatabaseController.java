package com.epam.controller;

import java.sql.SQLException;

public interface DatabaseController {

    void createDatabase() throws ClassNotFoundException, SQLException;

    void createTable(String tableName, String parameters) throws SQLException;

    boolean isTableExists(String tableName) throws SQLException;

    void deleteTable(String tableName) throws SQLException;

    boolean connect() throws SQLException;

    boolean disconnect() throws SQLException;
}
