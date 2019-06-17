package setup;

import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MobileApp {

    public static final String APPIUM_SERVER_PROPERTIES_FILE = "appium-epam-cloud.properties";

    TestProperties appiumProperties;

    protected DesiredCapabilities capabilities;
    private WebDriverWait wait;
    private final String PLATFORM_VERSION_PROPERTY;
    public final String PLATFORM_NAME_PROPERTY;
    public final String APPIUM_SERVER_PROPERTY;
    public final String DEVICE_NAME_PROPERTY;

    public MobileApp() {
        appiumProperties = new TestProperties(APPIUM_SERVER_PROPERTIES_FILE);
        PLATFORM_VERSION_PROPERTY = appiumProperties.getProperties("platformVersion");
        PLATFORM_NAME_PROPERTY = appiumProperties.getProperties("platformName");
        APPIUM_SERVER_PROPERTY = appiumProperties.getProperties("appiumServer");
        DEVICE_NAME_PROPERTY = appiumProperties.getProperties("deviceName");

        capabilities = capabilities = new DesiredCapabilities();
        //        capabilities.setCapability("device", "Android");
        capabilities.setCapability(PLATFORM_VERSION, PLATFORM_VERSION_PROPERTY);
        capabilities.setCapability(PLATFORM_NAME, PLATFORM_NAME_PROPERTY);
        capabilities.setCapability(DEVICE_NAME, DEVICE_NAME_PROPERTY);


    }

    public abstract AndroidDriver getDriver();
}
