package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAllOrdersActivity extends ActivityManager {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;
    private final By ordersGrid = By.id(APP_PACKAGE_NAME + ":id/txt_display_info");

    public FindAllOrdersActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public String getOrders() {
        return getText(ordersGrid);
    }
}
