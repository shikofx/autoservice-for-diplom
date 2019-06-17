package setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

public class WebMobileApp extends MobileApp {

    public static final String WEB_APP_PROPERTIES_FILE = "web-app.properties";
    private TestProperties webAppProperties;
    private final String APPLICATION_URL_PROPERTY;
    private final String BROWSER_NAME_PROPERTY;

    public WebMobileApp() {
        super();
        webAppProperties = new TestProperties(WEB_APP_PROPERTIES_FILE);

        APPLICATION_URL_PROPERTY = webAppProperties.getProperties("applicationUrl");
        BROWSER_NAME_PROPERTY = webAppProperties.getProperties("browserName");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME_PROPERTY);

    }

    @Override
    public AndroidDriver getDriver() {
        try {
            return new AndroidDriver(new URL(APPIUM_SERVER_PROPERTY), capabilities);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public String getAppUrl() {
        return APPLICATION_URL_PROPERTY;
    }
}
