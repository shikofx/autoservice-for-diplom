package tests.nat;

import static java.util.Optional.ofNullable;

import application.nat.NativeMobileApp;
import io.appium.java_client.android.AndroidDriver;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NativeBaseTests {


    static AndroidDriver androidDriver;
    static NativeMobileApp appCapabilities;
    static WebDriverWait wait;
    String appPackageName = "com.epam.autoserviceappapi";

    @BeforeClass
    public static void init() {
        appCapabilities = new NativeMobileApp("appium-emulator.properties");
        androidDriver = appCapabilities.getDriver();
        wait = new WebDriverWait(androidDriver, 5);
    }

    @Test
    public void addOrderTest() {
        WebElement addOrderButton = androidDriver.findElement(By.id(appPackageName + ":id/bn_add_order"));
        addOrderButton.click();
        SoftAssertions assertions = new SoftAssertions();
        wait.until(d -> d.findElement(By.id(appPackageName + ":id/textView")));
        WebElement addHeaderElement = androidDriver.findElement(By.id(appPackageName + ":id/textView"));
        assertions.assertThat(addHeaderElement.getText()).contains("Add New Order");
        WebElement orderDateFieldElement = androidDriver.findElement(By.id(appPackageName + ":id/txt_order_date"));
        orderDateFieldElement.click();
        assertions.assertThat(androidDriver.isKeyboardShown()).isTrue();
        orderDateFieldElement.sendKeys("28.02.2007");
        WebElement orderOwnerNameElement = androidDriver.findElement(By.id(appPackageName + ":id/txt_owner_name"));
        orderOwnerNameElement.click();
        assertions.assertThat(androidDriver.isKeyboardShown()).isTrue();
        orderOwnerNameElement.sendKeys("Test Owner");
        WebElement orderSaveButtonElement = androidDriver.findElement(By.id(appPackageName + ":id/bn_save"));
        orderSaveButtonElement.click();
        androidDriver.navigate().back();
        androidDriver.navigate().back();
        assertions.assertAll();
    }

    @Test
    public void findOrderByIdTest() {
        WebElement addOrderButton = androidDriver.findElement(By.id(appPackageName + ":id/bn_view_order"));
        addOrderButton.click();
        SoftAssertions assertions = new SoftAssertions();
        wait.until(d -> d.findElement(By.id(appPackageName + ":id/txt_display_info")));
        WebElement foundElement = androidDriver.findElement(By.id(appPackageName + ":id/txt_display_info"));
        assertions.assertThat(foundElement.getText()).contains("Id: 1");
        androidDriver.navigate().back();
        assertions.assertAll();
    }

    @Test
    public void findAllOrdersTest() {
        WebElement addOrderButton = androidDriver.findElement(By.id(appPackageName + ":id/bn_view_orders"));
        addOrderButton.click();
        SoftAssertions assertions = new SoftAssertions();
        wait.until(d -> d.findElement(By.id(appPackageName + ":id/txt_display_info")));
        WebElement foundsElement = androidDriver.findElement(By.id(appPackageName + ":id/txt_display_info"));
        assertions.assertThat(foundsElement.getText()).contains("Id: 1");
        androidDriver.navigate().back();
        assertions.assertAll();
    }

    @Test
    public void updateOrderTest() {
        WebElement updateOrderButton = androidDriver.findElement(By.id(appPackageName + ":id/bn_update_order"));
        updateOrderButton.click();
        SoftAssertions assertions = new SoftAssertions();
        wait.until(d -> d.findElement(By.id(appPackageName + ":id/textView_update")));
        WebElement addHeaderElement = androidDriver.findElement(By.id(appPackageName + ":id/textView_update"));
        assertions.assertThat(addHeaderElement.getText()).contains("Update Order");
        WebElement orderIdFieldElement = androidDriver.findElement(By.id(appPackageName + ":id/txt_update_order_id"));
        orderIdFieldElement.click();
        assertions.assertThat(androidDriver.isKeyboardShown()).isTrue();
        orderIdFieldElement.sendKeys("1");
        WebElement
            orderDateFieldElement =
            androidDriver.findElement(By.id(appPackageName + ":id/txt_update_order_date"));
        orderDateFieldElement.click();
        assertions.assertThat(androidDriver.isKeyboardShown()).isTrue();
        orderDateFieldElement.sendKeys("28.02.2007");
        WebElement
            orderOwnerNameElement =
            androidDriver.findElement(By.id(appPackageName + ":id/txt_update_owner_name"));
        orderOwnerNameElement.click();
        assertions.assertThat(androidDriver.isKeyboardShown()).isTrue();
        orderOwnerNameElement.sendKeys("Test Owner");
        WebElement orderSaveButtonElement = androidDriver.findElement(By.id(appPackageName + ":id/bn_update_save"));
        orderSaveButtonElement.click();
        androidDriver.navigate().back();
        androidDriver.navigate().back();
        assertions.assertAll();
    }

    @Test
    public void deleteOrderTest() {
        WebElement deleteOrderButton = androidDriver.findElement(By.id(appPackageName + ":id/bn_delete_order"));
        deleteOrderButton.click();
        SoftAssertions assertions = new SoftAssertions();
        wait.until(d -> d.findElement(By.id(appPackageName + ":id/textView_delete")));
        WebElement addHeaderElement = androidDriver.findElement(By.id(appPackageName + ":id/textView_delete"));
        assertions.assertThat(addHeaderElement.getText()).contains("Delete Order");
        WebElement orderIdFieldElement = androidDriver.findElement(By.id(appPackageName + ":id/txt_delete_order_id"));
        orderIdFieldElement.click();
        assertions.assertThat(androidDriver.isKeyboardShown()).isTrue();
        orderIdFieldElement.sendKeys("1");
        WebElement orderSaveButtonElement = androidDriver.findElement(By.id(appPackageName + ":id/delete_order_bn"));
        orderSaveButtonElement.click();
        androidDriver.navigate().back();
        androidDriver.navigate().back();
        assertions.assertAll();
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void deinit() {
        androidDriver.closeApp();
        ofNullable(androidDriver).ifPresent(RemoteWebDriver::quit);
    }


}
