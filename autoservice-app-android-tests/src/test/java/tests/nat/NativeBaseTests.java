package tests.nat;

import application.nat.NativeMobileApp;
import org.assertj.core.api.SoftAssertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NativeBaseTests {

    static NativeMobileApp nativeApp = new NativeMobileApp("appium-emulator.properties", "native-app.properties");
//    static NativeMobileApp nativeApp = new NativeMobileApp("appium-epam-cloud.properties", "native-app.properties");
//    static NativeMobileApp nativeApp = new NativeMobileApp("appium-real.properties", "native-app.properties");

    @BeforeClass
    public static void init() {
        //        nativeApp = NativeMobileApp.startApp(");
//        nativeApp = NativeMobileApp.startApp("appium-emulator.properties");             //- I can't ubdate browser on emulator

        nativeApp.startApp();
    }

    @Test
    public void addOrderTest() {
        nativeApp.ordersMenu().toAdd();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.addActivity().headerText()).contains("Add New Order");
        nativeApp.addActivity().fillDate("28.02.2007").fillOwnerName("Test Owner");
        assertions.assertThat(nativeApp.addActivity().isKeyboardShown()).isTrue();
        nativeApp.addActivity().closeKeyboard().submit().back();
        assertions.assertAll();
    }

    @Test
    public void findOrderByIdTest() {
        nativeApp.ordersMenu().toFindOne();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.findOneActivity().getOrders()).contains("Id: 1");
        nativeApp.findOneActivity().back();
        assertions.assertAll();
    }

    @Test
    public void findAllOrdersTest() {
        nativeApp.ordersMenu().toFindAll();
        SoftAssertions assertions = new SoftAssertions();
        String text = nativeApp.findAllActivity().getOrders();
        assertions.assertThat(text).contains("Id: 1");
        nativeApp.findAllActivity().back();
        assertions.assertAll();
    }

    @Test
    public void updateOrderTest() {
        nativeApp.ordersMenu().toUpdate();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.updateOrderActivity().getHeader()).contains("Update Order");
        nativeApp.updateOrderActivity().fillId("1").fillDate("28.02.2007").fillOwnerName("Test Owner");
        assertions.assertThat(nativeApp.updateOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.updateOrderActivity().closeKeyboard().submit().back();
        assertions.assertAll();
    }

    @Test
    public void deleteOrderTest() {
        nativeApp.ordersMenu().toDelete();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(nativeApp.deleteOrderActivity().getHeader()).contains("Delete Order");
        nativeApp.deleteOrderActivity().fillId("1");
        assertions.assertThat(nativeApp.deleteOrderActivity().isKeyboardShown()).isTrue();
        nativeApp.deleteOrderActivity().closeKeyboard().submit().back();
        assertions.assertAll();
    }

    @AfterClass
    public static void deinit() {
        nativeApp.stopApp();
    }
}
