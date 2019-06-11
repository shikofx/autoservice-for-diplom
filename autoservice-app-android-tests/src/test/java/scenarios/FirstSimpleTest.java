package scenarios;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        prepareNative();
    }

    @Test
    public void simplestTest() {
        String appPackageName = "ru.descbook.polyglotfree:id/";
        By addPlayerButton = By.id(appPackageName + "mainMenuButtonAddPlayer");
        driver.findElement(addPlayerButton).click();

    }

    @AfterClass
    public static void tearDown() {
        driver.closeApp();
    }

}
