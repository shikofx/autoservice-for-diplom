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
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestProperties;

import java.io.File;

public class NativeMobileApp extends MobileApplication {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;
    private AddOrderActivity addOrderActivity;
    private DeleteOrderActivity deleteOrderActivity;
    private FindAllOrdersActivity findAllOrdersActivity;
    private FindOrderByIdActivity findOrderByIdActivity;
    private OrdersMenuActivity ordersMenuActivity;
    private UpdateOrderActivity updateOrderActivity;

    private final String NATIVE_APP_PROPERTIES_FILE = "native-app.properties";
    private TestProperties nativeProperties;
    private final String APPLICATION_PATH_PROPERTY;

    public NativeMobileApp(String devicePropertiFile) {
        super(devicePropertiFile);
        nativeProperties = new TestProperties(NATIVE_APP_PROPERTIES_FILE);
        APPLICATION_PATH_PROPERTY = nativeProperties.getProperty("applicationPath");
    }

    public NativeMobileApp launchApp() {
        File app = new File(APPLICATION_PATH_PROPERTY);
        device().launchApp(APP, app.getAbsolutePath());
        androidDriver = getDriver();
        wait = new WebDriverWait(androidDriver, 10);
        addOrderActivity = new AddOrderActivity(androidDriver, wait);
        deleteOrderActivity = new DeleteOrderActivity(androidDriver, wait);
        findAllOrdersActivity = new FindAllOrdersActivity(androidDriver, wait);
        findOrderByIdActivity = new FindOrderByIdActivity(androidDriver, wait);
        updateOrderActivity = new UpdateOrderActivity(androidDriver, wait);
        ordersMenuActivity = new OrdersMenuActivity(androidDriver, wait);
        return this;
    }

    public NativeMobileApp closeApp() {
        androidDriver.closeApp();
        ofNullable(androidDriver).ifPresent(RemoteWebDriver::quit);
        return this;
    }

    public AddOrderActivity addOrderActivity() {
        return addOrderActivity;
    }

    public DeleteOrderActivity deleteOrderActivity() {
        return deleteOrderActivity;
    }

    public FindAllOrdersActivity findAllOrdersActivity() {
        return findAllOrdersActivity;
    }

    public FindOrderByIdActivity findOrderByIdActivity() {
        return findOrderByIdActivity;
    }

    public OrdersMenuActivity ordersMenuActivity() {
        return ordersMenuActivity;
    }

    public UpdateOrderActivity updateOrderActivity() {
        return updateOrderActivity;
    }
}
