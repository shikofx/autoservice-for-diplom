package tests.nat;

import application.nat.NativeMobileApp;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NativeBaseTests {


    static NativeMobileApp nativeApp = new NativeMobileApp("appium-emulator.properties");

    @BeforeClass
    public static void init() {
        nativeApp.launchApp();
    }

    @Test
    public void addOrderTest() {
        nativeApp.ordersMenuActivity().goToAddOrder();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.addOrderActivity().getHeaderText()).contains("Add New Order");
        nativeApp.addOrderActivity().fillDate("28.02.2007");
        assertions.assertThat(nativeApp.addOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.addOrderActivity().fillOwnerName("Test Owner");
        assertions.assertThat(nativeApp.addOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.addOrderActivity().closeKeyboard();
        nativeApp.addOrderActivity().add().back();
        assertions.assertAll();
    }

    @Test
    public void findOrderByIdTest() {
        nativeApp.ordersMenuActivity().goToFindById();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.findOrderByIdActivity().getHeader()).contains("Id: 1");
        nativeApp.findAllOrdersActivity().back();
        assertions.assertAll();
    }

    @Test
    public void findAllOrdersTest() {
        nativeApp.ordersMenuActivity().goToFindAll();
        SoftAssertions assertions = new SoftAssertions();
        String text = nativeApp.findAllOrdersActivity().getOrders();
        assertions.assertThat(text).contains("Id: 1");
        nativeApp.findAllOrdersActivity().back();
        assertions.assertAll();
    }

    @Test
    public void updateOrderTest() {
        nativeApp.ordersMenuActivity().goToUpdate();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.updateOrderActivity().getHeader()).contains("Update Order");
        nativeApp.updateOrderActivity().fillId("1");
        assertions.assertThat(nativeApp.updateOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.updateOrderActivity().fillDate("28.02.2007");
        assertions.assertThat(nativeApp.updateOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.updateOrderActivity().fillOwnerName("Test Owner");
        assertions.assertThat(nativeApp.updateOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.updateOrderActivity().closeKeyboard();
        nativeApp.updateOrderActivity().update().back();
        nativeApp.updateOrderActivity().back();
        assertions.assertAll();
    }

    @Test
    public void deleteOrderTest() {
        nativeApp.ordersMenuActivity().goToDelete();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.deleteOrderActivity().getHeader()).contains("Delete Order");
        nativeApp.deleteOrderActivity().fillId("1");
        assertions.assertThat(nativeApp.deleteOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.deleteOrderActivity().closeKeyboard();
        nativeApp.deleteOrderActivity().delete().back();
        assertions.assertAll();
    }


    @After
    public void tearDown() {
    }

    @AfterClass
    public static void deinit() {
        nativeApp.closeApp();
    }
}
