package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAllOrdersActivity extends ApplicationActivity {

    private final By grid = By.id(APP_PACKAGE_NAME + ":id/txt_display_info");

    public FindAllOrdersActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
    }

    public String getOrders() {
        return getText(grid);
    }

    @Override
    public FindAllOrdersActivity closeKeyboard() {
        androidDriver.navigate().back();
        return this;
    }

    @Override
    public FindAllOrdersActivity back() {
        androidDriver.navigate().back();
        return this;
    }
}
