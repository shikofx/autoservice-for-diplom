//package tests.web;
//
//import static java.util.Optional.ofNullable;
//
//import application.web.WebMobileApp;
//import io.appium.java_client.android.AndroidDriver;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class WebMobileAppTests {
//
//    static AndroidDriver driver;
//    static WebMobileApp appCapabilities;
//
//    @BeforeClass
//    public static void init() {
//        appCapabilities = new WebMobileApp("appium-real.properties");
//        //        appCapabilities = new NativeMobileApp("appium-epam-cloud.properties");
////        appCapabilities = new WebMobileApp("appium-emulator.properties");             //- I can't ubdate browser on emulator
//        driver = appCapabilities.getDriver();
//        driver.manage().timeouts()
//            .pageLoadTimeout(5, TimeUnit.MINUTES)
//            .implicitlyWait(90, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void simplestWebTest() {
//        driver.get(appCapabilities.getAppUrl());
//    }
//
//    @After
//    public void tearDown() {
//        driver.closeApp();
//    }
//
//    @AfterClass
//    public static void deinit() {
//        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
//    }
//
//}
