package com.epam.controller;

import com.epam.data.repo.AutoOrderRepository;
import com.epam.domain.AutoOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.SQLException;

public class DerbyDataBaseControllerTest {

    String dbName;
    DerbyDataBaseController databaseController;
    AutoOrderRepository orderRepository;
    AutoOrder testOrder;

    @Before
    public void setUp() throws Exception {
        dbName = "test_base";
        testOrder = new AutoOrder();
        databaseController = new DerbyDataBaseController(dbName);
        orderRepository = new AutoOrderRepository(databaseController);

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
    public void connectionCanBeCreated() throws SQLException {
        Assert.assertTrue(databaseController.connect());

    }

    @Test
    public void connectionCanBeClosed() throws SQLException {
        databaseController.connect();
        Assert.assertTrue(databaseController.disconnect());
    }
}