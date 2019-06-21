package application.nat.activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ApplicationActivity {

    protected AndroidDriver androidDriver;
    protected WebDriverWait wait;

    final String APP_PACKAGE_NAME = "com.epam.autoserviceappapi";

    ApplicationActivity(AndroidDriver androidDriver, WebDriverWait wait) {
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    void fillText(By locator, String text) {
        WebElement orderDateFieldElement = androidDriver.findElement(locator);
        orderDateFieldElement.click();
        orderDateFieldElement.sendKeys(text);
    }

    void clickTo(By locator) {
        WebElement addOrderButton = androidDriver.findElement(locator);
        addOrderButton.click();
    }

    String getText(By locator) {
        WebElement element = wait.until(d -> d.findElement(locator));
        return element.getText();
    }
    public boolean isKeyboardShown() {
        return androidDriver.isKeyboardShown();
    }

    abstract Object closeKeyboard();

    abstract Object back();
}
