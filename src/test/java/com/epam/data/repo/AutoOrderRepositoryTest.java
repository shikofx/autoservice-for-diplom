package com.epam.data.repo;

import com.epam.console.ConsoleDataFormat;
import com.epam.controller.DerbyDataBaseController;
import com.epam.domain.AutoOrder;
import com.epam.service.DatabaseController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AutoOrderRepositoryTest {
    String dbName;
    AutoOrder autoOrder;
    AutoOrderRepository orderRepository;
    DatabaseController databaseController;
    List<AutoOrder> ordersList;

    @Before
    public void setUp() throws Exception {

        autoOrder = new AutoOrder();
        dbName = "test_base";
        databaseController = new DerbyDataBaseController(dbName);
        orderRepository = new AutoOrderRepository(databaseController);
        autoOrder = new AutoOrder();
        autoOrder.setId(1);
        autoOrder.setDate(new ConsoleDataFormat().dateStringToDate("22-10-2018"));
        autoOrder.setOwnerName("Alex");
        ordersList = new ArrayList<>();
        ordersList.add(autoOrder);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void tableCanBeCreated() throws SQLException {
        orderRepository.createTable(autoOrder);
        Assert.assertTrue(orderRepository.isTableExists(autoOrder));
        orderRepository.deleteTable(autoOrder);
    }

    @Test
    public void tableCanBeDeleted() throws SQLException {
        orderRepository.createTable(autoOrder);
        orderRepository.deleteTable(autoOrder);
        Assert.assertFalse(orderRepository.isTableExists(autoOrder));
    }

    @Test
    public void orderCanBeAdded() throws SQLException, IllegalAccessException {
        orderRepository.createTable(autoOrder);
        orderRepository.add(autoOrder);
        List<AutoOrder> orders = orderRepository.findAll();
        assertThat(autoOrder, is(orders.get(0)));
    }

    @Test
    public void allOrdersCanBeFound() throws SQLException {
        orderRepository.createTable(autoOrder);
        List<AutoOrder> ordersFromDB = orderRepository.findAll();
        assertThat(autoOrder, is(ordersList.get(0)));
    }
}