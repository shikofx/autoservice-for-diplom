package device;

import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestProperties;

public class MobileDevice {

    private TestProperties appiumProperties;

    protected DesiredCapabilities capabilities;
    private WebDriverWait wait;
    private final String PLATFORM_VERSION_PROPERTY;
    private final String PLATFORM_NAME_PROPERTY;
    final String APPIUM_SERVER_PROPERTY;
    private final String DEVICE_NAME_PROPERTY;
    private final String DEVICE_UDID_PROPERTY;

    public MobileDevice(String devicePropertiesFile) {
        appiumProperties = new TestProperties(devicePropertiesFile);
        PLATFORM_VERSION_PROPERTY = appiumProperties.getProperty("platformVersion");
        PLATFORM_NAME_PROPERTY = appiumProperties.getProperty("platformName");
        APPIUM_SERVER_PROPERTY = appiumProperties.getProperty("appiumServer");
        DEVICE_NAME_PROPERTY = appiumProperties.getProperty("deviceName");
        DEVICE_UDID_PROPERTY = appiumProperties.getProperty("deviceUdid");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME, DEVICE_NAME_PROPERTY);
        capabilities.setCapability(UDID, DEVICE_UDID_PROPERTY);
        capabilities.setCapability(PLATFORM_NAME, PLATFORM_NAME_PROPERTY);
        capabilities.setCapability(PLATFORM_VERSION, PLATFORM_VERSION_PROPERTY);
    }

    public MobileDevice launchApp(String appType, String appProperty) {
        this.capabilities.setCapability(appType, appProperty);
        return this;
    }

    public String getAppiumServer() {
        return APPIUM_SERVER_PROPERTY;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }
}
