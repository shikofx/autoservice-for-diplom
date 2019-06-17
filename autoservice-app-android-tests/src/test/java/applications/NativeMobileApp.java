package applications;

import static io.appium.java_client.remote.MobileCapabilityType.APP;

import setup.TestProperties;

import java.io.File;

public class NativeMobileApp extends MobileApplication {

    private final String NATIVE_APP_PROPERTIES_FILE = "native-app.properties";
    private TestProperties nativeProperties;
    private final String APPLICATION_PATH_PROPERTY;

    public NativeMobileApp(String devicePropertiesFile) {
        super(devicePropertiesFile);
        nativeProperties = new TestProperties(NATIVE_APP_PROPERTIES_FILE);
        APPLICATION_PATH_PROPERTY = nativeProperties.getProperty("applicationPath");
        File app = new File(APPLICATION_PATH_PROPERTY);
        device.withCapabilities(APP, app.getAbsolutePath());
    }
}
