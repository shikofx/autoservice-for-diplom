package application.nat;

import static io.appium.java_client.remote.MobileCapabilityType.APP;

import application.MobileApplication;
import application.nat.activities.AddOrderActivity;
import application.nat.activities.DeleteOrderActivity;
import application.nat.activities.FindAllOrdersActivity;
import application.nat.activities.FindOrderByIdActivity;
import application.nat.activities.OrdersMenuActivity;
import application.nat.activities.UpdateOrderActivity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestProperties;

import java.io.File;

public class NativeMobileApp extends MobileApplication {

    AndroidDriver androidDriver;
    NativeMobileApp appCapabilities;
    WebDriverWait wait;
    AddOrderActivity addOrderActivity;
    DeleteOrderActivity deleteOrderActivity;
    FindAllOrdersActivity findAllOrdersActivity;
    FindOrderByIdActivity findOrderByIdActivity;
    OrdersMenuActivity ordersMenuActivity;
    UpdateOrderActivity updateOrderActivity;

    private final String NATIVE_APP_PROPERTIES_FILE = "native-app.properties";
    private TestProperties nativeProperties;
    private final String APPLICATION_PATH_PROPERTY;

    public NativeMobileApp(String devicePropertiFile) {
        launchDevice(devicePropertiFile);
        nativeProperties = new TestProperties(NATIVE_APP_PROPERTIES_FILE);
        APPLICATION_PATH_PROPERTY = nativeProperties.getProperty("applicationPath");
        File app = new File(APPLICATION_PATH_PROPERTY);
        device.launchApp(APP, app.getAbsolutePath());
    }


}
