package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOrderActivity extends ActivityManager {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;
    private final By header = By.id(APP_PACKAGE_NAME + ":id/textView");
    private final By dateField = By.id(APP_PACKAGE_NAME + ":id/txt_order_date");
    private final By ownerNameField = By.id(APP_PACKAGE_NAME + ":id/txt_owner_name");
    private final By saveButton = By.id(APP_PACKAGE_NAME + ":id/bn_save");

    public AddOrderActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public String getHeaderText() {

        return getText(header);
    }

    public AddOrderActivity fillDate(String s) {
        fillText(dateField, s);
        return this;
    }

    public AddOrderActivity fillOwnerName(String s) {
        fillText(ownerNameField, s);
        return this;
    }

    public AddOrderActivity add() {
        clickTo(saveButton);
        return this;
    }
}
