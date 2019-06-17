package setup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeMobileApp extends MobileApp {

    public static final String NATIVE_APP_PROPERTIES_FILE = "native-app.properties";
    private TestProperties properties;

    private final String APPLICATION_PATH_PROPERTY;

    public NativeMobileApp() {
        super();
        properties = new TestProperties(NATIVE_APP_PROPERTIES_FILE);
        APPLICATION_PATH_PROPERTY = properties.getProperties("applicationPath");
        File app = new File(APPLICATION_PATH_PROPERTY);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    }

    @Override
    public AndroidDriver<MobileElement> getDriver() {
        try {
            return new AndroidDriver<>(new URL(APPIUM_SERVER_PROPERTY), capabilities);
        } catch (MalformedURLException e) {
            return null;
        }
    }


}
