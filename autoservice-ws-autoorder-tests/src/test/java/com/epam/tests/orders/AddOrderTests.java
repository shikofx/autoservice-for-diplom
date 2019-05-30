package com.epam.tests.orders;

import static com.epam.categories.TestCategories.BrokenTests;
import static com.epam.controller.AutoOrderController.AUTO_ORDER_CONTROLLER;
import static org.apache.http.HttpStatus.SC_CREATED;

import com.epam.categories.TestCategories.NegativeTests;
import com.epam.categories.TestCategories.PositiveTests;
import com.epam.endpoints.AutoOrder;
import com.epam.tests.TestBase;
import com.jayway.restassured.response.Response;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.awt.*;
import java.io.IOException;

@RunWith(DataProviderRunner.class)
public class AddOrderTests extends TestBase {

    private Logger log = LogManager.getLogger(AddOrderTests.class);
    private AutoOrder orderToServer;

    @Before
    public void setUp() throws IOException, AWTException {
        log.info("-->> setUp for " + AddOrderTests.class.getSimpleName());
        orderToServer = new AutoOrder()
            .withOrderDate("22.12.2018")
            .withOwnerName("Test Owner");
    }

    @After
    public void tearDown() {
        log.info("<<-- tearDown for " + AddOrderTests.class.getSimpleName());
    }

    @Test
    @Category(PositiveTests.class)
    public void addNewSucceed() throws IOException, AWTException {
        log.info(">>> @Test addNewSucceed ");
        log.info(">>> >> add data to server: " + orderToServer.asString());
        Response addResponse = AUTO_ORDER_CONTROLLER.add(orderToServer);
        AutoOrder addedOrder = addResponse.as(AutoOrder.class);
        log.info(">>> >> get data from server");
        AutoOrder orderFromServer =
            AUTO_ORDER_CONTROLLER.findById(addedOrder.getOrderId()).as(AutoOrder.class);
        log.info(orderFromServer.asString());
        log.info(">>> >> assertions");
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(addResponse.statusCode()).isEqualTo(SC_CREATED);
        assertions.assertThat(addedOrder.getOrderDate()).isEqualTo(orderFromServer.getOrderDate());
        assertions.assertThat(addedOrder.getOwnerName()).isEqualTo(orderFromServer.getOwnerName());
        assertions.assertAll();
        log.info("<<< @Test addNewSucceed");
    }

    @Test
    @Category({NegativeTests.class, BrokenTests.class})
//    @UseDataProvider(value = "ordersWithEmptyFields", location = SimpleDataProvider.class)
    public void addEmptyFieldsFailed(/*String date, String owner*/) {
        orderToServer
            .withOrderDate("date")
            .withOwnerName("owner");
        log.info(">>> @Test addEmptyFieldsFailed with " + orderToServer.asString());
        log.info(">>> >> add data to server: " + orderToServer.asString());
        Response addResponse = AUTO_ORDER_CONTROLLER.add(orderToServer);
        log.info(">>> >> assertions");
//        assertThat(addResponse.statusCode(), is(SC_INTERNAL_SERVER_ERROR));
        log.info("<<< @Test addEmptyFieldsFailed");
    }

    @Test
    @Category({NegativeTests.class, BrokenTests.class})
//    @UseDataProvider(value = "ordersWithNullFields", location = SimpleDataProvider.class)
    public void addNullFieldsFailed(/*String date, String owner*/) {
        orderToServer
            .withOrderDate("date")
            .withOwnerName("owner");
        log.info(">>> @Test addNullFieldsFailed with " + orderToServer.asString());
        log.info(">>> >> add data to server: " + orderToServer.asString());
        Response addResponse = AUTO_ORDER_CONTROLLER.add(orderToServer);
        log.info(">>> >> assertions");
//        assertThat(addResponse.statusCode(), is(SC_INTERNAL_SERVER_ERROR));
        log.info("<<< @Test addNullFieldsFailed");
    }
}
