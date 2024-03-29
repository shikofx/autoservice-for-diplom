package application.web;

import static java.util.Optional.ofNullable;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

import application.IMobileApp;
import application.MobileApplication;
import application.web.pages.NavigationHelper;
import device.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestProperties;

import java.util.concurrent.TimeUnit;

public class WebMobileApp extends MobileApplication implements IMobileApp {

    private static final String APP_PROPERTIES_FILE = "web-app.properties";
    private AndroidDriver driver;
    private WebDriverWait wait;
    private TestProperties webAppProperties;
    public static String ORDER_URL_PROPERTY;
    private final String BROWSER_NAME_PROPERTY;
    private NavigationHelper navigator;

    public WebMobileApp() {
        MobileDevice.launch();
        webAppProperties = new TestProperties(APP_PROPERTIES_FILE);
        ORDER_URL_PROPERTY = webAppProperties.getProperty("webAppUrl");
        BROWSER_NAME_PROPERTY = webAppProperties.getProperty("browserName");
    }

    public WebMobileApp startApp() {
        MobileDevice.launchApp(BROWSER_NAME, BROWSER_NAME_PROPERTY);
        driver = getAppDriver();
        driver.manage().timeouts()
            .pageLoadTimeout(5, TimeUnit.MINUTES)
            .implicitlyWait(90, TimeUnit.SECONDS);
        navigator = new NavigationHelper(driver, wait);
        return this;
    }

    public WebMobileApp stopApp() {
        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
        return this;
    }

    public NavigationHelper navigate() {
        return navigator;
    }
}
