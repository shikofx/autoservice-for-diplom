package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOrderActivity extends ApplicationActivity {

    private final By header = By.id(APP_PACKAGE_NAME + ":id/textView");
    private final By date = By.id(APP_PACKAGE_NAME + ":id/txt_order_date");
    private final By ownerName = By.id(APP_PACKAGE_NAME + ":id/txt_owner_name");
    private final By submitButton = By.id(APP_PACKAGE_NAME + ":id/bn_save");

    public AddOrderActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
    }

    public String headerText() {
        return getText(header);
    }

    public AddOrderActivity fillDate(String s) {
        fillText(date, s);
        return this;
    }

    public AddOrderActivity fillOwnerName(String s) {
        fillText(ownerName, s);
        return this;
    }

    public AddOrderActivity submit() {
        clickTo(submitButton);
        return this;
    }

    public AddOrderActivity closeKeyboard() {
        androidDriver.navigate().back();
        return this;
    }

    public AddOrderActivity back() {
        androidDriver.navigate().back();
        return this;
    }
}
