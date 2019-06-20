package application.web;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

import application.MobileApplication;
import setup.TestProperties;

public class WebMobileApp extends MobileApplication {

    public final String WEB_APP_PROPERTIES_FILE = "web-app.properties";

    private TestProperties webAppProperties;

    private final String APPLICATION_URL_PROPERTY;
    private final String BROWSER_NAME_PROPERTY;

    public WebMobileApp(String devicePropertiesFile) {
        launchDevice(devicePropertiesFile);
        webAppProperties = new TestProperties(WEB_APP_PROPERTIES_FILE);

        APPLICATION_URL_PROPERTY = webAppProperties.getProperty("webAppUrl");
        BROWSER_NAME_PROPERTY = webAppProperties.getProperty("browserName");

        device.launchApp(BROWSER_NAME, BROWSER_NAME_PROPERTY);
    }

    public String getAppUrl() {
        return APPLICATION_URL_PROPERTY;
    }
}
