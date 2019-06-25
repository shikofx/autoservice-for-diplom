package device;

import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import org.openqa.selenium.remote.DesiredCapabilities;
import setup.TestProperties;

public final class MobileDevice {

    private static final String DEVICE_PROPERTY_FILE = "device.properties";
    private static MobileDevice deviceInstance;

    protected static DesiredCapabilities CAPABILITIES;
    private final String PLATFORM_VERSION_PROPERTY;
    private final String PLATFORM_NAME_PROPERTY;
    private static String APPIUM_SERVER_PROPERTY;
    private final String DEVICE_NAME_PROPERTY;
    private final String DEVICE_UDID_PROPERTY;

    private MobileDevice(String devicePropertiesFile) {
        TestProperties appiumProperties = new TestProperties(devicePropertiesFile);
        PLATFORM_VERSION_PROPERTY =
            System.getProperty("platformVersion");//appiumProperties.getProperty("platformVersion");
        PLATFORM_NAME_PROPERTY = System.getProperty("platformName");//appiumProperties.getProperty("platformName");
        APPIUM_SERVER_PROPERTY = System.getProperty("appiumUrl");//appiumProperties.getProperty("appiumServer");
        DEVICE_NAME_PROPERTY = System.getProperty("deviceName");//appiumProperties.getProperty("deviceName");
        DEVICE_UDID_PROPERTY = System.getProperty("deviceUdid");//appiumProperties.getProperty("deviceUdid");
        CAPABILITIES = new DesiredCapabilities();
        CAPABILITIES.setCapability(DEVICE_NAME, DEVICE_NAME_PROPERTY);
        CAPABILITIES.setCapability(UDID, DEVICE_UDID_PROPERTY);
        CAPABILITIES.setCapability(PLATFORM_NAME, PLATFORM_NAME_PROPERTY);
        CAPABILITIES.setCapability(PLATFORM_VERSION, PLATFORM_VERSION_PROPERTY);
    }

    public static MobileDevice launch() {
        if (deviceInstance == null) {
            deviceInstance = new MobileDevice(DEVICE_PROPERTY_FILE);
        }
        return deviceInstance;
    }

    public static void launchApp(String appType, String appProperty) {
        CAPABILITIES.setCapability(appType, appProperty);
    }

    public static String getAppiumServer() {
        return APPIUM_SERVER_PROPERTY;
    }

    public static DesiredCapabilities getCapabilities() {
        return CAPABILITIES;
    }


}
