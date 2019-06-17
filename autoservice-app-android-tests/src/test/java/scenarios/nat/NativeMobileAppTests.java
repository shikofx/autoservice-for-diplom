package scenarios.nat;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import setup.NativeMobileApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class NativeMobileAppTests {

    static AndroidDriver driver;
    static NativeMobileApp appCapabilities;

    @BeforeClass
    public static void init() {
        appCapabilities = new NativeMobileApp();
        driver = appCapabilities.getDriver();
        driver.manage().timeouts()
            .pageLoadTimeout(5, TimeUnit.MINUTES)
            .implicitlyWait(90, TimeUnit.SECONDS);
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
//        driver.quit();
    }

}
