package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteOrderActivity extends ApplicationActivity {

    private final By header = By.id(APP_PACKAGE_NAME + ":id/textView_delete");
    private final By id = By.id(APP_PACKAGE_NAME + ":id/txt_delete_order_id");
    private final By submitButton = By.id(APP_PACKAGE_NAME + ":id/delete_order_bn");

    public DeleteOrderActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
    }

    public String getHeader() {
        return getText(header);
    }

    public DeleteOrderActivity fillId(String s) {
        fillText(id, s);
        return this;
    }

    public DeleteOrderActivity submit() {
        clickTo(submitButton);
        return this;
    }

    @Override
    public DeleteOrderActivity closeKeyboard() {
        androidDriver.navigate().back();
        return this;
    }

    @Override
    public DeleteOrderActivity back() {
        androidDriver.navigate().back();
        return this;
    }
}
