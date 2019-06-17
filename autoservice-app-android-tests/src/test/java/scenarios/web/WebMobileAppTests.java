package scenarios.web;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import setup.WebMobileApp;

public class WebMobileAppTests {

    static AndroidDriver driver;
    static WebMobileApp appCapabilities;

    @BeforeClass
    public static void init() {
        appCapabilities = new WebMobileApp();
        driver = appCapabilities.getDriver();
    }

    @Test
    public void simplestWebTest() {
        driver.get(appCapabilities.getAppUrl());
    }

    @After
    public void tearDown() {
        driver.closeApp();
    }

    @AfterClass
    public static void deinit() {
        driver.quit();
    }

}
