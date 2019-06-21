package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteOrderActivity extends ActivityManager {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;
    private final By header = By.id(APP_PACKAGE_NAME + ":id/textView_delete");
    private final By idField = By.id(APP_PACKAGE_NAME + ":id/txt_delete_order_id");
    private final By deleteButton = By.id(APP_PACKAGE_NAME + ":id/delete_order_bn");

    public DeleteOrderActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public String getHeader() {
        return getText(header);
    }

    public DeleteOrderActivity fillId(String s) {
        fillText(idField, s);
        return this;
    }

    public DeleteOrderActivity delete() {
        clickTo(deleteButton);
        return this;
    }
}
