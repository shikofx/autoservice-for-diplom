package tests.nat;

import static java.util.Optional.ofNullable;

import applications.NativeMobileApp;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class NativeMobileAppTests {

    static AndroidDriver driver;
    static NativeMobileApp appCapabilities;

    @BeforeClass
    public static void init() {
//        appCapabilities = new NativeMobileApp("appium-epam-cloud.properties"); - can't launch install native app
//        appCapabilities = new NativeMobileApp("appium-real.properties");// - for A4.2.2 there is no locators by ID
        appCapabilities = new NativeMobileApp("appium-emulator.properties");
        driver = appCapabilities.getDriver();
    }

    @Test
    public void simplestTest() throws MalformedURLException {
        String appPackageName = "ru.descbook.polyglotfree:id/";
        By addPlayerButton = By.id(appPackageName + "mainMenuButtonAddPlayer");
        driver.findElement(addPlayerButton).click();
    }

    @After
    public void tearDown() {
        driver.closeApp();
    }

    @AfterClass
    public static void deinit() {
        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
    }

}
