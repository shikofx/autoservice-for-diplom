package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateOrderActivity extends ActivityManager {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;
    private final By header = By.id(APP_PACKAGE_NAME + ":id/textView_update");
    private final By ownerNameField = By.id(APP_PACKAGE_NAME + ":id/txt_update_owner_name");
    private final By dateField = By.id(APP_PACKAGE_NAME + ":id/txt_update_order_date");
    private final By idField = By.id(APP_PACKAGE_NAME + ":id/txt_update_order_id");
    private final By updateButton = By.id(APP_PACKAGE_NAME + ":id/bn_update_save");

    public UpdateOrderActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public String getHeader() {
        return getText(header);
    }

    public UpdateOrderActivity fillId(String s) {
        fillText(idField, s);
        return this;
    }

    public UpdateOrderActivity fillDate(String s) {
        fillText(dateField, s);
        return this;
    }

    public UpdateOrderActivity fillOwnerName(String ownerName) {
        fillText(ownerNameField, ownerName);
        return this;
    }

    public UpdateOrderActivity update() {
        clickTo(updateButton);
        return this;
    }
}
