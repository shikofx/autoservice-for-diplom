package com.epam.tests;

import com.codeborne.selenide.junit.ScreenShooter;
import com.epam.pages.MainPage;
import com.epam.utils.PropertyProvider;
import org.junit.Rule;
import org.junit.Test;

public class UITests extends BaseTest {

    private MainPage mainPage = new MainPage();

    @Rule
    public ScreenShooter photographer = ScreenShooter.failedTests().succeededTests();

    @Test
    public void listOfOrdersNotEmptyTest(){
        setUp();
        mainPage.checkResultsSizeIsAtLeast(1);
        LOG.info("Starting tests");
    }

    @Test
    public void searchByOrderIdTest(){
        setUp();
        mainPage.searchOrderById("1");
        mainPage.checkedOrderId();
    }

    @Test
    public void addNewOrderTest(){
        setUp();
        String ownerName = PropertyProvider.getProperty("owner_name");
        mainPage.addNewOrder(ownerName);
        mainPage.clickSave();
        mainPage.checkedNewOrder(ownerName);
    }

    @Test
    public void cancelAddNewOrder(){
        setUp();
        String ownerName = PropertyProvider.getProperty("owner_name");
        mainPage.addNewOrder(ownerName);
        mainPage.clickCancel();
        mainPage.checkedShouldNotHaveNewOrders(ownerName);
    }

    @Test
    public void deleteOrderTest(){
        setUp();
        String ownerName = PropertyProvider.getProperty("owner_name");
        mainPage.addNewOrder(ownerName);
        mainPage.clickSave();
        mainPage.searchByName(ownerName);
        mainPage.clickDelete();
        mainPage.checkedShouldNotHaveNewOrders(ownerName);
    }

    @Test
    public void updateOrderTest(){
        setUp();
        String ownerName = PropertyProvider.getProperty("owner_name");
        String changedOwnerName = PropertyProvider.getProperty("changed_owner_name");
        mainPage.addNewOrder(ownerName);
        mainPage.clickSave();
        mainPage.searchByName(ownerName);
        mainPage.updateOrder(changedOwnerName);
        mainPage.clickSave();
        mainPage.checkedUpdatedOrder(changedOwnerName);
    }
}
