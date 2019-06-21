package tests.web;

import application.web.WebMobileApp;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebMobileAppTests {

    static AndroidDriver driver;

    static WebMobileApp webMobileApp = new WebMobileApp("appium-real.properties", "web-app.properties");
    //    static NativeMobileApp nativeApp = new NativeMobileApp("appium-epam-cloud.properties", "native-app.properties");
//    static NativeMobileApp nativeApp = new NativeMobileApp("appium-real.properties", "native-app.properties");


    @BeforeClass
    public static void init() {
        //        webMobileApp = WebMobileApp.startApp("appium-epam-cloud.properties");
//        webMobileApp = WebMobileApp.startApp("appium-emulator.properties");             //- I can't ubdate browser on emulator
        webMobileApp.startApp();
        webMobileApp.navigate().toOrderPage();
    }

    @Test
    public void simplestWebTest() {

    }

    @AfterClass
    public static void deinit() {
        webMobileApp.stopApp();
    }

}
