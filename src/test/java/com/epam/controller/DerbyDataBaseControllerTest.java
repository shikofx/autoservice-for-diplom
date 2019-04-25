package com.epam.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.SQLException;

public class DerbyDataBaseControllerTest {

    String dbName;
    DerbyDataBaseController databaseController;
    String tableName;
    String parameters;

    @Before
    public void setUp() throws Exception {
        dbName = "test_base";
        tableName = "test_table";
        parameters = "ID INT";

        databaseController = new DerbyDataBaseController(dbName);
    }

    @After
    public void tearDown() throws Exception {
        databaseController.disconnect();
    }

    @Test
    public void databaseCanBeCreated() {
        File databaseFolder = new File(dbName);
        Assert.assertTrue(databaseFolder.exists());
    }

    @Test
    public void tableCanBeCreated() throws SQLException {
        databaseController.createTable(tableName, parameters);
        Assert.assertTrue(databaseController.isTableExists(tableName));
        databaseController.deleteTable(tableName);
    }

    @Test
    public void tableCanBeDeleted() throws SQLException {
        databaseController.createTable(tableName, parameters);
        databaseController.deleteTable(tableName);
        Assert.assertFalse(databaseController.isTableExists(tableName));
    }

    @Test
    public void connectionCanBeCreated() throws SQLException {
        Assert.assertTrue(databaseController.connect());

    }

    @Test
    public void connectionCanBeClosed() throws SQLException {
        databaseController.connect();
        Assert.assertTrue(databaseController.disconnect());
    }
}