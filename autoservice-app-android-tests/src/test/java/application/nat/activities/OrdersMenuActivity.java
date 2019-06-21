package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersMenuActivity extends ActivityManager {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;
    private final By addButton = By.id(APP_PACKAGE_NAME + ":id/bn_add_order");
    private final By findOneButton = By.id(APP_PACKAGE_NAME + ":id/bn_view_order");
    private final By findAllButton = By.id(APP_PACKAGE_NAME + ":id/bn_view_orders");
    private final By updateButton = By.id(APP_PACKAGE_NAME + ":id/bn_update_order");
    private final By deleteButton = By.id(APP_PACKAGE_NAME + ":id/bn_delete_order");

    public OrdersMenuActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        super(androidDriver, wait);
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public void goToAddOrder() {
        clickTo(addButton);
    }

    public void goToFindById() {
        clickTo(findOneButton);
    }

    public void goToFindAll() {
        clickTo(findAllButton);
    }

    public void goToUpdate() {
        clickTo(updateButton);
    }

    public void goToDelete() {
        clickTo(deleteButton);
    }
}
