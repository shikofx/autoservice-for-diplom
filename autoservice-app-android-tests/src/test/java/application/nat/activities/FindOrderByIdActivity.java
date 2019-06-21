package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindOrderByIdActivity extends ApplicationActivity {

    private final By grid = By.id(APP_PACKAGE_NAME + ":id/txt_display_info");

    public FindOrderByIdActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
    }

    public String getOrders() {
        return getText(grid);
    }

    @Override
    public FindOrderByIdActivity closeKeyboard() {
        androidDriver.navigate().back();
        return this;
    }

    @Override
    public FindOrderByIdActivity back() {
        androidDriver.navigate().back();
        return this;
    }
}
