package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersMenuActivity extends ApplicationActivity {

    private final By addButton = By.id(APP_PACKAGE_NAME + ":id/bn_add_order");
    private final By findOneButton = By.id(APP_PACKAGE_NAME + ":id/bn_view_order");
    private final By findAllButton = By.id(APP_PACKAGE_NAME + ":id/bn_view_orders");
    private final By updateButton = By.id(APP_PACKAGE_NAME + ":id/bn_update_order");
    private final By deleteButton = By.id(APP_PACKAGE_NAME + ":id/bn_delete_order");

    public OrdersMenuActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
    }

    public OrdersMenuActivity toAdd() {
        clickTo(addButton);
        return this;
    }

    public OrdersMenuActivity toFindOne() {
        clickTo(findOneButton);
        return this;
    }

    public OrdersMenuActivity toFindAll() {
        clickTo(findAllButton);
        return this;
    }

    public OrdersMenuActivity toUpdate() {
        clickTo(updateButton);
        return this;
    }

    public OrdersMenuActivity toDelete() {
        clickTo(deleteButton);
        return this;
    }

    @Override
    public OrdersMenuActivity closeKeyboard() {
        androidDriver.navigate().back();
        return this;
    }

    @Override
    public OrdersMenuActivity back() {
        androidDriver.navigate().back();
        return this;
    }
}
