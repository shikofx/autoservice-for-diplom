package application.web.pages;

import static application.web.WebMobileApp.ORDER_URL_PROPERTY;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper {


    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public NavigationHelper(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public NavigationHelper toOrderPage() {
        driver.navigate().to(ORDER_URL_PROPERTY);
        return this;
    }
}
