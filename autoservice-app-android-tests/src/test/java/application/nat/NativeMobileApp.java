package application.nat;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static java.util.Optional.ofNullable;

import application.MobileApplication;
import application.nat.activities.AddOrderActivity;
import application.nat.activities.DeleteOrderActivity;
import application.nat.activities.FindAllOrdersActivity;
import application.nat.activities.FindOrderByIdActivity;
import application.nat.activities.OrdersMenuActivity;
import application.nat.activities.UpdateOrderActivity;
import device.IDevice;
import device.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestProperties;

import java.io.File;

public class NativeMobileApp extends MobileApplication implements IDevice {

    private AndroidDriver driver;
    private WebDriverWait wait;
    private AddOrderActivity addOrderActivity;
    private DeleteOrderActivity deleteOrderActivity;
    private FindAllOrdersActivity findAllOrdersActivity;
    private FindOrderByIdActivity findOrderByIdActivity;
    private OrdersMenuActivity ordersMenuActivity;
    private UpdateOrderActivity updateOrderActivity;

    private TestProperties nativeProperties;
    private String APPLICATION_PATH;

    public NativeMobileApp(String devicePropertyFile, String appPropertyFile) {
        MobileDevice.launch(devicePropertyFile);
        nativeProperties = new TestProperties(appPropertyFile);
        APPLICATION_PATH = nativeProperties.getProperty("applicationPath");
    }

    public NativeMobileApp startApp() {
        File app = new File(APPLICATION_PATH);
        MobileDevice.launchApp(APP, app.getAbsolutePath());
        driver = getAppDriver();
        wait = new WebDriverWait(driver, 10);
        addOrderActivity = new AddOrderActivity(driver, wait);
        deleteOrderActivity = new DeleteOrderActivity(driver, wait);
        findAllOrdersActivity = new FindAllOrdersActivity(driver, wait);
        findOrderByIdActivity = new FindOrderByIdActivity(driver, wait);
        updateOrderActivity = new UpdateOrderActivity(driver, wait);
        ordersMenuActivity = new OrdersMenuActivity(driver, wait);
        return this;
    }

    public NativeMobileApp stopApp() {
        driver.closeApp();
        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
        return this;
    }

    public AddOrderActivity addActivity() {
        return addOrderActivity;
    }

    public DeleteOrderActivity deleteOrderActivity() {
        return deleteOrderActivity;
    }

    public FindAllOrdersActivity findAllActivity() {
        return findAllOrdersActivity;
    }

    public FindOrderByIdActivity findOneActivity() {
        return findOrderByIdActivity;
    }

    public OrdersMenuActivity ordersMenu() {
        return ordersMenuActivity;
    }

    public UpdateOrderActivity updateOrderActivity() {
        return updateOrderActivity;
    }
}
