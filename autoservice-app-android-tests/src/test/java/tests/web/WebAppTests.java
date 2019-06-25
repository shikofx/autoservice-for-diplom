package tests.web;

import application.web.WebMobileApp;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebAppTests {

    static WebMobileApp webMobileApp = new WebMobileApp();

    @BeforeClass
    public static void init() {
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
