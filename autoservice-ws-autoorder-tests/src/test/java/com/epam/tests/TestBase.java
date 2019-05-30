package com.epam.tests;

import static com.epam.controller.AutoOrderController.AUTO_ORDER_CONTROLLER;

import com.epam.endpoints.AutoOrder;
import com.epam.utils.ReportPortalManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.params.provider.Arguments;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestBase extends ReportPortalManager {

    private static Logger log = LogManager.getLogger(TestBase.class);

    public static Stream<Arguments> dataWithEmptyFields() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("", "Test Owner"),
            Arguments.of("22-12-2019", ""));
    }

    public static Stream<Arguments> dataWithNullFields() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("", "Test Owner"),
            Arguments.of("22-12-2019", ""));
    }

    public static Stream<Arguments> dataForModify() {
        return Stream.of(
            Arguments.of("22-12-2019", "Test Albert"),
            Arguments.of("22-12-2019", "Test Peter"),
            Arguments.of("22-12-2019", "Test +-*/!@#$%^^&*()"),
            Arguments.of("22-12-2019", "Test 1aA0654679"));
    }

    @BeforeClass
    public static void init() throws IOException, AWTException {
        log.debug("--> init new instance");
//        screenShotToReportPortal(log, ">>> >>>screenshot");
    }

    @AfterClass
    public static void deinit() {
        log.debug("<-- deinit instance");
        log.debug("delete all test data from database");
        List<AutoOrder> orders = Arrays.asList(AUTO_ORDER_CONTROLLER.findAll().as(AutoOrder[].class))
            .stream().filter(autoOrder ->
                                 autoOrder.getOwnerName() == null ||
                                 autoOrder.getOrderDate() == null ||
                                 autoOrder.getOwnerName().contains("Test") ||
                                 autoOrder.getOwnerName().contains("test") ||
                                 "Owner".equals(autoOrder.getOwnerName()) ||
                                 "owner".equals(autoOrder.getOwnerName()) ||
                                 "".equals(autoOrder.getOwnerName())
            ).collect(Collectors.toList());
        orders.forEach(order -> AUTO_ORDER_CONTROLLER.delete(order));
    }
}
