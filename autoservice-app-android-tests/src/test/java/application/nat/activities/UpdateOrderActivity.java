package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateOrderActivity extends ApplicationActivity {

    private final By header = By.id(APP_PACKAGE_NAME + ":id/textView_update");
    private final By ownerName = By.id(APP_PACKAGE_NAME + ":id/txt_update_owner_name");
    private final By date = By.id(APP_PACKAGE_NAME + ":id/txt_update_order_date");
    private final By id = By.id(APP_PACKAGE_NAME + ":id/txt_update_order_id");
    private final By submit = By.id(APP_PACKAGE_NAME + ":id/bn_update_save");

    public UpdateOrderActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
    }

    public String getHeader() {
        return getText(header);
    }

    public UpdateOrderActivity fillId(String s) {
        fillText(id, s);
        return this;
    }

    public UpdateOrderActivity fillDate(String s) {
        fillText(date, s);
        return this;
    }

    public UpdateOrderActivity fillOwnerName(String ownerName) {
        fillText(this.ownerName, ownerName);
        return this;
    }

    public UpdateOrderActivity submit() {
        clickTo(submit);
        return this;
    }

    @Override
    public UpdateOrderActivity closeKeyboard() {
        androidDriver.navigate().back();
        return this;
    }

    @Override
    public UpdateOrderActivity back() {
        androidDriver.navigate().back();
        return this;
    }
}
