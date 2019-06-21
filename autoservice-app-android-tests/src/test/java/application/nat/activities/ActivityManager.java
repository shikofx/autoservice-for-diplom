package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityManager {

    private AndroidDriver androidDriver;
    private WebDriverWait wait;

    protected final String APP_PACKAGE_NAME = "com.epam.autoserviceappapi";

    public ActivityManager(AndroidDriver androidDriver, WebDriverWait wait) {
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public void fillText(By locator, String text) {
        WebElement orderDateFieldElement = androidDriver.findElement(locator);
        orderDateFieldElement.click();
        orderDateFieldElement.sendKeys(text);
    }

    public void clickTo(By locator) {
        WebElement addOrderButton = androidDriver.findElement(locator);
        addOrderButton.click();
    }

    public String getText(By locator) {
        WebElement element = wait.until(d -> d.findElement(locator));
        return element.getText();
    }

    public boolean isKeyboardShown() {
        return androidDriver.isKeyboardShown();
    }

    public void closeKeyboard() {
        androidDriver.navigate().back();
    }

    public ActivityManager back() {
        androidDriver.navigate().back();
        return this;
    }

}
