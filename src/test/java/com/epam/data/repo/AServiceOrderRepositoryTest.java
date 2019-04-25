package com.epam.data.repo;

import com.epam.console.ConsoleDataFormat;
import com.epam.controller.DatabaseController;
import com.epam.controller.DerbyDataBaseController;
import com.epam.domain.ServiceOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AServiceOrderRepositoryTest {
    String dbName;
    ServiceOrder serviceOrder;
    AServiceOrderRepository orderRepository;
    DatabaseController databaseController;

    @Before
    public void setUp() throws Exception {
        serviceOrder = new ServiceOrder();
        dbName = "test_base";
        databaseController = new DerbyDataBaseController(dbName);
        orderRepository = new AServiceOrderRepository(databaseController);
        serviceOrder = new ServiceOrder();
        serviceOrder.setId(1);
        serviceOrder.setDate(new ConsoleDataFormat().toDate("22-10-2018"));
        serviceOrder.setOwnerName("Alex");
    }

    @After
    public void tearDown() throws Exception {
        orderRepository.delete(serviceOrder);
    }

    @Test
    public void orderCanBeAdded() {
        orderRepository.add(serviceOrder);
        ServiceOrder serviceOrderFromDB = orderRepository.find(serviceOrder);
        assertThat(serviceOrderFromDB, is(serviceOrder));
    }

    @Test
    public void orderCanBeFound() {
    }

    @Test
    public void orderCanBeDeleted() {
    }
}